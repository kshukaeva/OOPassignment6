package com.company;

public class HtmlButton implements Button {

    public void render() {
        System.out.println("HTMLButton render()");
    }

    public void onClick(String f) {
        System.out.println("HTMLButton onClick "+f);
    }
}