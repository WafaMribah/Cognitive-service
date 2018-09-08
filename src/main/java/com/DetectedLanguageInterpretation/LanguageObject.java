package com.DetectedLanguageInterpretation;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageObject implements Serializable{
	
	@SerializedName("documents")
	@Expose
	private ArrayList<Document> documents;

    public ArrayList<Document> getDocuments() { return this.documents; }

    public void setDocuments(ArrayList<Document> documents) { this.documents = documents; }

    @SerializedName("errors")
	@Expose
	private ArrayList<Object> errors;

	public ArrayList<Object> getErrors() { return this.errors; }

	public void setErrors(ArrayList<Object> errors) { this.errors = errors; }

	@Override
	public String toString() {
		return "RootObject [documents=" + documents + ", errors=" + errors
				+ "]";
	}
	  
	  

}
