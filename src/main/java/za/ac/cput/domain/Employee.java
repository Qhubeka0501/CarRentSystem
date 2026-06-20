package za.ac.cput.domain;

/*
 * Class Name: Employee
 * Description: Employee CarRentSystem class
 * Author: Avuyile Twesha (240763394)
 * Date: 20 June 2026
 */

public class Employee {
    private String employeeId;
    private String firstName;
    private String email;
    private String phoneNumber;
    private double salary;
    private String password;
    private String role;

    protected Employee() {
    }

    protected Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.salary = builder.salary;
        this.password = builder.password;
        this.role = builder.role;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getSalary() {
        return salary;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }

    @Override public String toString() {
        return "Employee{" + "employeeId='" + employeeId + '\''
                + ", firstName='" + firstName + '\''
                + ", email='" + email + '\''
                + ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary + ", role='" + role + '\'' + '}';
    }

    public static class Builder {
        protected String employeeId;
        protected String firstName;
        protected String email;
        protected String phoneNumber;
        protected double salary;
        protected String password;
        protected String role;



        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.firstName = employee.firstName;
            this.email = employee.email;
            this.phoneNumber = employee.phoneNumber;
            this.salary = employee.salary;
            this.password = employee.password;
            this.role = employee.role;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
































}
