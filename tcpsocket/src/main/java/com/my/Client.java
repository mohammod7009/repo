package com.my;

import java.net.*;
import java.io.*;

public class Client {

    public static void main (String[] args) throws Exception {

    	Socket clientSocket = new Socket("localhost", 6666);
        System.out.println("Connected.");        

    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Message from Client!");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String resp = in.readLine();
        System.out.println(resp);

        in.close();
        out.close();
        clientSocket.close();
    }
 
}