package com.municipalityprocessor.service;

/**
 * Service for downloading and unzipping XML files from a given URL.
 */
public interface DownloaderService {
    /**
     * Downloads a ZIP file from the provided URL, extracts the XML file, and returns its content as a String.
     *
     * @param url the URL to download the ZIP file from
     * @return the content of the XML file as a String
     */
    String downloadAndUnzipXml(String url);
}
