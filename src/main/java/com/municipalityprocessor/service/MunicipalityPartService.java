package com.municipalityprocessor.service;

import com.municipalityprocessor.domain.MunicipalityPartDto;

/**
 * Service for storing municipality part data into a database.
 */
public interface MunicipalityPartService {

    /**
     * Stores a municipality part
     *
     * @param municipalityPart the municipality part
     */
    void saveMunicipalityPart(MunicipalityPartDto municipalityPart);

}
