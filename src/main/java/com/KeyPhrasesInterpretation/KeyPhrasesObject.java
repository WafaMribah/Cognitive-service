package com.KeyPhrasesInterpretation;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyPhrasesObject implements Serializable{
	
	  @SerializedName("documents")
	  @Expose
	  private ArrayList<document> documents;

	  public ArrayList<document> getDocuments() { return this.documents; }

	  public void setDocuments(ArrayList<document> documents) { this.documents = documents; }

	  @SerializedName("errors")
	  @Expose
	  private ArrayList<Object> errors;

	  public ArrayList<Object> getErrors() { return this.errors; }

	  public void setErrors(ArrayList<Object> errors) { this.errors = errors; }

}
