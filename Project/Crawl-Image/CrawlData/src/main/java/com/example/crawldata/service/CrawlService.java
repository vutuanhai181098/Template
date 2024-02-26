package com.example.crawldata.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@Slf4j
public class CrawlService {

    private final ImageService imageService;
    private final String DOWNLOAD_PATH = System.getProperty("user.dir") + "/downloads";

    // Create a download folder if it doesn't exist
    private void createDownloadFolder(String downloadPath) {
        File downloadFolder = new File(downloadPath);
        if(!downloadFolder.exists()){
            downloadFolder.mkdir();
        }
    }

    // Setup Chrome Driver
    public CrawlService(ImageService imageService) {
        this.imageService = imageService;
        createDownloadFolder(DOWNLOAD_PATH);
        WebDriverManager.chromedriver().setup();
    }

    // Crawl data and save to database
    public void crawlAndSaveImage(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        List<WebElement> image
    }
}
