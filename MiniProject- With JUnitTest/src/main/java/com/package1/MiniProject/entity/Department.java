package com.package1.MiniProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Department name is required")
    @Size(max = 255, message = "Department name cannot exceed 255 characters")
    private String departName;

    @Size(max = 255, message = "Department address cannot exceed 255 characters")
    private String departAddress;

    @Size(max = 10, message = "Department code cannot exceed 10 characters")
    @NotNull(message = "Department address is required")
    private String departCode;

}
