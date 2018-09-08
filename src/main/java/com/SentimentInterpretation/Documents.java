package com.SentimentInterpretation;

import java.io.Serializable;

public class Documents implements Serializable{
	
	 private double score;

	  public double getScore() { return this.score; }

	  public void setScore(double score) { this.score = score; }

	  private String id;

	  public String getId() { return this.id; }

	  public void setId(String id) { this.id = id; }
}
