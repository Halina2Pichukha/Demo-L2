package com.example.calculator;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody Map<String, Object> payload) {
        String operation = (String) payload.get("operation");
        double a = ((Number) payload.get("a")).doubleValue();
        double b = ((Number) payload.get("b")).doubleValue();
        double result;
        switch (operation) {
            case "add": result = a + b; break;
            case "subtract": result = a - b; break;
            case "multiply": result = a * b; break;
            case "divide": result = b != 0 ? a / b : Double.NaN; break;
            default: throw new IllegalArgumentException("Invalid operation");
        }
        return Map.of("result", result);
    }
}
