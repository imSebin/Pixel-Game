package dev.sebin.tilegame.entities.statics;

import java.awt.Graphics;

import dev.sebin.tilegame.Handler;
import dev.sebin.tilegame.gfx.Assets;
import dev.sebin.tilegame.items.Item;
import dev.sebin.tilegame.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	public void tick() {
		
	}
	
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
}
