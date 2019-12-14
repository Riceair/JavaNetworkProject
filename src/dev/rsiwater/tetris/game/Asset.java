package dev.rsiwater.tetris.game;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Asset 
{
	public static BufferedImage blockI, blockJ, blockL, blockO, blockS, blockT, blockZ;
	public static BufferedImage blockI_T, blockJ_T, blockL_T, blockO_T, blockS_T, blockT_T, blockZ_T;
	public static BufferedImage options,cursor,loading;
	public static BufferedImage BG,GameStage,scoreBoard,EnemyscoreBoard,grid,Enemygrid;
	public static BufferedImage overImg2, overImg3, overImg4, overButtom;
	public static BufferedImage num0,num1,num2,num3,num4,num5,num6,num7,num8,num9;
	public static BufferedImage Bnum0,Bnum1,Bnum2,Bnum3,Bnum4,Bnum5,Bnum6,Bnum7,Bnum8,Bnum9;
	public static String openingMusic, gameMusic,Single,BlockFall,MovePiece,Cursor;
	public static Image welcomeBG;
	public static final int WIDTH = 32,HEIGHT = 32;
	public void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/sheet.png"));
		SpriteSheet Transparent_sheet = new SpriteSheet(ImageLoader.loadImage("/sheet_transparent.png"));
		
		Single = new String("res/Single.wav");
		BlockFall = new String("res/BlockFall.wav");
		MovePiece = new String("res/MovePiece.wav");
		Cursor = new String("res/Cursor.wav");
		openingMusic = new String("res/Audio.wav");
		gameMusic = new String("res/GameMusic.wav");
		loading=ImageLoader.loadImage("/loading.png");
		cursor = ImageLoader.loadImage("/cursor.png");
		options = ImageLoader.loadImage("/Press S to start.png");
		welcomeBG = new ImageIcon("res/Welcome.gif").getImage();
		BG = ImageLoader.loadImage("/Game process.gif");
		GameStage = ImageLoader.loadImage("/GameStage.png");
		scoreBoard = ImageLoader.loadImage("/HOLD.png");
		EnemyscoreBoard=ImageLoader.loadImage("/HOLD.png");
		grid = ImageLoader.loadImage("/10_20Grid.png");
		Enemygrid=ImageLoader.loadImage("/10_20Grid.png");
		overImg2 = ImageLoader.loadImage("/bullethole3.png");
		overImg3 = ImageLoader.loadImage("/bullethole4.png");
		overImg4 = ImageLoader.loadImage("/bullethole5.png");
		overButtom = ImageLoader.loadImage("/GAMEOVER(73_105).png");
		blockI = sheet.crop(0, 0, WIDTH, HEIGHT);
		blockJ = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		blockL = sheet.crop(2*WIDTH, 0, WIDTH, HEIGHT);
		blockO = sheet.crop(3*WIDTH, 0, WIDTH, HEIGHT);
		blockS = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		blockT = sheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		blockZ = sheet.crop(2*WIDTH, HEIGHT, WIDTH, HEIGHT);
		blockI_T = Transparent_sheet.crop(0, 0, WIDTH, HEIGHT);
		blockJ_T = Transparent_sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		blockL_T = Transparent_sheet.crop(2*WIDTH, 0, WIDTH, HEIGHT);
		blockO_T = Transparent_sheet.crop(3*WIDTH, 0, WIDTH, HEIGHT);
		blockS_T = Transparent_sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		blockT_T = Transparent_sheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
		blockZ_T = Transparent_sheet.crop(2*WIDTH, HEIGHT, WIDTH, HEIGHT);
		num0 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_0.png");
		num1 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_1.png");
		num2 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_2.png");
		num3 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_3.png");
		num4 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_4.png");
		num5 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_5.png");
		num6 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_6.png");
		num7 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_7.png");
		num8 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_8.png");
		num9 = ImageLoader.loadImage("/LETTERSMALL/easy_temp_9.png");

		Bnum0 = ImageLoader.loadImage("/LETTERBIG/easy_temp_0.png");
		Bnum1 = ImageLoader.loadImage("/LETTERBIG/easy_temp_1.png");
		Bnum2 = ImageLoader.loadImage("/LETTERBIG/easy_temp_2.png");
		Bnum3 = ImageLoader.loadImage("/LETTERBIG/easy_temp_3.png");
		Bnum4 = ImageLoader.loadImage("/LETTERBIG/easy_temp_4.png");
		Bnum5 = ImageLoader.loadImage("/LETTERBIG/easy_temp_5.png");
		Bnum6 = ImageLoader.loadImage("/LETTERBIG/easy_temp_6.png");
		Bnum7 = ImageLoader.loadImage("/LETTERBIG/easy_temp_7.png");
		Bnum8 = ImageLoader.loadImage("/LETTERBIG/easy_temp_8.png");
		Bnum9 = ImageLoader.loadImage("/LETTERBIG/easy_temp_9.png");
	}
}
