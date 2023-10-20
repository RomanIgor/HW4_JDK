/*
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник сотрудников
 */
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();


        directory.addEmployee(new Employee(1, "1234567890", "John", 5));
        directory.addEmployee(new Employee(2, "9876543210", "Jane", 3));
        directory.addEmployee(new Employee(3, "5555555555", "Bob", 7));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите, что вы хотите найти:");
            System.out.println("1. По стажу");
            System.out.println("2. По номеру телефона");
            System.out.println("3. По табельному номеру");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера ввода

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите стаж: ");
                    int experienceToSearch = scanner.nextInt();
                    scanner.nextLine();


                    List<Employee> employeesWithExperience = directory.findEmployeesByExperience(experienceToSearch);
                    System.out.println("Сотрудники со стажем " + experienceToSearch + " лет:");
                    for (Employee employee : employeesWithExperience) {
                        System.out.println("Имя: " + employee.getName() + ", Телефон: " + employee.getPhoneNumber());
                    }
                }
                case 2 -> {
                    System.out.print("Введите имя для поиска номера телефона: ");
                    String nameToSearch = scanner.nextLine();

                    String phoneNumber = directory.findPhoneNumberByName(nameToSearch);
                    if (phoneNumber != null) {
                        System.out.println("Номер телефона сотрудника " + nameToSearch + ": " + phoneNumber);
                    } else {
                        System.out.println("Сотрудник с именем " + nameToSearch + " не найден.");
                    }
                }
                case 3 -> {
                    System.out.print("Введите табельный номер для поиска: ");
                    int employeeIdToSearch = scanner.nextInt();
                    scanner.nextLine();

                    Employee employee = directory.findEmployeeByEmployeeId(employeeIdToSearch);
                    if (employee != null) {
                        System.out.println("Сотрудник с табельным номером " + employeeIdToSearch + ": Имя - " + employee.getName());
                    } else {
                        System.out.println("Сотрудник с табельным номером " + employeeIdToSearch + " не найден.");
                    }
                }
                case 4 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
