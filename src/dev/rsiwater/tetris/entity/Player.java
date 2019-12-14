package dev.rsiwater.tetris.entity;

import dev.rsiwater.tetris.game.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.ArrayList;

public class Player extends Block
{
	private Asset asset;
	private Game game;
	private Random randomGenerator;
	private SettleBlock settleblock;
	private BufferedImage block, storedBlock, nextBlock, block_T;
	
	private int timer = 0;
	private int fallingSpeed = 60; 
	private int storedBlockCode, nextBlockCode;
	
	private int[][] map;
	private ArrayList<Integer> storedBlockxList, storedBlockyList, nextBlockxList, nextBlockyList;

	private boolean ifPressedR = false, ifPressedL = false, ifPressedU = false, ifPressedC = false, ifPressedSpace = false,isSettled = false;
	private boolean isGameover = false;
	
	private final int storedBlockX = 510, storedBlockY = 273, nextBlockX = 628, nextBlockY = 273;
	
	public Player(Game game,SettleBlock settleblock)
	{
		asset = new Asset();
		this.game = game;
		this.settleblock=settleblock;
		
		blockSize = 32;
		storedBlockCode = -1;
		justifyLocation = 40;
		
		randomGenerator=new Random();
		
		storedBlockxList = new ArrayList<Integer>(4);
		storedBlockyList = new ArrayList<Integer>(4);
		nextBlockxList = new ArrayList<Integer>(4);
		nextBlockyList = new ArrayList<Integer>(4);
		for(int i = 0;i < 4;i++)
		{
			storedBlockxList.add(0);
			storedBlockyList.add(0);
			nextBlockxList.add(0);
			nextBlockyList.add(0);
		}
		map=new int[10][21];
		
		blockCode = this.generateRandomSeed();
		nextBlockCode = this.generateRandomSeed();
		setBlock();
	}
	@Override
	public void setBlock()
	{
		switch(blockCode)
		{
		case 0:
			block = game.getAsset().blockI;
			block_T = game.getAsset().blockI_T;
			setBlockI();
			break;
		case 1:
			block = game.getAsset().blockJ;
			block_T = game.getAsset().blockJ_T;
			setBlockJ();
			break;
		case 2:
			block = game.getAsset().blockL;
			block_T = game.getAsset().blockL_T;
			setBlockL();
			break;
		case 3:
			block = game.getAsset().blockO;
			block_T = game.getAsset().blockO_T;
			setBlockO();
			break;
		case 4:
			block = game.getAsset().blockS;
			block_T = game.getAsset().blockS_T;
			setBlockS();
			break;
		case 5:
			block = game.getAsset().blockT;
			block_T = game.getAsset().blockT_T;
			setBlockT();
			break;
		case 6:
			block = game.getAsset().blockZ;
			block_T = game.getAsset().blockZ_T;
			setBlockZ();
			break;
		}		
	}
	public boolean isOver() {return isGameover;}
	public void setOver() {isGameover = false;}
	private void setStoredAndNextBlock()
	{
		switch(storedBlockCode)
		{
		case 0:
			storedBlock = game.getAsset().blockI;
			break;
		case 1:
			storedBlock = game.getAsset().blockJ;
			break;
		case 2:
			storedBlock = game.getAsset().blockL;
			break;
		case 3:
			storedBlock = game.getAsset().blockO;
			break;
		case 4:
			storedBlock = game.getAsset().blockS;
			break;
		case 5:
			storedBlock = game.getAsset().blockT;
			break;
		case 6:
			storedBlock = game.getAsset().blockZ;
			break;
		}
		switch(nextBlockCode)
		{
		case 0:
			nextBlock = game.getAsset().blockI;
			break;
		case 1:
			nextBlock = game.getAsset().blockJ;
			break;
		case 2:
			nextBlock = game.getAsset().blockL;
			break;
		case 3:
			nextBlock = game.getAsset().blockO;
			break;
		case 4:
			nextBlock = game.getAsset().blockS;
			break;
		case 5:
			nextBlock = game.getAsset().blockT;
			break;
		case 6:
			nextBlock = game.getAsset().blockZ;
			break;
		}
		setStoredAndNextBlockGraph(this.storedBlockxList,this.storedBlockyList,storedBlockCode);
		setStoredAndNextBlockGraph(this.nextBlockxList,this.nextBlockyList,nextBlockCode);
	}
	private void setStoredAndNextBlockGraph(ArrayList<Integer> xList, ArrayList<Integer> yList,int blockCode)
	{
		if(blockCode == -1) return;
		xList.clear();
		yList.clear();
		if(blockCode == 0)
		{
			for(int i = 0;i < 4;i++)
			{
				xList.add(0);
				yList.add(i);
			}
		}
		else if(blockCode == 1)
		{
			for(int i = 0;i < 4;i++)
			{
				if(i == 3)
				{
					xList.add(0);
					yList.add(2);
				}
				else
				{
					xList.add(1);
					yList.add(i);	
				}
			}
		}
		else if(blockCode == 2)
		{
			for(int i = 0;i < 4;i++)
			{
				if(i == 3)
				{
					xList.add(1);
					yList.add(2);
				}
				else
				{
					xList.add(0);
					yList.add(i);
				}
			}
		}
		else if(blockCode == 3)
		{
			for(int i = 0;i < 4;i++)
			{
				if(i >= 2)
				{
					xList.add(i - 2);
					yList.add(1);
				}
				else 
				{
					xList.add(i);
					yList.add(0);					
				}
			}
		}
		else if(blockCode == 4)
		{
			for(int i = 0;i < 4;i++)
			{
				if(i >= 2)
				{
					xList.add(i - 1);
					yList.add(0);
				}
				else 
				{
					xList.add(i);
					yList.add(1);
				}
			}
		}
		else if(blockCode == 5)
		{
			for(int i = 0;i < 3; i++)
			{
				xList.add(i);
				yList.add(1);
			}
			xList.add(1);
			yList.add(0);
		}
		else if(blockCode == 6)
		{
			for(int i = 0;i < 4;i++)
			{
				if(i >= 2)
				{
					xList.add(i - 1);
					yList.add(1);
				}
				else 
				{
					xList.add(i);
					yList.add(0);
				}
			}
		}
	}
	private int generateRandomSeed()
	{
		int randomSeed = randomGenerator.nextInt(70000);
		if(randomSeed < 10000) return 0;
		else if(randomSeed < 20000) return 1;
		else if(randomSeed < 30000) return 2;
		else if(randomSeed < 40000) return 3;
		else if(randomSeed < 50000) return 4;
		else if(randomSeed < 60000) return 5;
		else return 6;
	}
	//this variables is for tick() function.
	int frames = 0;
	int pressFramesLeft = 0,pressFramesRight = 0,pressFramesSpace = 0;
	int move = 0;
	boolean storedCoolDown = false;
	
