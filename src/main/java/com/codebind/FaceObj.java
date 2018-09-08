package com.codebind;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FaceObj implements Serializable{
	
	@SerializedName("faceId")
	@Expose
	private String faceId;
	
	@SerializedName("faceRectangle")
	@Expose
	public FaceRectangle faceRectangle;
	
	@SerializedName("faceAttributes")
	@Expose
	public FaceAttributes faceAttributes;
	
	@SerializedName("scores")
	@Expose
	public EmotionScores scores;
	
	public FaceObj(String faceId, FaceRectangle faceRectangle,
			FaceAttributes faceAttributes, EmotionScores scores) {
		super();
		this.faceId = faceId;
		this.faceRectangle = faceRectangle;
		this.faceAttributes = faceAttributes;
		this.scores = scores;
	}
	
	public String getFaceId() {
		return faceId;
	}

	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}

	public FaceRectangle getFaceRectangle() {
		return faceRectangle;
	}

	public void setFaceRectangle(FaceRectangle faceRectangle) {
		this.faceRectangle = faceRectangle;
	}

	public FaceAttributes getFaceAttributes() {
		return faceAttributes;
	}

	public void setFaceAttributes(FaceAttributes faceAttributes) {
		this.faceAttributes = faceAttributes;
	}

	public EmotionScores getScores() {
		return scores;
	}

	public void setScores(EmotionScores scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "FaceObj [faceId=" + faceId + ", faceRectangle=" + faceRectangle
				+ ", faceAttributes=" + faceAttributes + ", scores=" + scores
				+ "]";
	}

	
	
}
