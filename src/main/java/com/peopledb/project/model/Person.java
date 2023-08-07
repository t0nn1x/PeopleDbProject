package com.peopledb.project.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @Email(message = "Email must ve valid")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Past(message = "Date of birth must be in the past")
    @NotNull(message = "Date of birth must be specified")
    private LocalDate dob;
    
    @DecimalMin(value = "1000.00", message = "Salary must be at least 1000")
    @NotNull(message = "Salary cannot be empty")
    private BigDecimal salary;

    private String photoFilename;
}
