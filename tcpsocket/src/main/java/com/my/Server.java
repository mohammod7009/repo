package com.my;

import java.net.*;
import java.io.*;

public class Server {

	public static void main (String[] args) throws Exception {
	    
	    ServerSocket serverSocket = new ServerSocket(6666);        
        System.out.println("Waiting for connection...");        

        Socket clientSocket = serverSocket.accept();        
        System.out.println("Connected.");        
        
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String msg = in.readLine();        
        System.out.println(msg);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Reply from Server!");        

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
 }