	public void tick() 
	{
		map=settleblock.getMap();
		frames++;
		if(frames >= fallingSpeed && map[xList.get(0)+(int)x][yList.get(0)+(int)y+1]==-1 && map[xList.get(1)+(int)x][yList.get(1)+(int)y+1]==-1 && map[xList.get(2)+(int)x][yList.get(2)+(int)y+1]==-1 && map[xList.get(3)+(int)x][yList.get(3)+(int)y+1]==-1 && yList.get(0)+(int)y<19 && yList.get(1)+(int)y<19 && yList.get(2)+(int)y<19 && yList.get(3)+(int)y<19)
		{
			isSettled = false;
			y+=1;
			Ry+=1;
			frames = 0;
		}
		else if(frames>=60)
		{
			timer++;
			settleblock.setMap(blockCode,graphCode,x,y);
			x = 3;
			y = 0;
			setRB();
			blockCode = nextBlockCode;
			nextBlockCode = this.generateRandomSeed();
			setBlock();
			if(map[xList.get(0)+(int)x][yList.get(0)]!=-1 || map[xList.get(1)+(int)x][yList.get(1)]!=-1 || map[xList.get(2)+(int)x][yList.get(2)]!=-1 || map[xList.get(3)+(int)x][yList.get(3)]!=-1){
				isGameover = true;
			}
			setStoredAndNextBlock();
			frames = 0;
			isSettled = true;
			storedCoolDown = false;
		}
		
		
		if(game.getInputHandler().down)fallingSpeed = 5;
		else
		{
			if(timer > 30) fallingSpeed = 50;
			else if(timer > 60) fallingSpeed = 40;
			else if(timer > 90) fallingSpeed = 20;
			else if(timer > 120) fallingSpeed = 10;
			else fallingSpeed = 60;
		}
			
		
		if(!game.getInputHandler().left)
		{
			ifPressedL = false;
			pressFramesLeft = 0;
		}
		if(game.getInputHandler().left && x > 0) 
		{	
			if(!ifPressedL)
			{
				if(map[xList.get(0)+(int)x-1][yList.get(0)+(int)y]==-1 && map[xList.get(1)+(int)x-1][yList.get(1)+(int)y]==-1 && map[xList.get(2)+(int)x-1][yList.get(2)+(int)y]==-1 && map[xList.get(3)+(int)x-1][yList.get(3)+(int)y]==-1){
					x-=1;
					Rx-=1;
				}
				AudioEffects.startMusic(asset.MovePiece);
				ifPressedL = true;
			}
			else
			{
				pressFramesLeft++;
				if(pressFramesLeft >= 10 && !game.getInputHandler().right)
				{
					if(map[xList.get(0)+(int)x-1][yList.get(0)+(int)y]==-1 && map[xList.get(1)+(int)x-1][yList.get(1)+(int)y]==-1 && map[xList.get(2)+(int)x-1][yList.get(2)+(int)y]==-1 && map[xList.get(3)+(int)x-1][yList.get(3)+(int)y]==-1){
						x-=1;
						Rx-=1;
					}
					pressFramesLeft = 0;
				}
			}
		}
		
		if(!game.getInputHandler().up) ifPressedU = false;
		if(game.getInputHandler().up && !ifPressedU ) 
		{
			rotate();
			if(Ry>19)
			{
				setLB();
				setRB();
			}
			if(map[xList.get(0)+(int)x][yList.get(0)+(int)y]!=-1 || map[xList.get(1)+(int)x][yList.get(1)+(int)y]!=-1 || map[xList.get(2)+(int)x][yList.get(2)+(int)y]!=-1 || map[xList.get(3)+(int)x][yList.get(3)+(int)y]!=-1){
				rotate();
				rotate();
				rotate();
			}
			ifPressedU = true;
		}
		
		if(!game.getInputHandler().right)
		{
			ifPressedR = false;
			pressFramesRight = 0;
		}
		if(game.getInputHandler().right && Rx < 10 - 1)
		{
			if(!ifPressedR)
			{
				if(map[xList.get(0)+(int)x+1][yList.get(0)+(int)y]==-1 && map[xList.get(1)+(int)x+1][yList.get(1)+(int)y]==-1 && map[xList.get(2)+(int)x+1][yList.get(2)+(int)y]==-1 && map[xList.get(3)+(int)x+1][yList.get(3)+(int)y]==-1){
					x+=1;
					Rx+=1;
				}
				AudioEffects.startMusic(asset.MovePiece);
				ifPressedR = true;	
			}
			else
			{
				pressFramesRight++;
				if(pressFramesRight >= 10 && !game.getInputHandler().left)
				{
					pressFramesRight = 0;
					if(map[xList.get(0)+(int)x+1][yList.get(0)+(int)y]==-1 && map[xList.get(1)+(int)x+1][yList.get(1)+(int)y]==-1 && map[xList.get(2)+(int)x+1][yList.get(2)+(int)y]==-1 && map[xList.get(3)+(int)x+1][yList.get(3)+(int)y]==-1){
						x+=1;
						Rx+=1;
					}
				}
			}
		}
		if(!game.getInputHandler().space)
		{
			pressFramesSpace = 0;
			ifPressedSpace = false;
		}
		move=19;  //儲存移動到最上層所需移動的距離
		for(int i=0;i<4;i++){
			for(int j=0;;j++){
				if(map[xList.get(i)+(int)x][yList.get(i)+(int)y+j+1] != -1){
					if(j<move)
						move=j;
					break;
				}
				else if(yList.get(i)+(int)y+j==19){
					if(j<move)
						move=j;
					break;
				}
			}
		}
		if(game.getInputHandler().space && pressFramesSpace < 5 && !ifPressedSpace)
		{
			AudioEffects.startMusic(asset.BlockFall);
			pressFramesSpace++;
			ifPressedSpace = true;
			
			y += move;
			if(!isSettled) frames = 53;
			isSettled = true;
		}
		
		if(!game.getInputHandler().c)
		{
			ifPressedC = false;
		}
		if(game.getInputHandler().c && !ifPressedC && !storedCoolDown)
		{
			storedCoolDown = true;
			ifPressedC = true;
			if(storedBlockCode != -1)
			{
				storedBlockCode += blockCode;
				blockCode = storedBlockCode - blockCode;
				storedBlockCode -= blockCode;
			}
			else
			{
				storedBlockCode = blockCode;
				blockCode = this.generateRandomSeed();
			}
			setBlock();
			setStoredAndNextBlock();
			x = 3;
			y = 0;
			setRB();
			frames = 0;
		}
	}

	@Override
	public void render(Graphics g) 
	{
		for(int i = 0;i < 4;i++)
		{
			g.drawImage(block_T, justifyLocation + ( (this.xList.get(i)+(int)x) * blockSize ), justifyLocation + ( (this.yList.get(i)+(int)y+move) * blockSize ), null);
			g.drawImage(block, justifyLocation + ( (this.xList.get(i)+(int)x) * blockSize ), justifyLocation + ( (this.yList.get(i)+(int)y) * blockSize ), null);
			g.drawImage(storedBlock, storedBlockX + ( this.storedBlockxList.get(i) * blockSize ), storedBlockY + (this.storedBlockyList.get(i) * blockSize), null);
			g.drawImage(nextBlock, nextBlockX + (this.nextBlockxList.get(i) * blockSize), nextBlockY + (this.nextBlockyList.get(i) * blockSize), null);
		}
		
	}
}
