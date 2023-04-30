package pro.sky.homework_2_5.homework_2_5.service;

import pro.sky.homework_2_5.homework_2_5.employees.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getEmployees();


}
