package com.demo.employees;

import com.demo.employees.Model.EmployeeArray;
import com.demo.employees.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner{
  final
  EmployeeService service;

    public EmployeesApplication(EmployeeService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    @SneakyThrows
    @Override
    public void run(String... args) {
        ObjectMapper objectMapper = new ObjectMapper();


        objectMapper.registerModule(new JavaTimeModule());

        String allEmployees = "{\n" +
                "  \"employees\": [\n" +
                "    {\n" +
                "      \"firstname\": \"Joscha\",\n" +
                "      \"lastname\": \"Burkholz\",\n" +
                "      \"role\": \"Geschäftsführer\",\n" +
                "      \"employee_since\": \"2019-03-01\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstname\": \"Philipp\",\n" +
                "      \"lastname\": \"Haltermann\",\n" +
                "      \"role\": \"Software Engineer\",\n" +
                "      \"employee_since\": \"2020-03-15\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstname\": \"Stefan\",\n" +
                "      \"lastname\": \"Burkholz\",\n" +
                "      \"role\": \"DevOps Specialist\",\n" +
                "      \"employee_since\": \"2020-04-01\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstname\": \"Jennifer\",\n" +
                "      \"lastname\": \"Burkholz\",\n" +
                "      \"role\": \"Büroassistenz\",\n" +
                "      \"employee_since\": \"2021-02-01\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstname\": \"Jana\",\n" +
                "      \"lastname\": \"Bayarami Alwandi\",\n" +
                "      \"role\": \"Werkstudentin HR\",\n" +
                "      \"employee_since\": \"2021-08-16\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        EmployeeArray employeeArray = objectMapper.readValue(allEmployees, EmployeeArray.class);
        service.saveAll(employeeArray.getEmployees());
    }
}


