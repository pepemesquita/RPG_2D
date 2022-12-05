package main;

import entidade.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean cimaPressed, baixoPressed, esqPressed, dirPressed, enterPressed, pPressed, ePressed, allowFight = true;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			cimaPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			baixoPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			esqPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			dirPressed = true;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			pPressed = true;
		}
		if(code == KeyEvent.VK_E){
			ePressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			cimaPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			baixoPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			esqPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			dirPressed = false;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
		if(code == KeyEvent.VK_P) {
			pPressed = false;
			allowFight = true;
		}
		if(code == KeyEvent.VK_E){
			ePressed = false;
		}
	}
}
