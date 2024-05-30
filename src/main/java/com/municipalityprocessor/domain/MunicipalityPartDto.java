package com.municipalityprocessor.domain;

/**
 * Represents a municipality part data transfer object.
 */
public class MunicipalityPartDto {
    private int code;
    private String name;
    private int municipalityCode;

    // Getters and setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(int municipalityCode) {
        this.municipalityCode = municipalityCode;
    }
}
