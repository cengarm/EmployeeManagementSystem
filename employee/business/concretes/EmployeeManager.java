package com.example.employee.business.concretes;

import com.example.employee.business.abstracts.EmployeeService;
import com.example.employee.business.dtos.requests.CreateEmployeeRequest;
import com.example.employee.business.dtos.requests.UpdateEmployeeRequest;
import com.example.employee.business.dtos.responses.GetAllEmployeesResponse;
import com.example.employee.core.utilities.mappers.ModelMapperService;
import com.example.employee.dataAccess.abstracts.EmployeeRepository;
import com.example.employee.entity.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ModelMapperService modelMapperService;



    @Override
    public List<GetAllEmployeesResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeesResponse> employeesResponses =  employees.stream()
                .map(brand ->this.modelMapperService
                        .forResponse().map(brand,GetAllEmployeesResponse.class)).collect(Collectors.toList());
        return employeesResponses;
    }


    @Override
    public void add(CreateEmployeeRequest createEmployeeRequest) {
    Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
                        this.employeeRepository.save(employee);
    }

    @Override
    public void uptade(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
    this.employeeRepository.deleteById(id);
    }
}
