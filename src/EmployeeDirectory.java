import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    // Метод для добавления нового сотрудника
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Метод для поиска сотрудника(-ов) по стажу
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    // Метод для поиска номера телефона сотрудника по имени
    public String findPhoneNumberByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee.getPhoneNumber();
            }
        }
        return null;
    }

    // Метод для поиска сотрудника по табельному номеру
    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}