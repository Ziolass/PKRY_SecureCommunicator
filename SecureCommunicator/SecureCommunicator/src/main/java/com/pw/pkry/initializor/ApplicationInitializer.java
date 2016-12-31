package com.pw.pkry.initializor;

import com.pw.pkry.gui.MainFrame;
import com.pw.pkry.input.ConfigurationReader;
import com.pw.pkry.models.ConfigurationModel;
import com.pw.pkry.network.Client;
import com.sun.javaws.Main;

/**
 * Created by michal.ziolkowski on 2016-10-14.
 */
public class ApplicationInitializer {
    public static void main(String[] args){

        ConfigurationModel configurationModel = ConfigurationReader.readConfig();
        Client client = new Client(configurationModel);
        MainFrame mainFrame = new MainFrame(client, configurationModel.getusername());
        mainFrame.setVisible(true);
        //client.init();

    }
}
