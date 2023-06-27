package org.example.service;

import org.example.dto.Input;
import org.example.dto.Output;
import org.example.dto.Result;
import org.example.repository.RepoImplm;
import org.example.repository.RepoInterf;
import org.example.repository.entity.ResultEntity;
import org.example.utilites.ExeptionInput;
import org.example.utilites.IntegralMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceImplm implements ServiceInterf {

    private final RepoInterf repo;

    public ServiceImplm(RepoInterf repo){
        this.repo = repo;
    }

    @Override
    public Double intagrate(Input input){
        ExeptionInput.checkExeption(input.getA(), input.getB(), input.getStep());
        Result integrationResult = IntegralMethod.integral(input.getAlgo(), input.getA(), input.getB(), input.getStep());
        ResultEntity entity = ResultEntity.builder().input(input).result(integrationResult).build();
        return repo.saveResult(entity);
    }

    @Override
    public Output getIntegrationResult(Integer id){
        ResultEntity entity = repo.getResultById(id);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result not found");
        }
        Output output;
        output = Output.builder().id(entity.getId()).input(entity.getInput()).result(entity.getResult()).build();

        return output;
    }
}
