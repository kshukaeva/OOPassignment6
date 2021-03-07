package com.company;
public class Application {
        public static void main(String[] args)  {
                Database jdbc= Database.getInstance();
                //insert
                jdbc.create(101, "Kendall", "Jenner",95);
                jdbc.create(102, "Alec", "Benjamin",75.6);
                //read
                jdbc.read(101);
                jdbc.read(102);
                //update
                jdbc.update(125, "Kim", "Kardashian",76,102);
                //delete
                jdbc.delete(101);
        }
}
