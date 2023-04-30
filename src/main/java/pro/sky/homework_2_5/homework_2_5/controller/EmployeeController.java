package pro.sky.homework_2_5.homework_2_5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework_2_5.homework_2_5.employees.Employee;
import pro.sky.homework_2_5.homework_2_5.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public void removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        return employeeService.findEmployee(firstName, lastName);
    }

}
