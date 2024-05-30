package com.municipalityprocessor.domain;

/**
 * Represents a municipality data transfer object.
 */
public class MunicipalityDto {
    private int code;
    private String name;

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
}
