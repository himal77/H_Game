package com.H.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	public Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.Player) {
					//key events for player 1
					
					if(key == KeyEvent.VK_W) {tempObject.setVelY(-3); keyDown[0] = true;}
					if(key == KeyEvent.VK_S) {tempObject.setVelY(3);  keyDown[1] = true;}
					if(key == KeyEvent.VK_A) {tempObject.setVelX(-3); keyDown[3] = true;}
					if(key == KeyEvent.VK_D) {tempObject.setVelX(3);  keyDown[2] = true;}
				}
				
			}
			if(key ==  KeyEvent.VK_ESCAPE) System.exit(0);
				
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
				
				if(key == KeyEvent.VK_W) keyDown[0] = false;  //tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false;  //tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false;  //tempObject.setVelX(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false;  //tempObject.setVelX(0);
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setY((int)tempObject.getY());
				//Horizontal movement
				if(!keyDown[3] && !keyDown[2]) tempObject.setX((int)tempObject.getX());
			}
		}
	}
}
