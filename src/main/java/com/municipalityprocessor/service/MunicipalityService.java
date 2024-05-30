package com.municipalityprocessor.service;

import com.municipalityprocessor.domain.MunicipalityDto;

/**
 * Service for storing municipality data into a database.
 */
public interface MunicipalityService {

    /**
     * Stores a municipality
     *
     * @param municipality the municipality
     */
    void saveMunicipality(MunicipalityDto municipality);
}
