package dev.sebin.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static Font font28;
	public static Font font40;
	
	public static BufferedImage inventoryPlayer;
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_still;
	public static BufferedImage[] btn_start;
	public static BufferedImage treeDrop, rockDrop;
	public static BufferedImage inventoryScreen;
	
	public static void init() {
		font28 = FontLoader.loadFont("/res/fonts/slkscr.ttf", 28);
		font40 = FontLoader.loadFont("/res/fonts/slkscr.ttf", 40);
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet brandRight = new SpriteSheet(ImageLoader.loadImage("/textures/BrandSpriteRight.png"));
		SpriteSheet brandLeft = new SpriteSheet(ImageLoader.loadImage("/textures/BrandSpriteLeft.png"));
		SpriteSheet brandStill = new SpriteSheet(ImageLoader.loadImage("/textures/BrandSpriteStill.png"));
		SpriteSheet playButton = new SpriteSheet(ImageLoader.loadImage("/textures/PlayButtonSprite.png"));
		SpriteSheet items = new SpriteSheet(ImageLoader.loadImage("/textures/Items.png"));
		SpriteSheet inventory = new SpriteSheet(ImageLoader.loadImage("/textures/Inventory.png"));
		
		inventoryScreen = inventory.crop(0, 0, 4 * width, 4 * height);
		inventoryPlayer = brandStill.crop(width, 0, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = playButton.crop(0, 0, width * 2, height);
		btn_start[1] = playButton.crop(0, height, width * 2, height);
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_still = new BufferedImage[2];
		
		player_down[0] = brandLeft.crop(0, 0, width, height);
		player_down[1] = brandLeft.crop(width, 0, width, height);
		player_down[2] = brandLeft.crop(width * 2, 0, width, height);
		player_down[3] = brandLeft.crop(width * 3, 0, width, height);
		
		player_left[0] = brandLeft.crop(0, 0, width, height);
		player_left[1] = brandLeft.crop(width, 0, width, height);
		player_left[2] = brandLeft.crop(width * 2, 0, width, height);
		player_left[3] = brandLeft.crop(width * 3, 0, width, height);
		
		player_up[0] = brandRight.crop(0, 0, width, height);
		player_up[1] = brandRight.crop(width, 0, width, height);
		player_up[2] = brandRight.crop(width * 2, 0, width, height);
		player_up[3] = brandRight.crop(width * 3, 0, width, height);
		
		player_right[0] = brandRight.crop(0, 0, width, height);
		player_right[1] = brandRight.crop(width, 0, width, height);
		player_right[2] = brandRight.crop(width * 2, 0, width, height);
		player_right[3] = brandRight.crop(width * 3, 0, width, height);
		
		player_still[0] = brandStill.crop(0, 0, width, height);
		player_still[1] = brandStill.crop(width, 0, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width, height);
		rock = sheet.crop(width, height, width, height);
		
		treeDrop = items.crop(0, 0, width, height);
		rockDrop = items.crop(width, 0, width, height);
	}
}
