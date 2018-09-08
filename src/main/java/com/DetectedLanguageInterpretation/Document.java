package com.DetectedLanguageInterpretation;

import java.io.Serializable;
import java.util.ArrayList;

public class Document implements Serializable{

	private String id;

	  public String getId() { return this.id; }

	  public void setId(String id) { this.id = id; }

	  private ArrayList<DetectedLanguage> detectedLanguages;

	  public ArrayList<DetectedLanguage> getDetectedLanguages() { return this.detectedLanguages; }

	  public void setDetectedLanguages(ArrayList<DetectedLanguage> detectedLanguages) { this.detectedLanguages = detectedLanguages; }

	@Override
	public String toString() {
		return "Document [id=" + id + ", detectedLanguages="
				+ detectedLanguages + "]";
	}

	  
}
