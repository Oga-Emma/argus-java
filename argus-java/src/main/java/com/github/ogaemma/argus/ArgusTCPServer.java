package com.github.ogaemma.argus;

import com.github.ogaemma.argus.helper.Constants;

import java.io.*;
import java.net.Socket;

public class ArgusTCPServer {

    private Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    public ArgusTCPServer() {
    }

    public Socket startConnection(String host, String port) throws IOException {
        String hostName = !host.isBlank() ? host : Constants.DEFAULT_HOST;
        int portNumber = Integer.parseInt(!port.isBlank() ? port : Constants.DEFAULT_PORT);

        socket = new Socket(hostName, portNumber);

        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataInputStream = new DataInputStream(socket.getInputStream());

        return socket;
    }

    public void closeConnection() throws IOException {
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }

    public void sendData(String connectionString) throws IOException {
        dataOutputStream.write(connectionString.getBytes());
    }

    public int readByte(byte[] buffer) throws IOException {
        return dataInputStream.read(buffer);
    }
}
