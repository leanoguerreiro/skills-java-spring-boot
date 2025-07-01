package com.example.people.service;

import com.example.people.dto.request.PersonRequestDTO;
import com.example.people.dto.response.PersonResponseDTO;
import com.example.people.entity.Person;
import com.example.people.repository.PersonRepository;
import com.example.people.utils.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {

        if (returnPerson(id) == null) {
            System.out.println("Invalid person ID");
            return null;
        }

        Person person = returnPerson(id);

        return personMapper.toPersonDTO(person);
    }

    @Override
    public List<PersonResponseDTO> findAll() {

        if (returnAll() == null) {
            throw new IndexOutOfBoundsException("Invalid person ID");
        }

        List<Person> peopleList = personRepository.findAll();

        return personMapper.toPersonDTO(peopleList);
    }

    @Override
    public PersonResponseDTO save(PersonRequestDTO requestDTO) {

        Person person = personMapper.toPerson(requestDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {
        Person person = returnPerson(id);

        personMapper.updatePersonData(person, personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public String deleteById(Long id) {

        personRepository.deleteById(id);

        return "person: "+id+" deleted successfully";
    }

    private Person returnPerson(Long id) {
        return personRepository.findById(id).orElseThrow(()-> new RuntimeException("person not found"));
    }

    private Person returnAll() {
        return  personRepository.findAll().stream().findFirst().orElseThrow(()-> new RuntimeException("person not found"));
    }
}
