package com.company;
public class WindowsButton implements Button {
    public void render() {
        System.out.println("WindowsButton render()");
    }

    public void onClick(String f) {
        System.out.println("WindowsButton onClick "+f);
    }
}
