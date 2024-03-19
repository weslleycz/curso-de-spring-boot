package com.aula6;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
class MathController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Object sun(
            @PathVariable(value = "numberOne") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberOne,

            @PathVariable(value = "numberTwo") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberTwo
    ) {
        try {
            Double result = Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
            return ResponseEntity.ok(result).getBody();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Erro ao converter números");
        }
    }
}
