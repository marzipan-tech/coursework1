import java.util.Objects;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int department;
    private int salary;
    private int id;
    private static int idCount = 1;

    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.id = idCount++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, department, salary);
    }

    @Override
    public String toString() {
        return id + " " + lastName + " " + firstName + " " + middleName + ", отдел: " + department + ", зарплата: " + salary + " руб.";
    }
}