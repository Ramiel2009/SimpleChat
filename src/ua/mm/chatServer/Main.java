package ua.mm.chatServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Maxim on 9/13/15.
 */
public class Main {

    public static void main (String args []){
        try {
            ServerSocket servSocket = new ServerSocket(9999);
            while (true){
                Socket socket = servSocket.accept();
                Connection con = new Connection(socket);
                con.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
