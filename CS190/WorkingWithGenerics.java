package com.company;

import java.util.*;

/*

Names: Tyler Floyd, Samuel Howell
Email: tyler.floyd@g.fmarion.edu, samuel.howell@g.fmarion.edu
Date: 9-1-2020
File name: WorkingWithGenerics.java
Class: CS-227

 */
public class WorkingWithGenerics
{

    public static void main(String[] args)
    {
        ArrayList<Object> list = new ArrayList<>();     /*
                                                            initialize an ArrayList of Objects.  Although Object here, the actual type is
                                                            arbitrary, because we are calling a method with a Generic ArrayList, so we
                                                            could just as easily make this ArrayList a Double (and input double values),
                                                            an Integer (and input int values), and so on.
                                                        */
        list.add(15);
        list.add(25.5);                                 //  add test values
        list.add(2);
        list.add("gg");

        shuffle(list);                                  //  call the method
    }

    public static <E> void shuffle(ArrayList<E> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            int newPosition = (int) (list.size() * Math.random());      //  find a position to move the current value at list.get(i) to.
            E replacedValue = list.get(newPosition);                    //  store the value that was already at this new position in a variable.
            list.set(newPosition, list.get(i));                         //  at the newPosition, place the element from list.get(i).
            list.set(i, replacedValue);                                 //  at the currentPosition (i), place the value that was originally displaced.
        }
        System.out.println(list);
    }

}

