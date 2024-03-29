package com.H.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	
	private BufferedImage player_image;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(1, 1, 32, 32);
		
 	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x,  0, Game.WIDTH - 38);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 62);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.WHITE, 32, 32, 0.04f, handler));
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Enemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy ) {   
				
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -= 2;
				}
			}
		}
	}

	
	public void render(Graphics g) {
		g.drawImage(player_image, (int)x, (int)y, null);
	}
	
}
