package com.futuresimple.app.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
    Properties pro;

    public ConfigDataProvider() throws IOException {
        File src = new File("./Config/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Not able to load file >>" + e.getLocalizedMessage());
        }
    }

    public String getDataFromConfig(String keyToSearch) {
        return pro.getProperty(keyToSearch);
    }

    public String getBrowser() {
        return pro.getProperty("Browser");
    }

    public String getStringURL() {
        return pro.getProperty("qaUrl");
    }
}

