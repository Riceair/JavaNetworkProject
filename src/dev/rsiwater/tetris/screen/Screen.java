package dev.rsiwater.tetris.screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dev.rsiwater.tetris.game.Audio;

import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;

public class Screen 
{
	public static final int WIDTH = 1600, HEIGHT = 720;
	public static final String NAME = "Tetris";
	private JFrame frame;
	private ScreenCanvas canvas;
	
	public Screen()
	{
		frame = new JFrame(NAME); 
		canvas = new ScreenCanvas();
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
	}
	
	public void display()
	{
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		ImageIcon icon = new ImageIcon("res/tenor.gif");
		JLabel label = new JLabel(icon);

		canvas.setFocusable(false);

		frame.getContentPane().add(label);	
		frame.setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(2);
			Audio.stopMusic();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.getContentPane().remove(label);
		frame.add(canvas);
		frame.pack();
		

	}
	
	public ScreenCanvas getCanvas() {return canvas;}
	public JFrame getFrame() {return frame;}
	
	public class ScreenCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 100, 100);
		}
	}

}

