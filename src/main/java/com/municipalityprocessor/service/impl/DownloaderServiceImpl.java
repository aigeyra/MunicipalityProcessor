package com.municipalityprocessor.service.impl;

import com.municipalityprocessor.exception.XmlDownloadException;
import com.municipalityprocessor.exception.XmlUnzipException;
import com.municipalityprocessor.service.DownloaderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Implementation of {@link DownloaderService} for downloading and unzipping XML files from a given URL.
 */
@Service
public class DownloaderServiceImpl implements DownloaderService {

    public String downloadAndUnzipXml(String url) {
        RestTemplate restTemplate = new RestTemplate();
        byte[] zipBytes = restTemplate.getForObject(url, byte[].class);

        if (zipBytes == null) {
            throw new XmlDownloadException("Failed to download the zip file.");
        }

        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zipBytes);
             ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream)) {

            ZipEntry entry = zipInputStream.getNextEntry();

            if (entry != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
                return new String(outputStream.toByteArray());
            } else {
                throw new XmlDownloadException("No entries found in the zip file.");
            }
        } catch (Exception e) {
            throw new XmlUnzipException("Failed to unzip the file.", e);
        }
    }
}
