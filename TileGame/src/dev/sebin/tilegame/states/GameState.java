package dev.sebin.tilegame.states;

import java.awt.Graphics;

import dev.sebin.tilegame.Game;
import dev.sebin.tilegame.Handler;
import dev.sebin.tilegame.entities.creatures.Player;
import dev.sebin.tilegame.entities.statics.Tree;
import dev.sebin.tilegame.gfx.Assets;
import dev.sebin.tilegame.tiles.Tile;
import dev.sebin.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	public void tick() {
		world.tick();
	}
	
	public void render(Graphics g) {
		world.render(g);
	}
	
}

