package com.MediaPlayerDetection.UI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjDetected implements Serializable{
	
	@SerializedName("version")
	@Expose
	private int version;
	
	@SerializedName("timescale")
	@Expose
	private int timescale;
	
	@SerializedName("offset")
	@Expose
	private int offset;
	
	@SerializedName("framerate")
	@Expose
	private String framerate;
	
	@SerializedName("width")
	@Expose
	private int width;
	
	@SerializedName("height")
	@Expose
	private int height;

	@SerializedName("fragments")
	@Expose
	  private ArrayList<Fragments> fragments;
	
	@SerializedName("facesDetected")
	@Expose
	  private ArrayList<FacesDetected> facesDetected;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getTimescale() {
		return timescale;
	}

	public void setTimescale(int timescale) {
		this.timescale = timescale;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getFramerate() {
		return framerate;
	}

	public void setFramerate(String framerate) {
		this.framerate = framerate;
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

	public ArrayList<Fragments> getFragments() {
		return fragments;
	}

	public void setFragments(ArrayList<Fragments> fragments) {
		this.fragments = fragments;
	}

	public  ArrayList<FacesDetected> getFacesDetected() {
		return facesDetected;
	}

	public void setFacesDetected( ArrayList<FacesDetected> facesDetected) {
		this.facesDetected = facesDetected;
	}

	@Override
	public String toString() {
		return "ObjDetected [version=" + version + ", timescale=" + timescale
				+ ", offset=" + offset + ", framerate=" + framerate
				+ ", width=" + width + ", height=" + height + ", fragments="
				+ fragments + ", facesDetected=" + facesDetected + "]";
	}

}
