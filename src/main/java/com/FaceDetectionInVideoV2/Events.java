package com.FaceDetectionInVideoV2;

import java.io.Serializable;

public class Events implements Serializable{

	  private int id;
	    private double x;
	    private double y;
	    private double width;
	    private double height;

	    public int getId ()
	    {
	        return id;
	    }

	    public void setId (int id)
	    {
	        this.id = id;
	    }

	    public double getHeight ()
	    {
	        return height;
	    }

	    public void setHeight (double height)
	    {
	        this.height = height;
	    }

	    public double getWidth ()
	    {
	        return width;
	    }

	    public void setWidth (double width)
	    {
	        this.width = width;
	    }

	    public double getY ()
	    {
	        return y;
	    }

	    public void setY (double y)
	    {
	        this.y = y;
	    }

	    public double getX ()
	    {
	        return x;
	    }

	    public void setX (double x)
	    {
	        this.x = x;
	    }

	    @Override
	    public String toString()
	    {
	        return " [id = "+id+", height = "+height+", width = "+width+", y = "+y+", x = "+x+"]";
	    }

}
