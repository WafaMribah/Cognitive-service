package com.TextClassification;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class textClassification implements Serializable{

	 @SerializedName("category_list")
	 @Expose
	private ArrayList<Category_list> category_list;

	 @SerializedName("status")
	 @Expose
    private Status status;

    public ArrayList<Category_list> getCategory_list ()
    {
        return category_list;
    }

    public void setCategory_list (ArrayList<Category_list> category_list)
    {
        this.category_list = category_list;
    }

    public Status getStatus ()
    {
        return status;
    }

    public void setStatus (Status status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [category_list = "+category_list+", status = "+status+"]";
    }
}
