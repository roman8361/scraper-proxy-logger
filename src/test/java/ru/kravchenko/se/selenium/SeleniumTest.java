package ru.kravchenko.se.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
     //   System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        String proxy = "5.9.218.107:1080";
        ChromeOptions options = new ChromeOptions().addArguments("--proxy-server=http://" + proxy);
        WebDriver driver = new ChromeDriver(options);

      //  WebDriver driver = new ChromeDriver();
   //     driver.get("https://www.marathonbet.com");
        driver.get("https://2ip.ru/");
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

}
