package ru.stroganov.skypro.homework2_6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.skypro.homework2_6.models.Employee;
import ru.stroganov.skypro.homework2_6.services.EmployeeServiceImp;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImp employeeService;

    public EmployeeController(EmployeeServiceImp employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        return employeeService.add(new Employee(firstName, lastName));
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName){
        return employeeService.remove(new Employee(firstName,lastName));
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName){
        return employeeService.find(new Employee(firstName,lastName));
    }

    @GetMapping("/info")
    public List<Employee> info(){
        return employeeService.info();
    }
}
