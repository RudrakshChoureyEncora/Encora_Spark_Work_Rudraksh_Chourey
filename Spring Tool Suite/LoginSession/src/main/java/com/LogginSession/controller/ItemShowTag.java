package com.LogginSession.controller;


import java.io.IOException;
import java.util.List;

import com.LogginSession.model.Item;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;



public class ItemShowTag extends SimpleTagSupport {

    private List<Item> items;
    private String namePrefix;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (items == null || items.isEmpty()) {
            out.write("<p>No products available.</p>");
            return;
        }

        for (Item item : items) {
        	out.write("<br>"+item.getItemname() );
            out.write("<input type=\"number\" name='" + item.getItemid() + "' value=\"0\"  min=\"0\"/>"+"<br/>");
           
        }
    }
}
