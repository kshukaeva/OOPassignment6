package com.company;

public abstract class Dialog {
    public void render() {
        Button okButton = createButton();
        okButton.onClick("closeDialog");
        okButton.render();
    }

    public abstract Button createButton();
}
