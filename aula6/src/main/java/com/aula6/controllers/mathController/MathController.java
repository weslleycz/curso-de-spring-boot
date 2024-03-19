package com.aula6.controllers.mathController;

import com.aula6.services.SimpleMathService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Validated
class MathController {
    private final AtomicLong counter = new AtomicLong();
    private final SimpleMathService mathService;

    MathController(SimpleMathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Object sun(
            @PathVariable(value = "numberOne") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberOne,

            @PathVariable(value = "numberTwo") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberTwo
    ) {
        try {
            return this.mathService.sum( Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Erro ao converter números");
        }
    }

    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Object subtraction(
            @PathVariable(value = "numberOne") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberOne,

            @PathVariable(value = "numberTwo") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberTwo
    ) {
        try {
            return this.mathService.subtraction( Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Erro ao converter números");
        }
    }

    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Object multiplication(
            @PathVariable(value = "numberOne") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberOne,

            @PathVariable(value = "numberTwo") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberTwo
    ) {
        try {
            return this.mathService.multiplication( Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Erro ao converter números");
        }
    }

    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Object division(
            @PathVariable(value = "numberOne") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberOne,

            @PathVariable(value = "numberTwo") @NotBlank
            @Pattern(regexp = "^\\d+$", message = "O número deve conter apenas dígitos") String numberTwo
    ) {
        try {
            return this.mathService.division( Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Erro ao converter números");
        }
    }
}





