package dev.sebin.tilegame.inventories;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.sebin.tilegame.Handler;
import dev.sebin.tilegame.gfx.Assets;
import dev.sebin.tilegame.gfx.Text;
import dev.sebin.tilegame.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int inventWidth = 734, inventHeight = 734, inventX = 64, inventY = 48;
	private int invImageX = 571, invImageY = 502, invImageWidth = 120, invImageHeight = 120;
	
	private int invPlayerNameX = 541, invPlayerNameY = 140;
	private int invPlayerX = 560, invPlayerY = 210;
	private int invMapX = 193, invMapY = 103;
	private int invCenterItemX = 306, invCenterItemY = 597;
	private int invCountX = 632, invCountY = 677;
	
	private int invListSpacing = 52;
	
	private int selectedItem = 0;
	
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			active = !active;
		}
		if(!active) {
			return;
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
			selectedItem--;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
			selectedItem++;
		}
		
		if(selectedItem < 0) {
			selectedItem = inventoryItems.size() - 1;
		} else if(selectedItem >= inventoryItems.size()) {
			selectedItem = 0;
		}
	}
	
	public void render(Graphics g) {
		if(!active) {
			return;
		}
		
		g.drawImage(Assets.inventoryScreen, inventX, inventY, inventWidth, inventHeight, null);
		
		Text.drawString(g, "> Player 1 <", invPlayerNameX, invPlayerNameY, false, Color.WHITE, Assets.font28);
		Text.drawString(g, "Level 1 - 1", invMapX, invMapY, false, Color.WHITE, Assets.font28);
		g.drawImage(Assets.inventoryPlayer, invPlayerX, invPlayerY, 180, 180, null);
		
		int length = inventoryItems.size();
		if(length == 0) {
			return;
		}
		for(int i = -2; i < 3; i++) {
			if(selectedItem + i < 0 || selectedItem + i >=length) {
				continue;
			}
			if(i == 0) {
				Text.drawString(g, "> " +inventoryItems.get(selectedItem + i).getName() +" <", invCenterItemX, invCenterItemY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			} else {
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invCenterItemX, invCenterItemY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font40);
	}
	
	//inventory
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	//getter and setter
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}
}
