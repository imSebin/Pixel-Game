package dev.sebin.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.sebin.tilegame.Handler;
import dev.sebin.tilegame.entities.Entity;
import dev.sebin.tilegame.gfx.Animation;
import dev.sebin.tilegame.gfx.Assets;
import dev.sebin.tilegame.inventories.Inventory;

public class Player extends Creature{
	
	//animations
	private Animation animationDown;
	private Animation animationUp;
	private Animation animationLeft;
	private Animation animationRight;
	private Animation animationStill;
	
	//attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	//inventory
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 32;
		bounds.width = 20;
		bounds.height = 32;
		
		//animations
		animationDown = new Animation(200, Assets.player_down);
		animationUp = new Animation(200, Assets.player_up);
		animationLeft = new Animation(200, Assets.player_left);
		animationRight = new Animation(200, Assets.player_right);
		animationStill = new Animation(200, Assets.player_still);
		
		inventory = new Inventory(handler);
	}

	public void tick() {
		//animations
		animationDown.tick();
		animationUp.tick();
		animationLeft.tick();
		animationRight.tick();
		animationStill.tick();
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//attack
		checkAttacks();
		
		//inventory
		inventory.tick();
	}
	
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown) {
			return;
		}
		
		if(inventory.isActive()) {
			return;
		}
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if(handler.getKeyManager().aDown) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - cb.height;
		} else if(handler.getKeyManager().aLeft) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if(handler.getKeyManager().aRight) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	}
	
	public void die() {
		System.out.println("Dead");
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(inventory.isActive()) {
			return;
		}
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	public void postRender(Graphics g) {
		inventory.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animationLeft.getCurrentFrame();
		}
		else if(xMove > 0) {
			return animationRight.getCurrentFrame();
		}
		else if(yMove < 0) {
			return animationUp.getCurrentFrame();
		}
		else if(yMove > 0) {
			return animationDown.getCurrentFrame();
		}
		else {
			return animationStill.getCurrentFrame();
		}
	}

	//getter and setter
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
