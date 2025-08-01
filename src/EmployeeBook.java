public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void fillEmployees() {
        employees[0] = new Employee("Иванов", "Иван", "Иванович", 1, 55000);
        employees[1] = new Employee("Иванова", "Дарья", "Петровна", 1, 55000);
        employees[3] = new Employee("Кузнецова", "Татьяна", "Михайловна", 3, 85000);
        employees[4] = new Employee("Сорокин", "Виктор", "Дмитриевич", 3, 67000);
        employees[5] = new Employee("Петров", "Петр", "Петрович", 4, 35000);
        employees[6] = new Employee("Долгая", "Ольга", "Васильевна", 5, 78000);
        employees[7] = new Employee("Ванютин", "Иван", "Петрович", 5, 95000);
        employees[8] = new Employee("Тихонова", "Наталья", "Ивановна", 5, 115000);
        employees[9] = new Employee("Черный", "Александр", "Владимирович", 5, 115000);
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void printAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public int findMonthlySpendingForSalary(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public void findEmployeeWithMinSalary(Employee[] employees) {
        int min = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с минимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == min) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public void findEmployeeWithMaxSalary(Employee[] employees) {
        int max = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с максимальной зарплатой:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == max) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public double findAvgSalary(Employee[] employees) {
        int employeesCount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employeesCount++;
            }
        }
        int totalSalaries = findMonthlySpendingForSalary(employees);
        double avgSalary;
        avgSalary = (double) totalSalaries / employeesCount;
        return avgSalary;
    }

    public void printAllFullNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public void indexSalary(Employee[] employees, int indexationPercent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() / 100 * indexationPercent + employees[i].getSalary());
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", отдел " + employees[i].getDepartment() + ", индексированная зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public Employee findFirstEmployeeInGivenDept(Employee[] employees, int department) {
        Employee firstEmployeeInGivenDept = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                firstEmployeeInGivenDept = employees[i];
                break;
            }
        }
        return firstEmployeeInGivenDept;
    }

    public void findEmployeeWithMinSalaryInDept(Employee[] employees, int department) {
        Employee firstEmployeeInGivenDept = findFirstEmployeeInGivenDept(employees, department);
        int min = firstEmployeeInGivenDept.getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min && employees[i].getDepartment() == department) {
                min = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с минимальной зарплатой в отделе " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == min && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public void findEmployeeWithMaxSalaryInDept(Employee[] employees, int department) {
        Employee firstEmployeeInGivenDept = findFirstEmployeeInGivenDept(employees, department);
        int max = firstEmployeeInGivenDept.getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max && employees[i].getDepartment() == department) {
                max = employees[i].getSalary();
            }
        }
        System.out.println("Сотрудники с максимальной зарплатой в отделе " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == max && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }

    public int findTotalSpendingForSalariesInDept(Employee[] employees, int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        System.out.println("В отделе " + department + ":");
        return sum;
    }

    public double findAvgSalaryInDept(Employee[] employees, int department) {
        int employeesCount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getLastName() != null && employees[i].getDepartment() == department) {
                employeesCount++;
            }
        }
        int totalSalaries = findTotalSpendingForSalariesInDept(employees, department);
        double avgSalary;
        avgSalary = (double) totalSalaries / employeesCount;
        return avgSalary;
    }

    public void indexSalariesInDept(Employee[] employees, int department, int indexationPercent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() / 100 * indexationPercent + employees[i].getSalary());
            }
        }
        System.out.println("Индексированы зарплаты в отделе " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", индексированная зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public void printAllEmployeesInDept(Employee[] employees, int department) {
        System.out.println("Сотрудники отдела " + department + ":");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public void findEmployeesWithSmallerSalary(Employee[] employees, int value) {
        System.out.println("Сотрудники с зарплатой менее " + value + " руб.:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < value) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public void findEmployeesWithBiggerSalary(Employee[] employees, int value) {
        System.out.println("Сотрудники с зарплатой " + value + " руб. и более:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= value) {
                System.out.println(employees[i].getId() + " " + employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName() + ", зарплата: " + employees[i].getSalary() + " руб.");
            }
        }
    }

    public void addEmployee(Employee[] employees, String lastName, String firstName, String middleName, int department, int salary) {
        boolean isEmptySpace = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                isEmptySpace = true;
                employees[i] = new Employee(lastName, firstName, middleName, department, salary);
                System.out.println("Новый сотрудник: " + employees[i]);
                break;
            }
        }
        if (!isEmptySpace) {
            System.out.println("Нет места для записи");
        }
    }

    public void deleteEmployeeWithId(Employee[] employees, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
        System.out.println("Сотрудник с id " + id + " удалён");
    }

    public void findEmployeeWithId(Employee[] employees, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                System.out.println("Сотрудник с id " + employees[i]);
            }
        }
    }
}
