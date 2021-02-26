package com.company;

/*
Name: Samuel Howell
Email: samuel.howell@g.fmarion.edu
Date: 9-12-2020
File name: CircularLinkedListPrblem.java
Class: CS-227
Description: This is a program that creates and iterates through a circularLinkedList, eliminating every 3rd node, until only 1 is left.
 */
public class CircularLinkedListProblem
{


    public static void main(String[] args)
    {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        list.addSuitor("Joe");
        list.addSuitor("Jack");
        list.addSuitor("John");
        list.addSuitor("Jonah");
        list.addSuitor("James");
        list.addSuitor("Jesse");

        System.out.println("The available suitors are: ");
        list.print();
        System.out.println();

        System.out.println("Removing every third suitor until there is a winner...");
        System.out.println();
        list.tagTheLosers();
        list.removeTheLosers();

        System.out.println("AND....the winner of the suitors is: ");
        list.print();

    }
}

class CircularLinkedList<E>
{

    private Node<E> head;
    private Node<E> tail;
    public int size;

    //  default constructor
    public CircularLinkedList()
    {

    }

    //  method to add a new suitor to the circularLinkedList
    public void addSuitor(E suitor)
    {
        Node<E> newSuitor = new Node<>(suitor);

        if (head == null)                                   //  starts a new circularList if one doesn't already exist
        {
            head = newSuitor;
            tail = newSuitor;
            newSuitor.next = head;
        } else
        {
            tail.next = newSuitor;                           //  tail points to the new suitor.
            tail = newSuitor;                                //  new suitor becomes the new tail
            tail.next = head;                                //  tail then points to head because it is circular.
        }
        size++;
    }

    //  This method takes all the losers and replaces their element with a "!" aka the tag.
    public void tagTheLosers()
    {
        Node<E> current = head;
        for (int i = size; i > 1; i--)
        {
            int spacer = 0;                                             //  keeps track of the 3 spaces needed between each suitor

            //make ! the contents of the node
            if (current.getElement().equals("!@%$"))
            {
                while (spacer < 3)                                      //  this adds an extra spacer to account for the current node which is tagged
                {
                    while (current.next.getElement().equals("!@%$"))       //  this skips over elements that have already been tagged.
                    {
                        current = current.next;
                    }
                    current = current.next;
                    spacer++;
                }
            } else
            {
                while (spacer != 2)                                     //  current counts 3 positions over in the linked list
                {
                    current = current.next;
                    spacer++;
                }
            }
            current.setElement((E) "!@%$");                                //  make ! the contents of the node, thereby tagging it for eventual deletion
        }
    }


    //this method removes any node that contains a tag.
    public void removeTheLosers()
    {
        Node<E> current = head;     //  initialize them both to head, that way previous will trail current by one node when previous = current and current = current.next
        Node<E> previous = head;
        do
        {
            previous.next = current;
            current = current.next;
            if (current.getElement().equals("!@%S"))       //deletes the current Node if it contains a tag.???????????
            {
                previous.next = current.next;
            } else
            {
                current = current.next;                 //  if the current node doesn't contain a tag (aka is the winner) then simply move onto the next node
            }
            size--;
        } while (size != 1);
    }

    public void print()
    {
        Node<E> temp = head;
        do
        {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        while (temp != head);
        System.out.println();
    }
}

class Node<E>
{

    E element;
    Node<E> next;

    public Node(E object)
    {
        this.element = object;
    }

    public E getElement()
    {
        return element;
    }

    public void setElement(E element)
    {
        this.element = element;
    }
}
