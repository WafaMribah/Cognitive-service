package com.codebind;

import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FaceRectangle implements Serializable{
		
	private int top; 
	private int left; 
	private int width;  
	private int height;
	
	
public FaceRectangle(int top, int left, int width, int height) {
		super();
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
	}
	
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "FaceRectangle [top=" + top + ", left=" + left + ", width="
				+ width + ", height=" + height + "]";
	}
	
}
