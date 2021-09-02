package com.demo.employees.Controller;

import com.demo.employees.Model.Employee;
import com.demo.employees.Service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/")
public class EmployeeController {

    final
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping()
    public List<Employee> findAll(Employee employee, Model model){
        model.addAttribute("employee", employee);
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable (value = "id") long id){
        Employee employee = new Employee();
        return service.findById(id);
    }
}
