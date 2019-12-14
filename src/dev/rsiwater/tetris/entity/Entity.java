package dev.rsiwater.tetris.entity;

import java.awt.Graphics;

public abstract class Entity 
{
	protected float x=3,y=0;
	protected float Rx,Ry;
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
