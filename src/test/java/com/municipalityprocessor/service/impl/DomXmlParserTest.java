package com.municipalityprocessor.service.impl;

import com.municipalityprocessor.domain.MunicipalityDto;
import com.municipalityprocessor.domain.MunicipalityPartDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomXmlParserTest {

    private DomXmlParser parser;
    private String xml;

    @BeforeEach
    void setUp() throws Exception {
        parser = new DomXmlParser();
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<vf:VymennyFormat>" +
                "   <vf:Data>" +
                "      <vf:Obce>" +
                "         <vf:Obec>" +
                "            <obi:Kod>1</obi:Kod>" +
                "            <obi:Nazev>A</obi:Nazev>" +
                "         </vf:Obec>" +
                "      </vf:Obce>" +
                "      <vf:CastiObci>" +
                "         <vf:CastObce>" +
                "            <coi:Kod>101</coi:Kod>" +
                "            <coi:Nazev>A1</coi:Nazev>" +
                "            <coi:Obec>" +
                "               <obi:Kod>1</obi:Kod>" +
                "            </coi:Obec>" +
                "         </vf:CastObce>" +
                "      </vf:CastiObci>" +
                "   </vf:Data>" +
                "</vf:VymennyFormat>";
    }

    @Test
    void testParseMunicipalities() {
        List<MunicipalityDto> municipalities = parser.parseMunicipalities(xml);
        assertEquals(1, municipalities.size());
        MunicipalityDto municipality = municipalities.get(0);
        assertEquals(1, municipality.getCode());
        assertEquals("A", municipality.getName());
    }

    @Test
    void testParseMunicipalityParts() {
        List<MunicipalityPartDto> municipalityParts = parser.parseMunicipalityParts(xml);
        assertEquals(1, municipalityParts.size());
        MunicipalityPartDto municipalityPart = municipalityParts.get(0);
        assertEquals(101, municipalityPart.getCode());
        assertEquals("A1", municipalityPart.getName());
        assertEquals(1, municipalityPart.getMunicipalityCode());
    }
}
