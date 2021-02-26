package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//Samuel Howell 3-3-20
public class TestEmployee {

    public static void main(String[] args) throws ParseException {
        //create scanner
        Scanner input = new Scanner(System.in);

        //ask user for Employee data fields
        System.out.println("Enter Employee's first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter Employee's last name: ");
        String lastName = input.nextLine();

        System.out.println("Enter Employee's position: ");
        String position = input.nextLine();

        System.out.println("Enter Employee's salary: ");
        double salary = input.nextDouble();

        input.nextLine();

        System.out.println("Enter Employee's office phone number: ");
        String officePhone = input.nextLine();

        //initialize employee object;
        Employee employee = new Employee(firstName, lastName, position, salary, officePhone);


        System.out.println("///////////////////////////////////////////////////////////////");
        /////////////////////////////////////////////////////////////////////////////
        //ask user for Dependent 1 data fields
        System.out.println("Enter Employee's dependent's first name: ");
        String dFirstName = input.nextLine();

        System.out.println("Enter Employee's dependent's last name: ");
        String dLastName = input.nextLine();

        System.out.println("Enter dependent's date of birth (MM/dd/yyyy): ");
        String date = input.nextLine();
        Date convertedDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);

        System.out.println("Enter dependent's relationship to the employee: ");
        String relationship = input.nextLine();

        //take acquired data and insert into dependent class
        Dependent1 dependent = new Dependent1(dFirstName, dLastName, convertedDate, relationship);

        //add this dependent to the ArrayList
        employee.addDependent(dependent.toString());

        System.out.println("///////////////////////////////////////////////////////////////");
        ///////////////////////////////////////////////////////////////////////

        //ask user for Dependent 2 data fields
        System.out.println("Enter Employee's dependent's first name: ");
        String d2FirstName = input.nextLine();

        System.out.println("Enter Employee's dependent's last name: ");
        String d2LastName = input.nextLine();

        System.out.println("Enter dependent's date of birth (MM/dd/yyyy): ");
        String date2 = input.nextLine();
        Date convertedDate2 = new SimpleDateFormat("MM/dd/yyyy").parse(date2);

        System.out.println("Enter dependent's relationship to the employee: ");
        String relationship2 = input.nextLine();

        //take acquired data and insert into dependent class
        Dependent2 dependent2 = new Dependent2(d2FirstName, d2LastName, convertedDate2, relationship2);

        //add this dependent to the ArrayList
        employee.addDependent(dependent2.toString());

        ///////////////////////////////////////////////////////////////////////

        //print out final results
        System.out.println("///////////////////////////  FINAL RESULTS  ///////////////////////////");
        System.out.println("Employee Information: ");
        System.out.println(employee.toString());
        System.out.println("Dependents' Information: ");
        employee.showDependents();

        // figure out how to get parent.
    }
}

class Employee {
    //instance variables
    private String firstName;
    private String lastName;
    private String position;
    private String officePhone;
    private double salary;

    //private String ArrayList
    private ArrayList<String> dependentsList = new ArrayList<String>();

    //constructor method for Employee
    Employee(String firstName, String lastName, String position, double salary, String officePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.officePhone = officePhone;
        this.salary = salary;
    }
    //setters and getters

    //firstName
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //lastName
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = lastName;
    }

    //position
    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    //officePhone
    public String getOfficePhone() {
        return this.officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    //salary
    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //add dependent to ArrayList
    public void addDependent(String dependent) {
        dependentsList.add(dependent);
    }

    //method to print dependentsList
    public void showDependents() {
        System.out.println(dependentsList.toString());
    }

    //display all employee details
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.position + " " + this.salary + " " + this.officePhone;
    }


}


class Dependent1 {
    private String dFirstName;
    private String dLastName;
    private Date dateOfBirth;
    private String relationship;

    //constructor method for dependent
    Dependent1(String firstName, String lastName, Date dateOfBirth, String relationship) {
        this.dFirstName = firstName;
        this.dLastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.relationship = relationship;

    }

    //setters and getters

    //firstName
    public String getFirstName() {
        return this.dFirstName;
    }

    public void setFirstName(String dFirstName) {
        this.dFirstName = dFirstName;
    }

    //lastName
    public String getLastName() {
        return this.dLastName;
    }

    public void setLastName(String dLastName) {
        this.dLastName = dLastName;
    }

    //dateOfBirth
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //relationship
    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }


    //display all dependent details
    public String toString() {
        return this.dFirstName + " " + this.dLastName + " " + this.dateOfBirth + " " + this.relationship;
    }
}

class Dependent2 {
    private String dFirstName;
    private String dLastName;
    private Date dateOfBirth;
    private String relationship;

    //constructor method for dependent
    Dependent2(String firstName, String lastName, Date dateOfBirth, String relationship) {
        this.dFirstName = firstName;
        this.dLastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.relationship = relationship;

    }

    //setters and getters

    //firstName
    public String getFirstName() {
        return this.dFirstName;
    }

    public void setFirstName(String dFirstName) {
        this.dFirstName = dFirstName;
    }

    //lastName
    public String getLastName() {
        return this.dLastName;
    }

    public void setLastName(String dLastName) {
        this.dLastName = dLastName;
    }

    //dateOfBirth
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //relationship
    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    //display all dependent details
    public String toString() {
        return this.dFirstName + " " + this.dLastName + " " + this.dateOfBirth + " " + this.relationship;
    }
}

