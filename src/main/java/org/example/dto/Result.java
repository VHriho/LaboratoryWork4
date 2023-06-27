package org.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Data
public class Result {
    private double finalResult;
    private double step;
    private double a;
    private double b;
    private String algo;

    private String inTegratedFunction = "x^2";

    public void setFinalResult(double finalResult){
        this.finalResult = finalResult;
    }

    public void setStep(double step){
        this.step = step;
    }

    public void setA(double a){
        this.a = a;
    }

    public void setB(double b){
        this.b = b;
    }

    public void setAlgo(String algo){
        this.algo= algo;
    }
}
