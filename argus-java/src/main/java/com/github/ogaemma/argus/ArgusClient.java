package com.github.ogaemma.argus;

import com.github.ogaemma.argus.helper.Constants;
import com.github.ogaemma.argus.helper.JsonHelper;
import com.github.ogaemma.argus.model.ArgusConfig;
import com.github.ogaemma.argus.model.ArgusEvent;
import com.github.ogaemma.argus.model.ArgusException;
import com.github.ogaemma.argus.model.EventCallback;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ArgusClient extends Thread {
    private final ArgusConfig argusConfig;
    private final ArgusTCPServer argusServer;
    private EventCallback eventCallback;

    public ArgusClient(ArgusTCPServer argusServer, ArgusConfig argusConfig) {
        this.argusConfig = argusConfig;
        this.argusServer = argusServer;
    }

    /**
     * Starts a connection to argus server in a new thread.
     */
    @Override
    public void run() {
        try (Socket ignored = argusServer.startConnection(argusConfig.getHost(), argusConfig.getPort())) {
            authenticate();

            System.out.println("Listening to event");
            byte[] buffer = new byte[Constants.DEFAULT_BUFFER_SIZE];

            while (argusServer.readByte(buffer) > 0) {
                String data = new String(buffer, StandardCharsets.UTF_8);

                if (JsonHelper.isJson(data)) {
                    ArgusEvent argusEvent = JsonHelper.parseJson(data);
                    eventCallback.onEventReceived(argusEvent);
                } else {
                    System.out.println(data);
                }
            }

        } catch (Exception ex) {
            throw new ArgusException(ex.getMessage());
        }
    }

    /**
     * Starts argus server
     * @param eventCallback - event callback
     */
    public void listenToEvents(EventCallback eventCallback) {
        this.eventCallback = eventCallback;
        this.start();
    }

    /**
     * Closes all connection and kills the thread.
     * @throws IOException - IOException
     */
    public void disconnect() throws IOException {
        eventCallback = null;
        argusServer.closeConnection();
        interrupt();
    }

    /**
     * Sends authentication data to argus server
     * @throws IOException - IOException
     */
    private void authenticate() throws IOException {
        String connectionString = String.format("<ArgusAuth>%s:%s</ArgusAuth>", argusConfig.getUsername(), argusConfig.getPassword());
        argusServer.sendData(connectionString);
    }
}
