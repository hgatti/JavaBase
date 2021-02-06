package com.base.JavaBase.controller;

import com.base.JavaBase.entity.Paciente;
import com.base.JavaBase.repository.PacienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String tela() {
        return "teste";
    }

    @RequestMapping(value = "/historico", method = RequestMethod.GET)
    public String historico(@RequestParam("suscode") String susCode, Model model) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(Long.valueOf(susCode));

        if (pacienteOptional.isPresent()) {
            model.addAttribute("paciente",pacienteOptional.get());
        }
        return "paciente";
    }
}
