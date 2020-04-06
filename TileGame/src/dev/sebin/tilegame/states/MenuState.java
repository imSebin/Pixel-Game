package dev.sebin.tilegame.states;

import java.awt.Graphics;

import dev.sebin.tilegame.Game;
import dev.sebin.tilegame.Handler;
import dev.sebin.tilegame.gfx.Assets;
import dev.sebin.tilegame.ui.ClickListener;
import dev.sebin.tilegame.ui.UIImageButton;
import dev.sebin.tilegame.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(300, 300, 256, 128, Assets.btn_start, new ClickListener(){
			public void OnClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	public void tick() {
		uiManager.tick();
	}

	public void render(Graphics g) {
		uiManager.render(g);
	}
}
