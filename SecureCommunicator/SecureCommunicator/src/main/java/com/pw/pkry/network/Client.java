package com.pw.pkry.network;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
import com.pw.pkry.models.ConfigurationModel;

import java.io.*;
import java.net.*;

public class Client {
    private String broadcast_port;
    public Client (ConfigurationModel configurationModel){
        this.broadcast_port = configurationModel.getBroadcast_port();
    }
    public void init() {

        String hostName = "localhost";
        String message = "a";

        try (
                Socket kkSocket = new Socket(hostName, Integer.parseInt(broadcast_port));
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            out.println("hello");
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}
