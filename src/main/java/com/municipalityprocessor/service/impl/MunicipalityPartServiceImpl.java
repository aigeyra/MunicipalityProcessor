package com.municipalityprocessor.service.impl;

import com.municipalityprocessor.domain.MunicipalityPartDto;
import com.municipalityprocessor.domain.MunicipalityPartEntity;
import com.municipalityprocessor.mapper.MunicipalityPartMapper;
import com.municipalityprocessor.service.MunicipalityPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link MunicipalityPartService} for saving municipality part data
 */
@Service
public class MunicipalityPartServiceImpl implements MunicipalityPartService {

    private final MunicipalityPartMapper municipalityPartMapper;

    /**
     * Constructs a new MunicipalityPartServiceImpl.
     *
     * @param municipalityPartMapper the mapper for municipality part data
     */
    @Autowired
    public MunicipalityPartServiceImpl(MunicipalityPartMapper municipalityPartMapper) {
        this.municipalityPartMapper = municipalityPartMapper;
    }

    public void saveMunicipalityPart(MunicipalityPartDto municipalityPart) {
        MunicipalityPartEntity municipalityPartEntity = new MunicipalityPartEntity();
        municipalityPartEntity.setName(municipalityPart.getName());
        municipalityPartEntity.setCode(municipalityPart.getCode());
        municipalityPartEntity.setMunicipalityCode(municipalityPart.getMunicipalityCode());
        municipalityPartMapper.insertMunicipalityPart(municipalityPartEntity);

    }
}
