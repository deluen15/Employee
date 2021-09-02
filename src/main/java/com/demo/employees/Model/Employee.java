package com.demo.employees.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "firstname")
    @JsonProperty("firstname")
    private String firstName;
    @Column(name = "lastname")
    @JsonProperty("lastname")
    private String lastName;
    @Column(name = "role")
    private String role;
    @Column(name = "employee_since")
    @JsonProperty("employee_since")
    private LocalDate employeeSince;
}
