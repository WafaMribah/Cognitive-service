package com.codebind;

import java.io.Serializable;

public class FaceAttributes implements Serializable{

	private float age;
	
	public FaceAttributes() {
	}

	public FaceAttributes(float age) {
		super();
		this.age = age;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "FaceAttributes [age=" + age + "]";
	}
		
}
