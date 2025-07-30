public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 1, 55000);
        employees[1] = new Employee("Иванова Дарья Петровна", 1, 55000);
        employees[2] = new Employee("Сидоров Иван Петрович", 2, 65000);
        employees[3] = new Employee("Кузнецова Татьяна Михайловна", 3, 85000);
        employees[4] = new Employee("Сорокин Виктор Дмитриевич", 3, 67000);
        employees[5] = new Employee("Петров Петр Петрович", 4, 35000);
        employees[6] = new Employee("Долгая Ольга Васильевна", 5, 78000);
        employees[7] = new Employee("Ванютин Иван Петрович", 5, 95000);
        employees[8] = new Employee("Тихонова Наталья Ивановна", 5, 115000);
        employees[9] = new Employee("Черный Александр Владимирович", 5, 115000);
        printAllEmployees(employees);
        System.out.println();
        System.out.println("Сумма затрат на зарплату в месяц: " + getMonthlySpendingForSalary(employees) + " руб.");
        System.out.println();
        getEmployeeWithMinSalary(employees);
        System.out.println();
        getEmployeeWithMaxSalary(employees);
        System.out.println();
        System.out.println("Среднее значение зарплат: " + getAvgSalary(employees) + " руб.");
        System.out.println();
        printAllFullNames(employees);
    }
    public static void printAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int getMonthlySpendingForSalary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static void getEmployeeWithMinSalary(Employee[] employees) {
        int min = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с минимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == min) {
                System.out.println(employees[i].getFullName());
            }
        }
    }

    public static void getEmployeeWithMaxSalary(Employee[] employees) {
        int max = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с максимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == max) {
                System.out.println(employees[i].getFullName());
            }
        }
    }

    public static int getAvgSalary(Employee[] employees) {
        int employeesCount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName() != null) {
                employeesCount++;
            }
        }
        int totalSalaries = getMonthlySpendingForSalary(employees);
        int avgSalary;
        avgSalary = totalSalaries / employeesCount;
        return avgSalary;
    }

    public static void printAllFullNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullName());
        }
    }
}