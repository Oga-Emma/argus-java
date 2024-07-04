package com.github.ogaemma.argus.model;

public class ArgusConfig {
    private String username = "";
    private String password = "";
    private String host = "";
    private String port = "";

    public ArgusConfig() {
    }

    public ArgusConfig(String username, String password, String host, String port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public ArgusConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ArgusConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHost() {
        return host;
    }

    public ArgusConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPort() {
        return port;
    }

    public ArgusConfig setPort(String port) {
        this.port = port;
        return this;
    }
}
