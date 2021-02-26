package com.company;

import java.util.ArrayList;

public class GenericsPriorityProject
{
/*

Name: Samuel Howell
Email: samuel.howell@g.fmarion.edu
Date: 9-3-2020
File name: GenericsPriorityProject.java
Class: CS-227

Description: This is the code for a priority queue that will remove elements (of an arbitrary type) in the order of their priority. Higher number is higher priority.

 */

    public static void main(String[] args) {

        //--------------------  EXAMPLE   ----------------------
        System.out.println("From assignment example: ");
        GenericPriorityList<String> q = new GenericPriorityList<>();

        q.add("X",10);
        q.add("Y", 1);
        q.add("Z", 3);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

        //--------------------  ASCENDING   -----------------------
        System.out.println();
        System.out.println("In ascending priority order: ");
        GenericPriorityList<Double> d = new GenericPriorityList<>();

        d.add(56.2, 1);
        d.add(6.35, 3);
        d.add(98.3, 6);

        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());

        //--------------------  DESCENDING   -----------------------
        System.out.println();
        System.out.println("In descending priority order: ");
        GenericPriorityList<Float> f = new GenericPriorityList<>();

        f.add(56.2f, 10);
        f.add(6.35f, 5);
        f.add(98.3f, 2);

        System.out.println(f.remove());
        System.out.println(f.remove());
        System.out.println(f.remove());

        //--------------------  MIXED   -----------------------
        System.out.println();
        System.out.println("In descending priority order: ");
        GenericPriorityList<Object> o = new GenericPriorityList<>();

        o.add(61.2f, 7);
        o.add("FINALLY DONE!!!", 9);
        o.add(934, 1);

        System.out.println(o.remove());
        System.out.println(o.remove());
        System.out.println(o.remove());

    }
    

}

class GenericPriorityList <T>
{
    private ArrayList<T> itemQueue = new ArrayList<>();                     //  create a generic arrayList to hold values of an arbitrary type
    private ArrayList<Integer> priorityQueue = new ArrayList<>();           //  create an integer list to hold the priority values (will directly correspond with itemQueue arrayList


    public GenericPriorityList()                                            //  create a default constructor
    {

    }

    public void add(T item, int priority)                                   //  this add method takes the generic item and places it in the itemQueue, and takes the integer and adds it to the priorityQueue
    {
        itemQueue.add(item);
        priorityQueue.add(priority);
    }

    public T remove()
    {
        int highestPriority = getHighestPriority();                         //  call getHighestPriority method.
        T item = itemQueue.get(highestPriority);                            //  take the int returned from getHighestPriority method (the indexOfHighestPriority) and use it to find highestPriority item.

        priorityQueue.remove(highestPriority);                              //  remove the highest priority from the priorityQueue ArrayList to make way for a new "highest priority"
        itemQueue.remove(highestPriority);                                  //  remove the highest item from the itemQueue ArrayList to make way for a new "highest priority item"

        return item;
    }

    public int getHighestPriority()
    {
        int indexOfHighestPriority = 0;                                     //  store an initial integer value of 0 to initialize indexOfHighestPriority variable.
        int firstPriority = 0;                                              //  store an initial integer value of 0 to initialize firstPriority variable.

        for(int i = 0; i < priorityQueue.size(); i++)
        {
            if(priorityQueue.get(i) > firstPriority)                        /*  if the priorityQueue at position i is a bigger number than the current firstPriority number, then
                                                                                change the indexOfHighestPriority to that position i and change the firstPriority value to the integer
                                                                                stored in the ArrayList at that position i.
                                                                            */
            {
                indexOfHighestPriority = i;
                firstPriority = priorityQueue.get(i);
            }
        }
        return indexOfHighestPriority;
    }
}