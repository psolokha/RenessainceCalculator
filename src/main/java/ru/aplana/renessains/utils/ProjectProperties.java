package ru.aplana.renessains.utils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

    private static Properties properties;
    private static ProjectProperties instance;

    private ProjectProperties(){
        try {
            properties = new Properties();
            properties.load(new FileInputStream(new File("src/main/resources/settings.properties")));
        } catch (IOException e) {
            System.out.println("Error while opening property file");
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        if (properties == null) instance = new ProjectProperties();
        return properties;
    }

}
