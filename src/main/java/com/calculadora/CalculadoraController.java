package com.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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
            if ("=".equals(operacion) && valor != null && !valor.trim().isEmpty()) {
                // Evaluar expresión básica usando exp4j
                String expresion = valor.trim();
                Expression e = new ExpressionBuilder(expresion)
                    .build();
                
                double resultado = e.evaluate();
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