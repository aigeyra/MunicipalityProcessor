package com.municipalityprocessor.service;

import com.municipalityprocessor.exception.DatabaseOperationException;

/**
 * Service for processing XML data and storing it into a database.
 */
public interface DataProcessingService {

    /**
     * Processes data from the given URL.
     *
     * @param url the URL of the XML data source
     * @throws DatabaseOperationException if an error occurs during database operations
     */
    void processData(String url);
}
