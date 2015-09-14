package ua.mm.chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Connection extends Thread{
    private BufferedReader in;
    private PrintWriter out;
    public Connection(Socket socket) {


        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            try {

                String str = "";
                while (true) {
                    str = in.readLine();
                    out.println(str);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void run() {
        try {

            String str = "";
            while (true) {
                str = in.readLine();
                out.println(str);
                }
            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}