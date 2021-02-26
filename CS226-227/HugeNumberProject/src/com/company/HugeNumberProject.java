package com.company;

/*
Name: Samuel Howell
Email: samuel.howell@g.fmarion.edu
Date: 9-11-2020
File name: HugeNumberProject.java
Class: CS-227
Description: This is a program that creates a bare-bones LinkedList to create and store huge integer numbers of arbitrary length.
 */

public class HugeNumberProject
{

    public static void main(String[] args)
    {
        HugeNumber hugeNumber = new HugeNumber("111111111111f11111111111");

        System.out.println(hugeNumber.returnNum());
        hugeNumber.addDigit(3);                                    //  test cases
        System.out.println(hugeNumber.returnNum());
        hugeNumber.addDigit(44);
        System.out.println(hugeNumber.returnNum());
        hugeNumber.resetNum();
        System.out.println(hugeNumber.returnNum());
        hugeNumber.addDigit(5);
        System.out.println(hugeNumber.returnNum());
        hugeNumber.addDigit(544252763);
        System.out.println(hugeNumber.returnNum());
    }
}

class HugeNumber
{
    Node<Integer> head;
    Node<Integer> tail;

    //  default constructor
    public HugeNumber()
    {

    }

    //  constructor that takes in a string of digits of arbitrary length
    public HugeNumber(String digitString)
    {
        String[] numArray = digitString.split("");
        for(String num : numArray)
        {
            try
            {
                this.addDigit(Integer.parseInt(num));      //  add each integer in the string as node in the HugeNumber
            }
            catch (NumberFormatException e)                //  prevents the program from crashing if user inputs something other than integers in the digitString
            {
                System.out.println("please only enter a string of integer numbers!");
                System.exit(3);                     //  exits the program gracefully
            }
        }
    }

    //  method to add a new most significant digit to the existing number
    public void addDigit(int num)
    {
        Node<Integer> newNum = new Node<>(num);         //  create a new Node to store the number in.

        if (num < 0)                                    // executes if user inputs negative values
        {
            throw new IllegalArgumentException("You can only input positive values");
        }

        else if (head == null)                          //  executes if the LinkedList is empty when node is added.
        {
            head = newNum;
            tail = newNum;
        }

        else                                            //  executes if the Node is to be added to a LinkedList already containing Nodes.  Places the digit in the leftmost (most-significant) position.
        {
            Node<Integer> temp = head;
            head = newNum;
            head.next = temp;
        }
    }

    //  method to reset the number to 0
    public void resetNum()
    {
        head = null;                                    //  by setting head to null, all the nodes attached to head (whether directly or through other nodes) are automatically wiped and disposed of by Java garbage collection.
    }

    //  method to return the huge integer as a String
    public String returnNum()
    {
        String errorMessage = "The list is empty!";
        StringBuilder finalNum = new StringBuilder();   //  create a StringBuilder on which to append all of the contents of the Nodes in the LinkedList.
        Node<Integer> current = head;

        if (head == null)                               //  executes if LinkedList is empty, returning an error message ot the user.
        {
            return errorMessage;
        }
        else                                            //  executes if LinkedList contains elements, traversing through the LinkedList, taking the element stored in each node, and appending it to the finalNum StringBuilder.
        {
            while (current != null)
            {
                finalNum.append(current.element);
                current = current.next;
            }
        }
        return finalNum.toString();                     //  returns the StringBuilder object back to the user as a String.
    }
}

//  class that creates a Node that is then used in the HugeNumber class to create a bare-bones LinkedList.
class Node<E>
{
    E element;
    Node<E> next;

    public Node(E object)
    {
        this.element = object;
    }
}
