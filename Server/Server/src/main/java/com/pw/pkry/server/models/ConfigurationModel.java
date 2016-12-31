package com.pw.pkry.server.models;

/**
 * Created by michal.ziolkowski on 2016-12-08.
 */
public class ConfigurationModel {

    private final String listening_port;

    public ConfigurationModel(String listening_port) {
        this.listening_port = listening_port;

    }

    public String getListening_port() {
        return listening_port;
    }
}