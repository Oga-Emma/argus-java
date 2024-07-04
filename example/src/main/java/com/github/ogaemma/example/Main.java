package com.github.ogaemma.example;

import com.github.ogaemma.argus.ArgusClient;
import com.github.ogaemma.argus.ArgusTCPServer;
import com.github.ogaemma.argus.model.ArgusConfig;
import com.github.ogaemma.argus.model.ArgusEvent;
import com.github.ogaemma.argus.model.EventCallback;

public class Main {
    public static void main(String[] args) {
        ArgusConfig argusConfig = new ArgusConfig()
                .setHost("127.0.0.1")
                .setPort("1337")
                .setUsername("testuser")
                .setPassword("testpassword");

        ArgusTCPServer argusServer = new ArgusTCPServer();

        ArgusClient client = new ArgusClient(argusServer, argusConfig);
        client.listenToEvents(new EventCallback() {
            @Override
            public void onEventReceived(ArgusEvent argusEvent) {
                System.out.println("Received event " + argusEvent.toString());
            }
        });
    }
}