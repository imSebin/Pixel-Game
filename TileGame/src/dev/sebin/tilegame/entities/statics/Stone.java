package dev.sebin.tilegame.entities.statics;

import java.awt.Graphics;

import dev.sebin.tilegame.Handler;
import dev.sebin.tilegame.gfx.Assets;
import dev.sebin.tilegame.items.Item;
import dev.sebin.tilegame.tiles.Tile;

public class Stone extends StaticEntity{

	public Stone(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	public void tick() {
		
	}
	
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
}
