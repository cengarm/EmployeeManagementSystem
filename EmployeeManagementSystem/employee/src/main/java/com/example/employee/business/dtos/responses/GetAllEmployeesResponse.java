package com.example.employee.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeesResponse {
    private int id;
    private String name;
    private String lastName;
    private String email;
}
