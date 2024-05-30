package com.municipalityprocessor.service.impl;

import com.municipalityprocessor.domain.MunicipalityEntity;
import com.municipalityprocessor.mapper.MunicipalityMapper;
import com.municipalityprocessor.domain.MunicipalityDto;
import com.municipalityprocessor.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MunicipalityService} for saving municipality data
 */
@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    private final MunicipalityMapper municipalityMapper;

    /**
     * Constructs a new MunicipalityPartServiceImpl.
     *
     * @param municipalityMapper the mapper for municipality data
     */
    @Autowired
    public MunicipalityServiceImpl(MunicipalityMapper municipalityMapper) {
        this.municipalityMapper = municipalityMapper;
    }

    public void saveMunicipality(MunicipalityDto municipality) {
        MunicipalityEntity municipalityEntity = new MunicipalityEntity();
        municipalityEntity.setName(municipality.getName());
        municipalityEntity.setCode(municipality.getCode());
        municipalityMapper.insertMunicipality(municipalityEntity);

    }
}
