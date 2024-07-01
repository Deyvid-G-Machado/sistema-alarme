package com.deyvid.sistema_alarme.controllers;

import com.deyvid.sistema_alarme.models.Historico;
import com.deyvid.sistema_alarme.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HistoricoController {
    @Autowired
    HistoricoRepository historicoRepository;

    @GetMapping("/historico")
    public String historico(Model model){
        List<Historico> historicoT = historicoRepository.historicosDecrecente();

        model.addAttribute("historicoT", historicoT);
        return "historico";
    }
}

/*
        List<Usuario> usuarios = (List<Usuario>)usuarioRepository.findAll();
        Historico ultimoHistorico = this.historicoRepository.ultimoHistorico();
 */