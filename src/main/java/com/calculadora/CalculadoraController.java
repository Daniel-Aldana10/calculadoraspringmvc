package com.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller

public class CalculadoraController {

    @GetMapping("/")
    public String mostrarCalculadora(Model model) {
        if (!model.containsAttribute("display")) {
            model.addAttribute("display", "0");
        }
        return "calculadora";
    }

    @PostMapping("/operar")
    public String operar(@RequestParam String operacion,
                         @RequestParam(required = false) String valor,
                         Model model) {
        String resultadoStr = "0";

        try {
            if (valor != null && valor.contains(",")) {
                String[] valores = valor.split(",");
                double num1 = Double.parseDouble(valores[0]);
                double num2 = Double.parseDouble(valores[1]);
                double resultado;

                switch (operacion) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        resultado = (num2 != 0) ? num1 / num2 : 0;
                        break;
                    default:
                        resultado = 0;
                }

                resultadoStr = String.valueOf(resultado);
            }
        } catch (Exception e) {
            resultadoStr = "Error";
        }

        model.addAttribute("display", resultadoStr);
        return "calculadora";
    }


    @PostMapping("/ac")
    public String allClear(SessionStatus status, Model model) {
        status.setComplete();
        model.addAttribute("display", "0");
        return "calculadora";
    }
} 