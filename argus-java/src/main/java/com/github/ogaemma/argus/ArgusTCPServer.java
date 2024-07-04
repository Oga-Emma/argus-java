package com.github.ogaemma.argus;

import java.io.*;
import java.net.Socket;

public class ArgusTCPServer {

    private Socket socket;
    private PrintWriter printWriter;
    BufferedReader bufferedReader;
    DataInputStream dataInputStream;

    public ArgusTCPServer() {
    }

    public Socket startConnection(String host, String port) throws IOException {
        socket = this.getSocket(host, port);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataInputStream = new DataInputStream(socket.getInputStream());

        return socket;
    }

    private Socket getSocket(String host, String port) throws IOException {
        if (socket == null || socket.isClosed()) {
            String DEFAULT_HOST = "127.0.0.1";
            String hostName = !host.isBlank() ? host : DEFAULT_HOST;

            String DEFAULT_PORT = "1337";
            int portNumber = Integer.parseInt(!port.isBlank() ? port : DEFAULT_PORT);

            socket = new Socket(hostName, portNumber);
        }

        return socket;
    }

    public void closeConnection() throws IOException {
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }

    public void sendData(String connectionString) {
        printWriter.write(connectionString);
    }

    public int readByte(byte[] buffer) throws IOException {
        return dataInputStream.read(buffer);
    }
}
