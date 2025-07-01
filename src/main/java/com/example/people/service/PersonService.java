package com.example.people.service;

import com.example.people.dto.response.PersonResponseDTO;
import com.example.people.dto.request.PersonRequestDTO;
import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> findAll();

    PersonResponseDTO save(PersonRequestDTO requestDTO);

    PersonResponseDTO update(PersonRequestDTO dto, Long id);

    void deleteById(Long id);
}
