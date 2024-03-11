package ru.stroganov.skypro.homework2_6.services;

import ru.stroganov.skypro.homework2_6.models.Employee;

public interface EmployeeService {
    Employee add(Employee employee);

    Employee remove(Employee employee);

    Employee find(Employee employee);

    String info();
}
