/*
Name:           Samuel Howell
Email:          samuel.howell@g.fmarion.edu
Date:           9-12-2020
File name:      SuitorProblem.java
Class:          CS-227
Description:    This is a program that creates and iterates through a circularLinkedList, eliminating every 3rd node, until only 1 is left.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class SuitorProblem
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int totalSuitors = 0;
        boolean goodInput;
        System.out.print("Enter the number of suitors: ");

        //************************************  INPUT VALIDATION  ***********************************************
        do
        {
            try
            {
                totalSuitors = sc.nextInt();
                while (totalSuitors <= 0)
                {
                    System.out.print("Enter a positive integer value greater than 0: ");
                    totalSuitors = sc.nextInt();
                }
                goodInput = true;
            }
            catch (InputMismatchException e)        //  if not integer, prompt the user to go back
            {
                System.out.print("Enter a positive integer value greater than 0: ");
                sc.nextLine();                      //  clear input
                goodInput = false;
            }
        } while (!goodInput);
        //********************************************************************************************************


        ListOfSuitors suitorList = new ListOfSuitors();
        for (int i = 1; i <= totalSuitors; i++)
            suitorList.addEnd(i);

        System.out.print("Before elimination process, the line-up of suitors is: ");
        System.out.print(suitorList.toString());
        System.out.println();

        suitorList.deleteSuitors();
        System.out.print("After  elimination process, the winning suitor is: ");
        System.out.print(suitorList.toString());
    }
}


    //  I use an extension of CircularLinkedList of type Integer, so I can have access to the methods in CircularLinkedList to manipulate the ListOfSuitors, which is a LinkedList of ints.
class ListOfSuitors extends CircularLinkedList<Integer>
{

    //  default constructor
    public ListOfSuitors()
    {
    }

    // This method is used to find the next index that needs to be deleted
    private int findIndexOfLoser(int element)
    {
        Node<Integer> current = head;
        int index = 0;
        while (current.element != element)
        {
            current = current.next;
            index++;
        }
        return index;
    }

    //  This method counts 3 spaces over then deletes a suitor by calling the delete method on the deletionIndex
    public void deleteSuitors()
    {
        Node<Integer> current = head;
        while (size != 1)
        {
            for (int i = 1; i < 3; i++)
            {
                current = current.next;
            }
            int deletionIndex = findIndexOfLoser(current.element);
            current = current.next;
            delete(deletionIndex);
        }
    }
}

    //  This is the generic circular linkedList that I extend my ListOfSuitors class from, and which holds the methods needed to manipulate the ListOfSuitors
class CircularLinkedList<E>
{

    //  since these will only be accessed by the subclass listOfSuitors, they are declared protected to increase security.
    protected Node<E> head = null;
    protected Node<E> tail = null;
    protected int size;

    public CircularLinkedList()
    {

    }

    //  method for adding a new end Node in circularLinkedList
    public void addEnd(E element)                                       //  adapted from ch24 PowerPoint
    {
        if (size == 0)
        {
            head = tail = new Node<E>(element, head);
        }
        else
        {
            tail = tail.next = new Node<E>(element, head);
        }
        size++;
    }

    //  Method for deleting a Node at a specified index in the circularLinkedList. May cause IndexOutOfBounds, so that must be handled within the method
    public void delete(int index)
    {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("That's not a correct index.");
        else if (index == 0)
            deleteFirst();
        else if (index == size - 1)
            deleteEnd();
        else
        {
            Node<E> previous = head;
            Node<E> current = head.next;
            for (int i = 1; i < index; i++)
            {
                previous = previous.next;
                current = current.next;
            }
            previous.next = current.next;
            current.next = null;
            size--;
        }
    }

    //  method for deleting the end Node in circularLinkedList
    public void deleteEnd()
    {
        if (size == 1)
        {
            head = tail;
            tail.next = null;
        } else if (size > 1)
        {
            Node<E> current = head;
            while (current.next != tail)
                current = current.next;
            tail.next = null;
            current.next = head;
            tail = current;
        }
        size--;
    }

    //  method for deleting the first Node in circularLinkedList
    public void deleteFirst()
    {
        if (size == 1)
        {
            head = tail;
            tail.next = null;
        } else if (size > 1)
        {
            Node<E> current = head;
            head = head.next;
            current.next = null;
            tail.next = head;
        }
        size--;
    }

    //  In this method, I create my own toString in order to elegantly print the output of the suitorList in an efficient way, using StringBuilder.
    public String toString()
    {
        Node<E> current = head;
        StringBuilder suitorList = new StringBuilder();

        if (size >= 1)
        {
            suitorList.append(current.element);
            current = current.next;
        }
        for (int i = 1; i < size; i++)
        {
            suitorList.append(" ").append(current.element.toString());
            current = current.next;
        }
        return suitorList.toString();
    }
}

//  this class is for the Node, which is what each int suitor is turned into when it is added to the ListOfSuitors
class Node<E>
{

    protected E element = null;
    protected Node<E> next = null;

    //  default constructor
    public Node()
    {

    }

    //  overloaded constructor
    public Node(E element, Node<E> next)
    {
        this.element = element;
        this.next = next;
    }

    public Node(E element)
    {
        this.element = element;
    }

    public Node(Node<E> next)
    {
        this.next = next;
    }
}
