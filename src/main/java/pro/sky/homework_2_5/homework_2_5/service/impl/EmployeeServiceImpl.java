package pro.sky.homework_2_5.homework_2_5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_5.homework_2_5.employees.Employee;
import pro.sky.homework_2_5.homework_2_5.exception.ArrayIsFull;
import pro.sky.homework_2_5.homework_2_5.exception.EmployeeAlreadyAdded;
import pro.sky.homework_2_5.homework_2_5.exception.EmployeeNotFound;
import pro.sky.homework_2_5.homework_2_5.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE = 5;
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAdded("Сотрудник уже есть в стиске!");
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new ArrayIsFull("Список заполнен!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAdded("Такой сотрудник есть в списке!");
        }
        employees.remove(employee);

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeNotFound("Такого сотрудника нет в списке!");
        }
        for (Employee value : employees) {
            if (value.equals(employee)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }
}
