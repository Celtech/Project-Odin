package com.client;

public class RSMenuItem {
	/**
	 * The image being drawn on the menu, if any
	 */
	Sprite sprite;
	
	/**
	 * The text for this menu item 
	 */
	String text;
	
	/**
	 * Creates a new item to be displayed on a menu
	 * @param text	the text of this item
	 */
	public RSMenuItem(String text) {
		this.text = text;
	}
	
	
	
	/**
	 * The text that represents this item
	 * @return	the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * The sprite or image, if any, to be displayed on the drop down menu.
	 * @return	the image or sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}
}