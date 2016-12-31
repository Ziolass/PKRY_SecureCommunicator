package com.pw.pkry.models;

/**
 * Created by michal.ziolkowski on 2016-10-14.
 */
public class ConfigurationModel {

    private final String listening_port;
    private final String broadcast_port;
    private final String username;

    public ConfigurationModel(String listening_port, String broadcast_port, String username) {
        this.listening_port = listening_port;
        this.broadcast_port = broadcast_port;
        this.username = username;

    }

    public String getBroadcast_port() {
        return broadcast_port;
    }

    public String getListening_port() {
        return listening_port;
    }

    public String getusername(){
        return username;
    }
}
