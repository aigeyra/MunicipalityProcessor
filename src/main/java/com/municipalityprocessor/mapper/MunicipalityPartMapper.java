package com.municipalityprocessor.mapper;

import com.municipalityprocessor.domain.MunicipalityPartEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper for inserting municipality parts into database
 */
@Mapper
public interface MunicipalityPartMapper {
    @Insert("INSERT INTO municipality_parts (municipality_part_code, municipality_part_name, municipality_code) VALUES (#{code}, #{name}, #{municipalityCode})")
    void insertMunicipalityPart(MunicipalityPartEntity municipalityPartEntity);
}
