/**
 * 
 */
package java_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private int age;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee other) {
        // Compare by age
        int ageComparison = Integer.compare(this.age, other.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        // If ages are equal, compare by salary
        return Double.compare(this.salary, other.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}

public class EmployeeData {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Generate 10 random employees
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Employee" + (i + 1);
            double salary = 10000 + random.nextInt(90000); // Generating a random salary between 10000 and 99999
            int age = 18 + random.nextInt(83); // Generating a random age between 18 and 100
            employees.add(new Employee(name, salary, age));
        }

        // Sorting employees based on age
        Collections.sort(employees, (emp1, emp2) -> Integer.compare(emp1.getAge(), emp2.getAge()));
        System.out.println("Sorted by Age:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Sorting employees based on salary
        Collections.sort(employees, (emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()));
        System.out.println("\nSorted by Salary:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
