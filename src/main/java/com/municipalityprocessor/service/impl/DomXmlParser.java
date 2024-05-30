package com.municipalityprocessor.service.impl;

import com.municipalityprocessor.domain.MunicipalityDto;
import com.municipalityprocessor.domain.MunicipalityPartDto;
import com.municipalityprocessor.exception.XmlParsingException;
import com.municipalityprocessor.service.Parser;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link Parser} for parsing XML data using DOM parser.
 */
@Service
public class DomXmlParser implements Parser {

    private final DocumentBuilderFactory factory;
    private final DocumentBuilder builder;

    /**
     * Constructs a new DomXmlParser.
     */
    public DomXmlParser() throws Exception {
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
    }

    public List<MunicipalityDto> parseMunicipalities(String xml) {
        List<MunicipalityDto> municipalities = new ArrayList<>();
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes())) {
            Document document = builder.parse(inputStream);
            NodeList municipalityList = document.getElementsByTagName("vf:Obec");
            for (int i = 0; i < municipalityList.getLength(); i++) {
                Element municipalityElement = (Element) municipalityList.item(i);
                int code = Integer.parseInt(getElementValue(municipalityElement, "obi:Kod"));
                String name = getElementValue(municipalityElement, "obi:Nazev");
                MunicipalityDto municipality = new MunicipalityDto();
                municipality.setCode(code);
                municipality.setName(name);
                municipalities.add(municipality);
            }
        } catch (Exception e) {
            throw new XmlParsingException("Failed to parse municipalities from XML", e);
        }
        return municipalities;
    }

    public List<MunicipalityPartDto> parseMunicipalityParts(String xml) {
        List<MunicipalityPartDto> municipalityParts = new ArrayList<>();
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes())) {
            Document document = builder.parse(inputStream);
            NodeList municipalityPartList = document.getElementsByTagName("vf:CastObce");
            for (int i = 0; i < municipalityPartList.getLength(); i++) {
                Element municipalityPartElement = (Element) municipalityPartList.item(i);
                int code = Integer.parseInt(getElementValue(municipalityPartElement, "coi:Kod"));
                String name = getElementValue(municipalityPartElement, "coi:Nazev");
                int municipalityCode = Integer.parseInt(getElementValue(municipalityPartElement, "obi:Kod"));
                MunicipalityPartDto municipalityPart = new MunicipalityPartDto();
                municipalityPart.setCode(code);
                municipalityPart.setName(name);
                municipalityPart.setMunicipalityCode(municipalityCode);
                municipalityParts.add(municipalityPart);
            }
        } catch (Exception e) {
            throw new XmlParsingException("Failed to parse municipality parts from XML", e);
        }
        return municipalityParts;
    }

    private String getElementValue(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}