package com.FaceDetectionInVideoV2;

import java.io.Serializable;

public class FacesDetected implements Serializable{
	
	private int faceId;

	  public int getFaceId() { return this.faceId; }

	  public void setFaceId(int faceId) { this.faceId = faceId; }
}
