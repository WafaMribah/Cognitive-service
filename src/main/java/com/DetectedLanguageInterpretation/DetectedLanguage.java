package com.DetectedLanguageInterpretation;

import java.io.Serializable;

public class DetectedLanguage implements Serializable{
	
	private String name;

	  public String getName() { return this.name; }

	  public void setName(String name) { this.name = name; }

	  private String iso6391Name;

	  public String getIso6391Name() { return this.iso6391Name; }

	  public void setIso6391Name(String iso6391Name) { this.iso6391Name = iso6391Name; }

	  private double score;

	  public double getScore() { return this.score; }

	  public void setScore(double score) { this.score = score; }

	@Override
	public String toString() {
		return "DetectedLanguage [name=" + name + ", iso6391Name="
				+ iso6391Name + ", score=" + score + "]";
	}

	  
}
