package org.example.presentation;

import org.example.dto.Input;
import org.example.dto.Output;
import org.example.service.ServiceInterf;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/integration")
public class Presentation {

    private final ServiceInterf serviceInterf;

    public Presentation(ServiceInterf serviceInterf){
        this.serviceInterf = serviceInterf;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Double intagrate(@RequestBody Input input){
        try{
            return serviceInterf.intagrate(input);
        } catch (IllegalArgumentException e) {
            String error = "Invalid input: " + e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Output> getResults(@PathVariable("id") Integer id) {
        try {
            Output result = serviceInterf.getIntegrationResult(id);
            return ResponseEntity.ok(result);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getRawStatusCode()).body(null);
        }
    }
}
