package dev.rsiwater.tetris.game;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class ImageLoader 
{
	public static BufferedImage loadImage(String path)
	{
		try
		{
			return ImageIO.read(ImageLoader.class.getResource(path));
		}catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
