package com.municipalityprocessor.service.impl;

import com.municipalityprocessor.controller.DataProcessingController;
import com.municipalityprocessor.domain.MunicipalityDto;
import com.municipalityprocessor.domain.MunicipalityPartDto;
import com.municipalityprocessor.exception.DatabaseOperationException;
import com.municipalityprocessor.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link DataProcessingService} for processing data by downloading, parsing, and saving it to the database.
 */
@Service
public class DataProcessingServiceImpl implements DataProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(DataProcessingController.class);

    private final DownloaderService xmlDownloaderService;

    private final DomXmlParser xmlParser;

    private final MunicipalityService municipalityService;

    private final MunicipalityPartService municipalityPartService;

    /**
     * Constructs a new DataProcessingService.
     *
     * @param xmlDownloaderService the service for downloading XML data
     * @param xmlParser the parser for XML data
     * @param municipalityService the service for storing municipality data
     * @param municipalityPartService the service for storing municipality part data
     */
    @Autowired
    public DataProcessingServiceImpl(DownloaderService xmlDownloaderService, DomXmlParser xmlParser, MunicipalityService municipalityService, MunicipalityPartService municipalityPartService) {
        this.xmlDownloaderService = xmlDownloaderService;
        this.xmlParser = xmlParser;
        this.municipalityService = municipalityService;
        this.municipalityPartService = municipalityPartService;
    }

    public void processData(String url) {
        logger.info("Downloading XML data from URL: {}", url);
        String xml = xmlDownloaderService.downloadAndUnzipXml(url);
        logger.info("Parsing municipalities from downloaded XML");
        List<MunicipalityDto> municipalities = xmlParser.parseMunicipalities(xml);
        logger.info("Parsing municipality parts from downloaded XML");
        List<MunicipalityPartDto> municipalityParts = xmlParser.parseMunicipalityParts(xml);

        for (MunicipalityDto municipality : municipalities) {
            logger.info("Saving municipality, code: {}, name: {}", municipality.getCode(), municipality.getName());
            try {
                municipalityService.saveMunicipality(municipality);
            } catch (Exception e) {
                throw new DatabaseOperationException("Failed to insert municipality: " + municipality.getCode(), e);
            }
        }

        for (MunicipalityPartDto municipalityPart : municipalityParts) {
            logger.info("Saving municipality part, code: {}, name: {}, municipality code: {}", municipalityPart.getCode(), municipalityPart.getName(), municipalityPart.getMunicipalityCode());
            try {
                municipalityPartService.saveMunicipalityPart(municipalityPart);
            } catch (Exception e) {
                throw new DatabaseOperationException("Failed to insert municipality part: " + municipalityPart.getCode(), e);
            }
        }
    }
}