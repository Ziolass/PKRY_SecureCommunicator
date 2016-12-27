package com.pw.pkry.server.network;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
import com.pw.pkry.server.models.ConfigurationModel;

import java.net.*;
import java.io.*;

public class MultiServer {

    public void init(ConfigurationModel configurationModel)  {

        int portNumber = Integer.parseInt(configurationModel.getListening_port());
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                System.out.println("Began listening on port: " + portNumber);
                new MultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}