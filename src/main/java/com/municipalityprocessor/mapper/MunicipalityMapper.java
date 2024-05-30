package com.municipalityprocessor.mapper;

import com.municipalityprocessor.domain.MunicipalityEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper for inserting municipalities into database
 */
@Mapper
public interface MunicipalityMapper {
    @Insert("INSERT INTO municipalities (municipality_code, municipality_name) VALUES (#{code}, #{name})")
    void insertMunicipality(MunicipalityEntity municipalityEntity);
}
