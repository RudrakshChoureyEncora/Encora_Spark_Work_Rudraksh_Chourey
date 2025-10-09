package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket s;BufferedReader keyin,in;PrintWriter out;
	public Client() {
		try {
			while(true) {
			s=new Socket("localhost",2000);
			in=new BufferedReader
					(new InputStreamReader(s.getInputStream()));
			String msgFromServer=in.readLine();
			System.out.println("Message From Server..:"+msgFromServer);
			
			keyin=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Type Message for Server..:");
			String msgToServer=keyin.readLine();
			out=new PrintWriter(s.getOutputStream(),true);
			out.println(msgToServer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}