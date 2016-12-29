package com.pw.pkry.server.initializor;

import com.pw.pkry.server.gui.MainFrame;
import com.pw.pkry.server.input.ConfigurationReader;
import com.pw.pkry.server.models.ConfigurationModel;
import com.pw.pkry.server.network.MultiServer;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
public class ApplicationInitializer {
    public static void main(String[] args){

        ConfigurationModel configurationModel = ConfigurationReader.readConfig();
        MultiServer multiServer = new MultiServer(configurationModel);
        MainFrame mainFrame = new MainFrame(multiServer);
        mainFrame.setVisible(true);
        //multiServer.init(configurationModel);

    }
}

