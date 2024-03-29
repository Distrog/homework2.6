package ru.stroganov.skypro.homework2_6.services;

import ru.stroganov.skypro.homework2_6.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);

    Employee remove(Employee employee);

    Employee find(Employee employee);

    List<Employee> info();
}
