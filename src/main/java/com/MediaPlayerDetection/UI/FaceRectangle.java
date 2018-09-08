package com.MediaPlayerDetection.UI;

import java.awt.Color;

public class FaceRectangle {
	
	private int id;
	private double top; 
	private double left; 
	private double width;  
	private double height;
	private Color color;
	private static int id_0=0 , id_1=0 ,id_2=0, id_3=0, id_4=0, id_5=0, id_other=0;
	private static double avg_0=0, avg_1=0, avg_2=0, avg_3=0, avg_4=0, avg_5=0, avg_other=0;
	
		
public FaceRectangle() {
		super();
	}


public FaceRectangle( double top, double left, double width, double height) {
		super();
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
	}
	
public FaceRectangle(int id, double top, double left, double width, double height) {
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
	public static int getId_0() {
		return id_0;
	}

	public static void setId_0(int id_0) {
		FaceRectangle.id_0 = id_0;
	}

	public static int getId_1() {
		return id_1;
	}

	public static void setId_1(int id_1) {
		FaceRectangle.id_1 = id_1;
	}

	public static int getId_2() {
		return id_2;
	}

	public static void setId_2(int id_2) {
		FaceRectangle.id_2 = id_2;
	}

	public static int getId_3() {
		return id_3;
	}

	public static void setId_3(int id_3) {
		FaceRectangle.id_3 = id_3;
	}

	public static int getId_4() {
		return id_4;
	}

	public static void setId_4(int id_4) {
		FaceRectangle.id_4 = id_4;
	}

	public static int getId_5() {
		return id_5;
	}

	public static void setId_5(int id_5) {
		FaceRectangle.id_5 = id_5;
	}	
	
	
	public static int getId_other() {
		return id_other;
	}


	public static void setId_other(int id_other) {
		FaceRectangle.id_other = id_other;
	}


	public Color getColor() {
		
		switch (id){
        case 0:  return color.GREEN;
		case 1:  return color.BLUE;
		case 2:  return color.RED;
		case 3:  return color.CYAN;
		case 4:  return color.MAGENTA;
		default: return color.ORANGE;
		}
	}
	

	public void LearningTime(){
		switch (id){
		case 0: id_0++; System.out.println("l'ID 0 appeared " + id_0 + "times"); setId_0(id_0); break;
		case 1: id_1++; System.out.println("l'ID 1 appeared " + id_1 + "times"); setId_1(id_1); break;
		case 2: id_2++; System.out.println("l'ID 2 appeared " + id_2 + "times"); setId_2(id_2); break;
		case 3: id_3++; System.out.println("l'ID 3 appeared " + id_3 + "times"); setId_3(id_3); break;
		case 4: id_4++; System.out.println("l'ID 4 appeared " + id_4 + "times"); setId_4(id_4); break;
		case 5: id_5++; System.out.println("l'ID 5 appeared " + id_5 + "times"); setId_5(id_5); break;
		default: System.out.println("there are more than 5 persons"); break;
		
		}
	}
		
	public static double getAvg_0() {
		return avg_0;
	}
	public static void setAvg_0(double avg_0) {
		FaceRectangle.avg_0 = avg_0;
	}
	public static double getAvg_1() {
		return avg_1;
	}
	public static void setAvg_1(double avg_1) {
		FaceRectangle.avg_1 = avg_1;
	}
	public static double getAvg_2() {
		return avg_2;
	}
	public static void setAvg_2(double avg_2) {
		FaceRectangle.avg_2 = avg_2;
	}
	public static double getAvg_3() {
		return avg_3;
	}
	public static void setAvg_3(double avg_3) {
		FaceRectangle.avg_3 = avg_3;
	}
	public static double getAvg_4() {
		return avg_4;
	}
	public static void setAvg_4(double avg_4) {
		FaceRectangle.avg_4 = avg_4;
	}
	public static double getAvg_5() {
		return avg_5;
	}
	public static void setAvg_5(double avg_5) {
		FaceRectangle.avg_5 = avg_5;
	}
	public static double getAvg_other() {
		return avg_other;
	}
	public static void setAvg_other(double avg_other) {
		FaceRectangle.avg_other = avg_other;
	}

	public void AverageRectangle(){
		switch (id){
		case 0: id_0++; System.out.println("l'ID 1 appeared " + id_0 + " times"); avg_0 += this.height ;System.out.println("sum of height"+avg_0); setId_0(id_0); setAvg_0(avg_0); break;
		case 1: id_1++; System.out.println("l'ID 1 appeared " + id_1 + " times"); avg_1 += this.height ;System.out.println("sum of height"+avg_1); setId_0(id_1); setAvg_1(avg_1); break;
		case 2: id_2++; System.out.println("l'ID 1 appeared " + id_2 + " times"); avg_2 += this.height ;System.out.println("sum of height"+avg_2); setId_0(id_2); setAvg_2(avg_2); break;
		case 3: id_3++; System.out.println("l'ID 1 appeared " + id_3 + " times"); avg_3 += this.height ;System.out.println("sum of height"+avg_3); setId_0(id_3); setAvg_3(avg_3); break;
		case 4: id_4++; System.out.println("l'ID 1 appeared " + id_4 + " times"); avg_4 += this.height ;System.out.println("sum of height"+avg_4); setId_0(id_4); setAvg_4(avg_4); break;
		case 5: id_5++; System.out.println("l'ID 1 appeared " + id_5 + " times"); avg_5 += this.height ;System.out.println("sum of height"+avg_5); setId_0(id_5); setAvg_5(avg_5); break;
		default: System.out.println("there are more than 5 persons"); break;
		}
	}
	
	@Override
	public String toString() {
		return "FaceRectangle [top=" + top + ", left=" + left + ", width="
				+ width + ", height=" + height + "]";
	}
	
}
