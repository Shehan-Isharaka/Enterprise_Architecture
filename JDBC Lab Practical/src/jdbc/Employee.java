/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

/**
 *
 * @author Admin
 */
public class Employee {

    private int id;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method to represent the Employee object
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', position='" +
                position + "', salary=" + salary + '}';
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        // Create a new Employee object
        Employee employee1 = new Employee(1, "John Doe", "Software Engineer", 75000.00);
        Employee employee2 = new Employee(2, "Jane Smith", "Project Manager", 85000.00);

        // Print the Employee objects
        System.out.println(employee1);
        System.out.println(employee2);

        // Modify the employee1 details
        employee1.setPosition("Senior Software Engineer");
        employee1.setSalary(80000.00);

        // Print the updated employee1 details
        System.out.println("Updated Employee: " + employee1);
    }
}

