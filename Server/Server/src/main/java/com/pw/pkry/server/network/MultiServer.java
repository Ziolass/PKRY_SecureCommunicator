package com.pw.pkry.server.network;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
import com.pw.pkry.server.models.ConfigurationModel;

import java.net.*;
import java.io.*;

public class MultiServer {
    private final int listeningPort;
    private boolean listening;

    public MultiServer(ConfigurationModel configurationModel){
        this.listeningPort = Integer.parseInt(configurationModel.getListening_port());
    }
    public void init()  {
        listening = true;
        try (ServerSocket serverSocket = new ServerSocket(listeningPort)) {
            while (listening) {
                System.out.println("Began listening on port: " + listeningPort);
                new MultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + listeningPort);
            System.exit(1);
        }
    }
}