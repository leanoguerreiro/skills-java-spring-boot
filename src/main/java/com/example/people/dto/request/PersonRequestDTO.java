package com.example.people.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class PersonRequestDTO {
    @NotBlank(message = "Campo obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve conter no mínimo 2 caracteres e no máximo 100 caracetes")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    private String cpf;

    @NotNull(message = "Campo obrigatório")
    private Integer age;
}
