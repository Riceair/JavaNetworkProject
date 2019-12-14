package dev.rsiwater.tetris.main;

import dev.rsiwater.tetris.game.*;

public class MainProc 
{
	private static Game game;
	
	public static void main (String args[])
	{
		game = new Game();
		game.start();
		//main program.
	}
}
