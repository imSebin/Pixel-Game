package dev.sebin.tilegame.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
	
	public static Font loadFont(String path, float size) {
		try {
			String fName = "/fonts/slkscr.ttf";
		    InputStream is = FontLoader.class.getResourceAsStream(fName);
			return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
