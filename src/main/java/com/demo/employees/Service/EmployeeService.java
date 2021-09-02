package com.demo.employees.Service;

import com.demo.employees.Model.Employee;
import com.demo.employees.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveAll(List<Employee> employees){
        repository.saveAll(employees);
    }

    public List<Employee> findAll(){
        return (List<Employee>) repository.findAll();
    }

    public Optional<Employee> findById(long id){
        return repository.findById(id);
    }
}
