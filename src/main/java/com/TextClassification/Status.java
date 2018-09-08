package com.TextClassification;

import java.io.Serializable;

public class Status implements Serializable
{
    private String remaining_credits;

    private String credits;

    private String code;

    private String msg;

    public String getRemaining_credits ()
    {
        return remaining_credits;
    }

    public void setRemaining_credits (String remaining_credits)
    {
        this.remaining_credits = remaining_credits;
    }

    public String getCredits ()
    {
        return credits;
    }

    public void setCredits (String credits)
    {
        this.credits = credits;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [remaining_credits = "+remaining_credits+", credits = "+credits+", code = "+code+", msg = "+msg+"]";
    }
}