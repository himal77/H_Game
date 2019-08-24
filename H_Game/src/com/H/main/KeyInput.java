package com.H.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	public Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}
}
