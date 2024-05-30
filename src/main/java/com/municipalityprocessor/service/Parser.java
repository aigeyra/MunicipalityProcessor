package com.municipalityprocessor.service;

import com.municipalityprocessor.domain.MunicipalityDto;
import com.municipalityprocessor.domain.MunicipalityPartDto;

import java.util.List;

/**
 * Service for parsing XML data to extract municipalities and municipality parts.
 */
public interface Parser {
    /**
     * Parses municipalities from the given XML content.
     *
     * @param xml the XML content
     * @return a list of municipalities
     */
    List<MunicipalityDto> parseMunicipalities(String xml);

    /**
     * Parses municipality parts from the given XML content.
     *
     * @param xml the XML content
     * @return a list of municipality parts
     */
    List<MunicipalityPartDto> parseMunicipalityParts(String xml);
}
