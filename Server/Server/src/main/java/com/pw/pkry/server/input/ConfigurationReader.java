package com.pw.pkry.server.input;

import com.pw.pkry.server.models.ConfigurationModel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
public class ConfigurationReader {

    public static ConfigurationModel readConfig() {
        String configurationFile = "config.properties";
        ConfigurationModel configurationModel = null;
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(configurationFile)){

            prop.load(input);
            String listening_port = prop.getProperty("listening_port");
            configurationModel = new ConfigurationModel(listening_port);

            System.out.println("Listening port: "+listening_port);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nie udalo sie odnalezc pliku "+ configurationFile);
            System.out.println("Koncze dzialanie programu.");
            System.exit(1);
        }
        return configurationModel;
    }


}