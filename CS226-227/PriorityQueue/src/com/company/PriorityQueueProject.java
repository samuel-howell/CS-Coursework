package com.company;

import java.util.ArrayList;

/*
Name: Samuel Howell
Email: samuel.howell@g.fmarion.edu
Date: 9-3-2020
File name: PriorityQueueProject .java
Class: CS-227
Description: This is the code for a priority queue that will remove elements (of an arbitrary type) in the order of their priority. Higher number is higher priority.
 */
public class PriorityQueueProject
{
    public static void main(String[] args) {

        //--------------------  EXAMPLE  -----------------------
        System.out.println("From assignment example: ");
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("X",10);
        q.add("Y",1 );
        q.add("Z",3 );

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());


        //--------------------  ASCENDING  -----------------------
        System.out.println();
        System.out.println("In ascending priority order: ");
        PriorityQueue<Double> d = new PriorityQueue<>();

        d.add(56.2, 1);
        d.add(6.35, 3);
        d.add(98.3, 6);

        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());


        //--------------------  DESCENDING  -----------------------
        System.out.println();
        System.out.println("In descending priority order: ");
        PriorityQueue<Float> f = new PriorityQueue<>();

        f.add(56.2f, 10);
        f.add(6.35f, 5 );
        f.add(98.3f, 2 );

        System.out.println(f.remove());
        System.out.println(f.remove());
        System.out.println(f.remove());


        //--------------------  MIXED  -----------------------
        System.out.println();
        System.out.println("In mixed priority order: ");
        PriorityQueue<Object> o = new PriorityQueue<>();

        o.add(61.2f            , 7);
        o.add("FINALLY DONE!!!", 9);
        o.add(934              , 1);

        System.out.println(o.remove());
        System.out.println(o.remove());
        System.out.println(o.remove());
    }
}


/*
This PriorityQueue class creates a generic ArrayList that can hold the objects created by the generic PriorityQueueItem class.  It also contains methods to
add and remove data from the ArrayList.
 */
class PriorityQueue <T>
{
    public ArrayList<PriorityQueueItem<T>> queue = new ArrayList<>();

    //  default constructor
    public PriorityQueue()
    {

    }

    //  The add() method creates a new PriorityQueueItem object from the appropriate input, and adds said object to the ArrayList.
    public void add(T item, int priority)
    {
        PriorityQueueItem<T> element = new PriorityQueueItem<>(item, priority);
        queue.add(element);
    }

    //  The remove() method returns either null (if queue is empty) or returns the object that currently has the highest priority in the queue. This object is removed from the queue after this operation.
    public T remove ()
    {
        if(queue.isEmpty())
        {
            return null;
        }
        else
        {
            T item = queue.get(findHighestPriority(queue)).getItem();
            queue.remove(queue.get(findHighestPriority(queue)));
            return item;
        }
    }

    /*  the findHighestPriority method iteratively loops through the each object's priority field (for every object in the queue) to find the highest priority. Once this is found, the ArrayList index
        of the object with the highest priority is returned.
     */
    public int findHighestPriority (ArrayList<PriorityQueueItem<T>> queue)
    {
        int highestPriorityIndex = 0;
        int highestPriority = 0;
        for(int i = 0; i < queue.size(); i++)
        {
            if (queue.get(i).getPriority() > highestPriority)
            {
                highestPriority = queue.get(i).getPriority();
                highestPriorityIndex = i;
            }
        }
        return highestPriorityIndex;
    }

}

/*
This PriorityQueueItem class creates a framework from which to create generic object items (each consisting of a T item and an int priority)
that can then be placed in the generic ArrayList PriorityQueue class.
 */
 class PriorityQueueItem <T>
{
    private T item;
    private int priority;

    public PriorityQueueItem(T item, int priority)
    {
        this.item = item;
        this.priority = priority;
    }

    public T getItem()
    {
        return item;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setItem(T item)
    {
        this.item = item;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    @Override
    public String toString()
    {
        return "PriorityQueueObject{" +
                "item=" + item +
                ", priority=" + priority +
                '}';
    }
}
