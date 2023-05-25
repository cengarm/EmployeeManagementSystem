package com.example.employee.wepApi.controllers;

import com.example.employee.business.abstracts.EmployeeService;
import com.example.employee.business.dtos.requests.CreateEmployeeRequest;
import com.example.employee.business.dtos.requests.UpdateEmployeeRequest;
import com.example.employee.business.dtos.responses.GetAllEmployeesResponse;
import com.example.employee.entity.concretes.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
    private EmployeeService employeeService;

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAll());
        return "index";
    }
    @GetMapping
    public List<GetAllEmployeesResponse> getAll(){
        return employeeService.getAll();
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateEmployeeRequest createEmployeeRequest){
        this.employeeService.add(createEmployeeRequest);
    }
    @PutMapping
    public void update(@RequestBody() @Valid UpdateEmployeeRequest updateEmployeeRequest){
        this.employeeService.uptade(updateEmployeeRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.employeeService.delete(id);
    }

}
