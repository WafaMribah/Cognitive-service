package com.KeyPhrasesInterpretation;

import java.io.Serializable;
import java.util.ArrayList;

public class document implements Serializable{
	
	private ArrayList<String> keyPhrases;

	  public ArrayList<String> getKeyPhrases() { return this.keyPhrases; }

	  public void setKeyPhrases(ArrayList<String> keyPhrases) { this.keyPhrases = keyPhrases; }

	  private String id;

	  public String getId() { return this.id; }

	  public void setId(String id) { this.id = id; }

	@Override
	public String toString() {
		return "Document [keyPhrases=" + keyPhrases + ", id=" + id + "]";
	}	   
}
