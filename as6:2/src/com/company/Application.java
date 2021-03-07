package com.company;

public class Application {
    private static Dialog dialog;
    public static void main(String[] args) throws Exception{
        initialize();
        dialog.render();
    }

    static void initialize() throws Exception{
        if (System.getProperty("os.name").equals("Windows")) {
            dialog = new WindowsDialog();
        } else if (System.getProperty("os.name").equals("Web")){
            dialog = new WebDialog();
        }else{
            throw new Exception("Error! Unknown operating system.");
        }
    }


}
