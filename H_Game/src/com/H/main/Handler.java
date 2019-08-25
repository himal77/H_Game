package com.H.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemeys() {
		
		while(object.size() != 1) {
			
			object.remove(1);
			
//			GameObject tempObject = object.get(i);
//			if(object.get(i).getId() == ID.Player) {
//				object.clear();
//				addObject(new Player((int)tempObject.getX(),(int)tempObject.getY(), ID.Player, this));
//			}
			
			
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
