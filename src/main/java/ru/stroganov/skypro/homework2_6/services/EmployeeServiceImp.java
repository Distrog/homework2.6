package ru.stroganov.skypro.homework2_6.services;

import org.springframework.stereotype.Service;
import ru.stroganov.skypro.homework2_6.exceptions.EmployeeAlreadyAddedException;
import ru.stroganov.skypro.homework2_6.exceptions.EmployeeNotFoundException;
import ru.stroganov.skypro.homework2_6.exceptions.EmployeeStorageIsFullException;
import ru.stroganov.skypro.homework2_6.models.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final List<Employee> employees;
    private final int maxNumberOfEmployees;

    public EmployeeServiceImp() {
        employees = new ArrayList<>();
        maxNumberOfEmployees = 20;
    }

    @Override
    public Employee add(Employee employee) {
        if (employees.size() >= (maxNumberOfEmployees - 1)) {
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже имеется в коллекции");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Удаляемы сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public String info() {
        return employees.toString();
    }
}
