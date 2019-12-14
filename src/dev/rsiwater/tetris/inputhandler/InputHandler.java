package dev.rsiwater.tetris.inputhandler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputHandler implements KeyListener
{
	private boolean[] key;
	public boolean up, down, left, right, space, c;
	
	public InputHandler()
	{
		key = new boolean[256];
	}
	
	public void tick()
	{
		up = key[KeyEvent.VK_UP];
		down = key[KeyEvent.VK_DOWN];
		left = key[KeyEvent.VK_LEFT];
		right = key[KeyEvent.VK_RIGHT];
		space = key[KeyEvent.VK_SPACE];
		c = key[KeyEvent.VK_C];
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		key[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		key[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
}
