CREATE DATABASE IF NOT EXISTS municipalities_data;

USE municipalities_data;

CREATE TABLE IF NOT EXISTS municipalities (
    municipality_code INT PRIMARY KEY,
    municipality_name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS municipality_parts (
    municipality_part_code INT PRIMARY KEY,
    municipality_part_name VARCHAR(30) NOT NULL,
    municipality_code INT,
    FOREIGN KEY (municipality_code) REFERENCES municipalities(municipality_code)
);

CREATE INDEX idx_municipality_code ON municipality_parts(municipality_code);