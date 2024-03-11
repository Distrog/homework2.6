package ru.stroganov.skypro.homework2_6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stroganov.skypro.homework2_6.models.Employee;
import ru.stroganov.skypro.homework2_6.services.EmployeeServiceImp;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImp employeeService;

    public EmployeeController(EmployeeServiceImp employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        return employeeService.add(new Employee(firstName, lastName)).toString();
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName){
        return employeeService.remove(new Employee(firstName,lastName)).toString();
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName){
        return employeeService.find(new Employee(firstName,lastName)).toString();
    }

    @GetMapping("/info")
    public String info(){
        return employeeService.info();
    }
}
