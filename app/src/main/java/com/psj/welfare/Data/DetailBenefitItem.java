package com.psj.welfare.Data;

public class DetailBenefitItem
{
    private String content_title;
    private String title;

    public DetailBenefitItem(String content_title, String title)
    {
        this.content_title = content_title;
        this.title = title;
    }

    public String getContent_title()
    {
        return content_title;
    }

    public void setContent_title(String content_title)
    {
        this.content_title = content_title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
