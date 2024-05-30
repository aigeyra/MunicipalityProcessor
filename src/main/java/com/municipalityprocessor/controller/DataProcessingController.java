package com.municipalityprocessor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.municipalityprocessor.exception.DatabaseOperationException;
import com.municipalityprocessor.exception.XmlParsingException;
import com.municipalityprocessor.service.DataProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling data processing requests.
 */
@RestController
@RequestMapping("/api")
public class DataProcessingController {
    private static final Logger logger = LoggerFactory.getLogger(DataProcessingController.class);
    private final DataProcessingService dataProcessingService;

    /**
     * Constructs a new DataProcessingController.
     *
     * @param dataProcessingService the data processing service
     */
    @Autowired
    public DataProcessingController(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    /**
     * Processes data from the given URL.
     *
     * @param url the URL of the XML data source
     * @return a ResponseEntity indicating the result of the operation
     */
    @Operation(summary = "Process data from the given URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data processed successfully"),
            @ApiResponse(responseCode = "400", description = "XML Parsing Error"),
            @ApiResponse(responseCode = "500", description = "Database Operation Error or unexpected error")
    })
    @PostMapping("/process-data")
    public ResponseEntity<String> processData(@Parameter(description = "URL of the XML data source", required = true) @RequestParam String url) {
        try {
            dataProcessingService.processData(url);
            logger.info("Data processed successfully for URL: {}", url);
            return ResponseEntity.ok("Data processed successfully");
        } catch (XmlParsingException e) {
            logger.error("XML Parsing Error for URL: {}", url, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("XML Parsing Error: " + e.getMessage());
        } catch (DatabaseOperationException e) {
            logger.error("Database Operation Error for URL: {}", url, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Database Operation Error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred for URL: {}", url, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
        }
    }
}
