package org.example.utilites;

import org.example.dto.Result;
import lombok.experimental.UtilityClass;

@UtilityClass
public class IntegralMethod {
    public static Result integral(String algo, double a, double b, double step){
        double integr = 0;
        double h = step/10.0;
        switch (algo){
            case "left":
                for (int i = 0; i < 10; i++){
                    integr += Math.pow(a + h * i, 2)*h;
                }
                break;
            case "right":
                for (int i = 0; i < 10; i++){
                    integr += Math.pow(b-h*i, 2)*h;
                }
                break;
        }
        Result result = new Result();
        result.setA(a);
        result.setB(b);
        result.setAlgo(algo);
        result.setStep(step);
        result.setFinalResult(integr);

        return result;
    }
}
