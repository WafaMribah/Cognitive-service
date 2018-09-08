package com.MediaPlayerDetection.UI;

import java.io.Serializable;
import java.util.ArrayList;

public class Fragments implements Serializable{
	private int start;

	  public int getStart() { return this.start; }

	  public void setStart(int start) { this.start = start; }

	  private int duration;

	  public int getDuration() { return this.duration; }

	  public void setDuration(int duration) { this.duration = duration; }

	  private int interval;

	  public int getInterval() { return this.interval; }

	  public void setInterval(int interval) { this.interval = interval; }

	  private ArrayList<ArrayList<Events>> events;

	  public ArrayList<ArrayList<Events>> getEvents() { return this.events; }

	  public void setEvents(ArrayList<ArrayList<Events>> events) { this.events = events; }

	@Override
	public String toString() {
		return " [start=" + start + ", duration=" + duration
				+ ", interval=" + interval + ", events=" + events + "]";
	}
	  
	  
}