/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramsocket;

import java.io.*;

import java.net.*;



public class CubeServer {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started. Waiting for client...");



            Socket socket = serverSocket.accept();

            System.out.println("Client connected.");



            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);



            // Receive number from client

            String numberStr = in.readLine();

            int number = Integer.parseInt(numberStr);

            System.out.println("Received number from client: " + number);



            // Calculate cube

            int cube = number * number * number;



            // Send result back to client

            out.println(cube);

            System.out.println("Sent cube (" + cube + ") back to client.");



            // Close connections

            in.close();

            out.close();

            socket.close();

            serverSocket.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

}

