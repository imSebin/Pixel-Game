package dev.sebin.tilegame.tiles;

import dev.sebin.tilegame.gfx.Assets;

public class TreeTile extends Tile {

	public TreeTile(int id) {
		super(Assets.tree, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}
