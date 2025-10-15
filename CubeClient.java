/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramsocket;

import java.io.*;

import java.net.*;

import java.util.Scanner;

public class CubeClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);



            // Ask user for number

            System.out.print("Enter a number: ");

            int num = sc.nextInt();



            // Send number to server

            out.println(num);



            // Receive cube from server

            String cube = in.readLine();

            System.out.println("Cube of " + num + " received from server: " + cube);



            // Close connections

            sc.close();

            in.close();

            out.close();

            socket.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

}

