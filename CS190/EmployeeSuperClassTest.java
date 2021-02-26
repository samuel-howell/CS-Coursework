package com.company;

//samuel Howell 2-12-20

import java.util.ArrayList;

public class EmployeeSuperClassTest {

    public static void main(String[] args) {
        //instantiate bookstore
        Bookstore bookstore = new Bookstore("456 Main Street", "777-3785");

        //instantiate employee
        Employee employee1 = new Employee("Richard Smith", "08/22/1987", "002");
        bookstore.addEmployee(employee1.toString());
        Employee employee2 = new Employee("Karen Brown", "01/01/1978", "017");
        bookstore.addEmployee(employee2.toString());

        //instantiate dependent
        Dependent dependent = new Dependent("Sally Brown", "06/30/2008", "DAUGHTER", employee2.getEmployeeID());

        //instantiate authors
        Author author1 = new Author("John Mills", "08/12/1916", "001");
        Author author2 = new Author("Russel Johnson", "06/04/1965", "002");

        //instantiate books
        Book book1 = new Book("My Life in Spain", author1.getAuthorID());
        bookstore.addBook(book1);
        Book book2 = new Book("My Favorite Dog", author1.getAuthorID());
        bookstore.addBook(book2);
        Book book3 = new Book("Home Repair", author2.getAuthorID());
        bookstore.addBook(book3);

        System.out.println("-----------------------------------------------------------------------");

        //first line
        System.out.println(bookstore.toString());
        //second line
        System.out.print("Title, AuthorID: ");
        bookstore.showBookList();
        //third line
        System.out.print("author: " + author1.toString());
        System.out.print(" author: " + author2.toString());
        //fourth line
        System.out.println();
        System.out.print("Employees: ");
        bookstore.showEmpList();
        //fifth line
        System.out.println("Dependents: " + dependent.toString());
    }
}

class Person {
    private String name;
    private String DOB;

    Person(String name, String DOB) {
        this.name = name;
        this.DOB = DOB;

    }

    public String getName() {
        return name;
    }

    //setter and getters
    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String toString() {
        return this.name + " " + this.DOB;
    }
}

class Dependent extends Person {
    private String relationship;
    private String parentID;

    Dependent(String name, String DOB, String relationship, String parentID) {
        super(name, DOB);
        this.relationship = relationship;
        this.parentID = parentID;
    }

    //setters and getters
    public String getParentID() {
        return this.parentID;
    }

    public void setParentID(String employeeID) {
        this.parentID = employeeID;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String toString() {
        return super.toString() + " " + this.relationship + " , parent ID: " + this.parentID;
    }
}


class Employee extends Person {
    private String employeeID;

    Employee(String name, String DOB, String employeeID) {
        super(name, DOB);
        ;
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    //setter and getter
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String toString() {
        return super.toString() + " " + this.employeeID;
    }
}

class Bookstore {
    private String address; //streetnumber - streetname
    private String phone; //XXX-XXXX
    private ArrayList<String> bookList = new ArrayList<>();  // title, AuthorID
    private ArrayList<String> empList = new ArrayList<>();  // employeeID

    Bookstore(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    //setters and getters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.address = phone;
    }

    public void addBook(Book book) {
        bookList.add(book.toString());
    }

    public void showBookList() {
        System.out.println(bookList.toString());
    }

    public void addEmployee(String employeeID) {
        empList.add(employeeID);
    }

    public void showEmpList() {
        System.out.println(empList.toString());
    }

    //location
    public String toString() {
        return "book store location: " + this.address + " phone: " + this.phone;
    }
}


class Book {
    private String title;
    private String authorID;

    Book(String title, String authorID) {
        this.title = title;
        this.authorID = authorID;
    }

    //setter and getter
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return this.title + " " + this.authorID;
    }
}

class Author extends Person {
    private String authorID;

    Author(String name, String DOB, String authorID) {
        super(name, DOB);
        this.authorID = authorID;
    }

    public String getAuthorID() {
        return authorID;
    }

    //setter and getter
    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String toString() {
        return super.toString() + " " + this.authorID;
    }
}
