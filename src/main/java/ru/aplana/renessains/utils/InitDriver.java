package ru.aplana.renessains.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InitDriver {

    private static WebDriver driver;
    private static InitDriver instance;

    private InitDriver(){

        Properties properties = ProjectProperties.getProperties();

        switch (System.getProperties().getProperty("browser")) {
            case "chrome": System.setProperty(properties.getProperty("chromeDriver"), properties.getProperty("chromeDriverPath"));
                            driver = new ChromeDriver();
                            break;
            case "firefox": System.setProperty(properties.getProperty("geckoDriver"), properties.getProperty("geckoDriverPath"));
                            driver = new FirefoxDriver();
                            break;
        }

        driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("timeout.implicitlyWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty("timeout.pageLoad")),TimeUnit.SECONDS);
        driver.get(properties.getProperty("indexPage"));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) instance = new InitDriver();
        return driver;
    }
}
