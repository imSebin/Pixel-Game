package dev.sebin.tilegame.tiles;

import dev.sebin.tilegame.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
