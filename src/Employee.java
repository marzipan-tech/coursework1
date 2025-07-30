import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private int salary;
    private int id;
    private static int idCount = 1;

    public Employee(String fullName, int department, int salary) {
        this.id = idCount++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
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
        return department == employee.department && salary == employee.salary && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }

    @Override
    public String toString() {
        return id + " " + fullName + ", отдел: " + department + ", зарплата: " + salary;
    }
}