package com.TextClassification;

import java.io.Serializable;

public class Category_list implements Serializable
{
    private double abs_relevance;

    private double relevance;

    private String label;

    private String code;

    public double getAbs_relevance ()
    {
        return abs_relevance;
    }

    public void setAbs_relevance (double abs_relevance)
    {
        this.abs_relevance = abs_relevance;
    }

    public double getRelevance ()
    {
        return relevance;
    }

    public void setRelevance (double relevance)
    {
        this.relevance = relevance;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [abs_relevance = "+abs_relevance+", relevance = "+relevance+", label = "+label+", code = "+code+"]";
    }
}
