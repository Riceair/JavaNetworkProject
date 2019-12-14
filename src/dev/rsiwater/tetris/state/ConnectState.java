package dev.rsiwater.tetris.state;

import java.awt.Graphics;
import java.io.*;
import java.net.*;

import dev.rsiwater.tetris.game.Game;

public class ConnectState extends State {
	private Socket socket;
	private BufferedOutputStream out;
	private BufferedInputStream in;
	private byte myNumber; //取得我的代號
	private boolean getNumber;
	private byte[] returnMessage;
	private int timeOutTimes;
	private final String SERVER = "192.168.137.217";
	private final int PORT = 20;
	private final int TIMEOUT=15000;
	private int myflag;
	private final int STARTNUM=3;
	
	public ConnectState(Game game) {
		super(game);
		timeOutTimes=0;
		myflag=0;
		returnMessage=new byte[1024];
		// TODO Auto-generated constructor stub
	}
	
	public byte getNumber() { return myNumber; }
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		try{
			socket=new Socket(SERVER,PORT);
			in=new BufferedInputStream(socket.getInputStream());
			out=new BufferedOutputStream(socket.getOutputStream());
			
			out.write(myflag);
			out.flush();
			socket.shutdownOutput();
			//
			
			System.out.println(myflag);
			int readNum=in.read();
			if(readNum!=STARTNUM) {
				if(myflag==0)
					myflag=readNum;
			}
			else if(readNum==STARTNUM) {
				System.out.println(readNum);
				getNumber=true;
			}
				
			socket.close();
		}
		catch(IOException e) {
			System.out.println("Time out");
			timeOutTimes++;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(game.getAsset().loading,0,0,null);
	}

	@Override
	public boolean isOver() {
		// TODO Auto-generated method stub
		//return true;
		if(getNumber)
			return true;
		else
			return false;
	}

	@Override
	public boolean ifStop() {
		// TODO Auto-generated method stub
		if(timeOutTimes>10)
			return true;
		else
			return false;
	}

}
