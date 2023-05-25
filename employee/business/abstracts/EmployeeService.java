package com.example.employee.business.abstracts;

import com.example.employee.business.dtos.requests.CreateEmployeeRequest;
import com.example.employee.business.dtos.requests.UpdateEmployeeRequest;
import com.example.employee.business.dtos.responses.GetAllEmployeesResponse;

import java.util.List;

public interface EmployeeService {

        List<GetAllEmployeesResponse> getAll();
        void add(CreateEmployeeRequest createEmployeeRequest);
        void uptade(UpdateEmployeeRequest updateEmployeeRequest);
        void delete(int id);
}
