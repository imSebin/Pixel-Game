package dev.sebin.tilegame.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Text {
	
	public static void drawString(Graphics g, String text, int xPosition, int yPosition, boolean center, Color colour, Font font) {
		g.setColor(colour);
		g.setFont(font);
		int x = xPosition;
		int y = yPosition;
		if(center) {
			FontMetrics fm = g.getFontMetrics(font);
			x = xPosition - fm.stringWidth(text) / 2;
			y = (yPosition - fm.getHeight() / 2) + fm.getAscent();
			
		}
		
		g.drawString(text, x, y);
	}
}
