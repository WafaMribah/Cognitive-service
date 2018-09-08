package com.MediaPlayerDetection.UI;

import java.io.Serializable;

public class FacesDetected implements Serializable{
    private String faceId;

    public String getFaceId ()
    {
        return faceId;
    }

    public void setFaceId (String faceId)
    {
        this.faceId = faceId;
    }

    @Override
    public String toString()
    {
        return " [faceId = "+faceId+"]";
    }
}