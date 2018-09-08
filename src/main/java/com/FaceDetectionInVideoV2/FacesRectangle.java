package com.FaceDetectionInVideoV2;

import java.awt.Color;

public class FacesRectangle {
	
	private int id;
	private double top; 
	private double left; 
	private double width;  
	private double height;
	private Color color;
	
		
public FacesRectangle() {
		super();
	}


public FacesRectangle( double top, double left, double width, double height) {
		super();
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
	}
	
public FacesRectangle(int id, double top, double left, double width, double height) {
	super();
	this.id=id;
	this.top = top;
	this.left = left;
	this.width = width;
	this.height = height;
}

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public double getTop() {
		return top;
	}
	public void setTop(double top) {
		this.top = top;
	}
	public double getLeft() {
		return left;
	}
	public void setLeft(double left) {
		this.left = left;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
		
	public Color getColor() {
		
		switch (id){
        case 0:  return color.BLUE;
		case 1:  return color.BLUE;
		case 2:  return color.RED;
		case 3:  return color.CYAN;
		case 4:  return color.MAGENTA;
		default: return color.ORANGE;
		}
	}
	

	@Override
	public String toString() {
		return "FaceRectangle [top=" + top + ", left=" + left + ", width="
				+ width + ", height=" + height + "]";
	}
}
