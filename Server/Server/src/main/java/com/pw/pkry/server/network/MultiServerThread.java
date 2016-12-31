package com.pw.pkry.server.network;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MultiServerThread extends Thread {
    private Socket socket = null;
    private static List<PrintWriter> writerList = new ArrayList<>();
    private static String outputLine;

    public MultiServerThread(Socket socket) {
        super("MultiServerThread");
        this.socket = socket;
    }

    public void run() {

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream())))
        {
            if (writerList != null){
                writerList.add(out);

            }
            String inputLine;

            while (true) {
                inputLine = in.readLine();
                //System.out.println(inputLine);
                outputLine = inputLine;
                for (PrintWriter printWriter: writerList){
                    printWriter.println(outputLine);
                }
                //out.println(outputLine);
                //if (outputLine.equals("Bye"))
                  //  break;
            }
        }
        catch (SocketException  se){
            System.out.println("Client disconnected");
        } catch (IOException e) {
            e.printStackTrace();
            try{
                socket.close();

            } catch (IOException ioe){
                ioe.printStackTrace();
            }

        }
    }
}
