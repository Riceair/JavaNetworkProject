package dev.rsiwater.tetris.entity;

import dev.rsiwater.tetris.game.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.ArrayList;

public class GameClient extends Block implements Runnable {
	private byte myNumber;
	private Socket socket;
	private boolean start;  //確認找到對手
	private BufferedOutputStream out;
	private BufferedInputStream in;
	private final String SERVER="127.0.0.1"; //"192.168.43.84";
	private int PORT;
	private final int TIMEOUT=15000;
	
	public GameClient(int port,byte myNumber) {
		PORT=port;
		this.myNumber=myNumber;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		try {
			socket=new Socket(SERVER,PORT);
			out=new BufferedOutputStream(socket.getOutputStream());
			in=new BufferedInputStream(socket.getInputStream());
			
			out.write("Connect".getBytes());
			out.flush();
			socket.shutdownOutput();
			byte[] myNumber = new byte[1024];
			
			in.read(myNumber, 0, myNumber.length);////////////////////////////
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Time out");
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlock() {
		// TODO Auto-generated method stub
		
	}
	
	public void run() {
		
	}
}
