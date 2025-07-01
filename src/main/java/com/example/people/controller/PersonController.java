package com.example.people.controller;

import com.example.people.dto.request.PersonRequestDTO;
import com.example.people.dto.response.PersonResponseDTO;
import com.example.people.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> findById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> findAll(){
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> save(@RequestBody PersonRequestDTO personDTO, UriComponentsBuilder uriBuilder){

        PersonResponseDTO personResponseDTO = personService.save(personDTO);

        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(personResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(personResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonRequestDTO personDTO, @PathVariable(value = "id") Long id){
        return  ResponseEntity.ok().body(personService.update(personDTO,id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(personService.deleteById(id));
    }

}
