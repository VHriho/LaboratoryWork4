package org.example.utilites;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@UtilityClass
public class ExeptionInput {

    public static void checkExeption(double a, double b, double step){
        if(a >= b){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "[A] parameter cannot be more or equal [B]");
        }
        if(step != (b-a)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "[Step] parameter is incorrect");
        }
    }
}
