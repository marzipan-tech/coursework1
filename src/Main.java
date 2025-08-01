import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        book.fillEmployees();
        book.printAllEmployees(book.getEmployees());
        System.out.println();
        System.out.println("Сумма затрат на зарплату в месяц: " + book.findMonthlySpendingForSalary(book.getEmployees()) + " руб.");
        System.out.println();
        book.findEmployeeWithMinSalary(book.getEmployees());
        System.out.println();
        book.findEmployeeWithMaxSalary(book.getEmployees());
        System.out.println();
        System.out.println("Среднее значение зарплат: " + book.findAvgSalary(book.getEmployees()) + " руб.");
        System.out.println();
        book.printAllFullNames(book.getEmployees());
        System.out.println();
        book.indexSalary(book.getEmployees(), 5);
        System.out.println();
        book.findEmployeeWithMinSalaryInDept(book.getEmployees(), 5);
        System.out.println();
        book.findEmployeeWithMaxSalaryInDept(book.getEmployees(), 5);
        System.out.println();
        System.out.println("Сумма затрат на зарплату в месяц: " + book.findTotalSpendingForSalariesInDept(book.getEmployees(), 5) + " руб.");
        System.out.println();
        System.out.println("Среднее значение зарплат: " + book.findAvgSalaryInDept(book.getEmployees(), 3) + " руб.");
        System.out.println();
        book.indexSalariesInDept(book.getEmployees(), 1, 15);
        System.out.println();
        book.printAllEmployeesInDept(book.getEmployees(), 3);
        System.out.println();
        book.findEmployeesWithSmallerSalary(book.getEmployees(), 75000);
        System.out.println();
        book.findEmployeesWithBiggerSalary(book.getEmployees(), 120750);
        System.out.println();
        book.addEmployee(book.getEmployees(), "Федоров", "Олег", "Витальевич", 1, 75000);
        book.printAllEmployees(book.getEmployees());
        System.out.println();
        book.deleteEmployeeWithId(book.getEmployees(), 8);
        book.printAllEmployees(book.getEmployees());
        System.out.println();
        book.findEmployeeWithId(book.getEmployees(), 3);
    }
}