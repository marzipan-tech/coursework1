import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов", "Иван", "Иванович", 1, 55000);
        employees[1] = new Employee("Иванова", "Дарья", "Петровна", 1, 55000);
        employees[2] = new Employee("Сидоров", "Иван", "Петрович", 2, 65000);
        employees[3] = new Employee("Кузнецова", "Татьяна", "Михайловна", 3, 85000);
        employees[4] = new Employee("Сорокин", "Виктор", "Дмитриевич", 3, 67000);
        employees[5] = new Employee("Петров", "Петр", "Петрович", 4, 35000);
        employees[6] = new Employee("Долгая", "Ольга", "Васильевна", 5, 78000);
        employees[7] = new Employee("Ванютин", "Иван", "Петрович", 5, 95000);
        employees[8] = new Employee("Тихонова", "Наталья", "Ивановна", 5, 115000);
        employees[9] = new Employee("Черный", "Александр", "Владимирович", 5, 115000);
        printAllEmployees(employees);
        System.out.println();
        System.out.println("Сумма затрат на зарплату в месяц: " + findMonthlySpendingForSalary(employees) + " руб.");
        System.out.println();
        findEmployeeWithMinSalary(employees);
        System.out.println();
        findEmployeeWithMaxSalary(employees);
        System.out.println();
        System.out.println("Среднее значение зарплат: " + findAvgSalary(employees) + " руб.");
        System.out.println();
        printAllFullNames(employees);
        System.out.println();
        indexSalary(employees, 5);
        System.out.println();
        findEmployeeWithMinSalaryInDept(employees, 5);
        System.out.println();
        findEmployeeWithMaxSalaryInDept(employees, 5);
        System.out.println();
        System.out.println("Сумма затрат на зарплату в месяц: " + findTotalSpendingForSalariesInDept(employees, 5) + " руб.");
        System.out.println();
        System.out.println("Среднее значение зарплат: " + findAvgSalaryInDept(employees, 3) + " руб.");
        System.out.println();
        indexSalariesInDept(employees, 1, 15);
        System.out.println();
        printAllEmployeesInDept(employees, 3);
        System.out.println();
        findEmployeesWithSmallerSalary(employees, 75000);
        System.out.println();
        findEmployeesWithBiggerSalary(employees, 120750);
    }

    public static void printAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int findMonthlySpendingForSalary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static void findEmployeeWithMinSalary(Employee[] employees) {
        int min = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с минимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == min) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public static void findEmployeeWithMaxSalary(Employee[] employees) {
        int max = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с максимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == max) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public static double findAvgSalary(Employee[] employees) {
        int employeesCount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getLastName() != null) {
                employeesCount++;
            }
        }
        int totalSalaries = findMonthlySpendingForSalary(employees);
        double avgSalary;
        avgSalary = (double) totalSalaries / employeesCount;
        return avgSalary;
    }

    public static void printAllFullNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
        }
    }

    public static void indexSalary(Employee[] employees, int indexationPercent) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() / 100 * indexationPercent + employees[i].getSalary());
        }
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", отдел " + employees[i].getDepartment() + ", индексированная зарплата: " + employees[i].getSalary() + " руб.");
        }
    }

    public static Employee findFirstEmployeeInGivenDept(Employee[] employees, int department) {
        Employee firstEmployeeInGivenDept = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                firstEmployeeInGivenDept = employees[i];
                break;
            }
        }
        return firstEmployeeInGivenDept;
    }

    public static void findEmployeeWithMinSalaryInDept(Employee[] employees, int department) {
        Employee firstEmployeeInGivenDept = findFirstEmployeeInGivenDept(employees, department);
        int min = firstEmployeeInGivenDept.getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min && employees[i].getDepartment() == department) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с минимальной зарплатой в отделе " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == min && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public static void findEmployeeWithMaxSalaryInDept(Employee[] employees, int department) {
        Employee firstEmployeeInGivenDept = findFirstEmployeeInGivenDept(employees, department);
        int max = firstEmployeeInGivenDept.getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max && employees[i].getDepartment() == department) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с максимальной зарплатой в отделе " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == max && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public static int findTotalSpendingForSalariesInDept(Employee[] employees, int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        System.out.println("В отделе " + department + ":");
        return sum;
    }

    public static double findAvgSalaryInDept(Employee[] employees, int department) {
        int employeesCount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getLastName() != null && employees[i].getDepartment() == department) {
                employeesCount++;
            }
        }
        int totalSalaries = findTotalSpendingForSalariesInDept(employees, department);
        double avgSalary;
        avgSalary = (double) totalSalaries / employeesCount;
        return avgSalary;
    }

    public static void indexSalariesInDept(Employee[] employees, int department, int indexationPercent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() / 100 * indexationPercent + employees[i].getSalary());
            }
        }
        System.out.println("Индексированы зарплаты в отделе " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", индексированная зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public static void printAllEmployeesInDept(Employee[] employees, int department) {
        System.out.println("Сотрудники отдела " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public static void findEmployeesWithSmallerSalary(Employee[] employees, int value) {
        System.out.println("Сотрудники с зарплатой менее " + value + " руб.:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < value) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public static void findEmployeesWithBiggerSalary(Employee[] employees, int value) {
        System.out.println("Сотрудники с зарплатой более " + value + " руб.:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= value) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }
}