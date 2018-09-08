package com.FaceDetectionInVideoV2;

import java.util.ArrayList;
import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class RootObject implements Serializable{
	
	  @SerializedName("version")
	  @Expose
	  private int version;

	  public int getVersion() { return this.version; }

	  public void setVersion(int version) { this.version = version; }
	  
	  @SerializedName("timescale")
	  @Expose
	  private int timescale;

	  public int getTimescale() { return this.timescale; }

	  public void setTimescale(int timescale) { this.timescale = timescale; }

	  @SerializedName("offset")
	  @Expose
	  private int offset;

	  public int getOffset() { return this.offset; }

	  public void setOffset(int offset) { this.offset = offset; }

	  @SerializedName("framerate")
	  @Expose
	  private double framerate;

	  public double getFramerate() { return this.framerate; }

	  public void setFramerate(double framerate) { this.framerate = framerate; }

	  @SerializedName("width")
	  @Expose
	  private int width;

	  public int getWidth() { return this.width; }

	  public void setWidth(int width) { this.width = width; }

	  @SerializedName("height")
	  @Expose
	  private int height;

	  public int getHeight() { return this.height; }

	  public void setHeight(int height) { this.height = height; }

	  @SerializedName("fragments")
	  @Expose
	  private ArrayList<Fragment> fragments;

	  public ArrayList<Fragment> getFragments() { return this.fragments; }

	  public void setFragments(ArrayList<Fragment> fragments) { this.fragments = fragments; }

	  @SerializedName("facesDetected")
	  @Expose
	  private ArrayList<FacesDetected> facesDetected;

	  public ArrayList<FacesDetected> getFacesDetected() { return this.facesDetected; }

	  public void setFacesDetected(ArrayList<FacesDetected> facesDetected) { this.facesDetected = facesDetected; }

	@Override
	public String toString() {
		return "RootObject [version=" + version + ", timescale=" + timescale
				+ ", offset=" + offset + ", framerate=" + framerate
				+ ", width=" + width + ", height=" + height + ", fragments="
				+ fragments + ", facesDetected=" + facesDetected + "]";
	}
	  
	  
}
