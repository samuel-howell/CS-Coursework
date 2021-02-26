package com.company;

import java.util.*;

//Samuel Howell 1-22-2020
public class TestBook {

    public static void main(String[] args) {

        //create scanner
        Scanner input = new Scanner(System.in);

        //create bookstore object
        BookStore bookStore = new BookStore("731 Main Street", "Florence", "SC");

        //create book object content for Array List
        Book book = new Book(null, null, 0.0);

        //create null author object
        Author author = new Author(null, null);

        boolean flag = false;

        while(!flag) {
            System.out.println("Enter Book Title: ");
            String title = input.nextLine();
            book.setTitle(title);

            System.out.println("Enter Author's first name: ");
            String firstName = input.nextLine();
            author.setFirstName(firstName);

            System.out.println("Enter Author's last name: ");
            String lastName = input.nextLine();
            author.setLastName(lastName);

            //set the author based on the aforementioned firstName and lastName
            book.setAuthor(author);

            System.out.println("Enter Book Price: ");
            double price = input.nextDouble();
            book.setPrice(price);

            input.nextLine();

            System.out.println("---------------------------------------------");

            //add this iteration of the Book object to the arrayList
            bookStore.addBook(book.toString());

            //ask user if they want to enter another entry
            System.out.println("Do you want to add another entry? Y/N");

            String response = input.nextLine();
                if(response.equals("Y")) {
                    flag = false;
                }
                if(response.equals("N")){
                    flag = true;
                }
        }//end while loop

        //print the stock listArray
        bookStore.showStock();
    }//end main class
}//end testbook class

class Author {

    //instance variables
    private String firstName;
    private String lastName;

    //constructor method
    Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    //instance methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}// end author class

class Book {

    //instance variables
    private String title;
    private Author author;
    private double price;

    //constructor method
    Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    //instance methods

    //title
    public void setTitle(String title) {
        this.title = title;
    }

    //author
    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    //price
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //display all book details
    public String toString() {
        return this.title + " " + this.author + " " + this.price;
    }
}// end book class

class BookStore {

    //instance variables
    private String address;
    private String city;
    private String state;

    //private String ArrayList;
    private ArrayList<String> bookArray = new ArrayList<String>();

    //constructor method for Bookstore
    BookStore(String address, String city, String state) {
        this.address = address;
        this.city = city;
        this.state = state;
    }

    //instance methods

    //address
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //state
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //city
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //method to print listArray
    public void showStock() {
        System.out.println(bookArray.toString());
    }

    //method to add books to listArray
    public void addBook(String book) {
        bookArray.add(book);
    }


}//end bookstore class








