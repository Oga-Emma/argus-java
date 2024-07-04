package com.github.ogaemma.argus.example;

import com.github.ogaemma.argus.ArgusClient;
import com.github.ogaemma.argus.core.ArgusTCPServer;
import com.github.ogaemma.argus.exception.ArgusException;
import com.github.ogaemma.argus.model.ArgusConfig;
import com.github.ogaemma.argus.model.ArgusEvent;
import com.github.ogaemma.argus.core.ArgusEventListener;

public class Main {
    public static void main(String[] args) {
        ArgusConfig argusConfig = new ArgusConfig()
                .setHost("127.0.0.1")
                .setPort("1337")
                .setUsername("testuser")
                .setPassword("testpassword");

        ArgusTCPServer argusServer = new ArgusTCPServer();

        ArgusClient client = new ArgusClient(argusServer, argusConfig);
        client.listen(new ArgusEventListener() {
            @Override
            public void onEvent(ArgusEvent argusEvent) {
                System.out.println("Received event " + argusEvent.toString());
            }

            @Override
            public void onException(ArgusException exception) {
                System.out.println(exception.getMessage());
            }
        });

        //To close the connection call
        // client.close();
    }
}