package com.example.people.dto.response;

import com.example.people.entity.Person;
import lombok.Getter;

@Getter
public class PersonResponseDTO {
    private final Long id;

    private final String name;

    private final String cpf;

    private final Integer age;

    public PersonResponseDTO(Person person) {
            this.id = person.getId();
            this.name = person.getName();
            this.cpf = person.getCpf();
            this.age = person.getAge();
    }
}
