package com.example.employee.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateEmployeeRequest {
    @NotNull
    @NotBlank // entitilerde kullanılmaz request ve responselerde kullanılır.
    @Size(min = 3 , max= 20 )
    private String name;
    @NotNull
    @NotBlank // entitilerde kullanılmaz request ve responselerde kullanılır.
    @Size(min = 3 , max= 20 )
    private String lastName;
    @NotNull
    @NotBlank // entitilerde kullanılmaz request ve responselerde kullanılır.
    private String email;
}
