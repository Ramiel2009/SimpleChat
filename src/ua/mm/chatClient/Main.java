package ua.mm.chatClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    private static BufferedReader in;
    private static PrintWriter out;
    public static void main (String args[]){

        Scanner scan = new Scanner(System.in);

        try {
            Socket socket = new Socket("127.0.0.1", 9999);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Echo socket server.\n Enter your message: \n");
            out.println(scan.nextLine());
            Resender resend = new Resender();
            resend.start();
            String str = "";
            while (true){
                str = scan.nextLine();
                out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static class Resender extends Thread{

        @Override
        public void run (){
            while (true){
                try {
                    String str = in.readLine();
                    System.out.println(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
