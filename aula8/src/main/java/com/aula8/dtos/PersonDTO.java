package com.aula8.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PersonDTO  {
    @Nullable
    private Long id;

    @NotEmpty(message = "O campo 'firstName' não pode estar vazio")
    private String firstName;

    @NotEmpty(message = "O campo 'lastName' não pode estar vazio")
    private String lastName;

    @NotEmpty(message = "O campo 'address' não pode estar vazio")
    private String address;

    @NotEmpty(message = "O campo 'gender' não pode estar vazio")
    private String gender;
}
