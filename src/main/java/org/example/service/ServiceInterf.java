package org.example.service;

import org.example.dto.Input;
import org.example.dto.Output;

public interface ServiceInterf {
    Double intagrate(Input input);
    Output getIntegrationResult(Integer id);
}
