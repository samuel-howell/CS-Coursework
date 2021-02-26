package com.company;

import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise17_02 {

    public static void main(String[] args) throws IOException {
        try (
                //create an output stream to the dat file
                FileOutputStream out = new FileOutputStream("Exercise17_02.dat", true)
        ) {
            //create 100 random integers and the to the dat file
            for (int i = 0; i < 100; i++) {
                out.write((int) (Math.random() * 100));
            }
        }
    }
}
