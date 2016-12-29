package com.pw.pkry.network;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
import com.pw.pkry.gui.MainFrame;
import com.pw.pkry.models.ConfigurationModel;

import java.io.*;
import java.net.*;

public class Client {
    private String broadcast_port;
    private MainFrame parent;
    private PrintWriter out;
    public Client (ConfigurationModel configurationModel){
        this.broadcast_port = configurationModel.getBroadcast_port();
    }
    public void setParent(MainFrame mainFrame){
        this.parent = mainFrame;
    }
    public void init() {

        String hostName = "localhost";

        try (
                Socket kkSocket = new Socket(hostName, Integer.parseInt(broadcast_port));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()))
        )
        {

            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            String fromServer;
            String fromUser;

            while (true) {
                fromServer = in.readLine();
                parent.getTextArea().append(fromServer+"\n");
                //System.out.println("Server: " + fromServer);

                //fromUser = stdIn.readLine();
//                if (fromUser != null) {
//                    System.out.println("Client: " + fromUser);
//                    out.println(fromUser);
//                }
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
    public void sendMessage(String message){
        try{
            out.println(message);
            //this.parent.getTextArea().append(message+"\n");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
