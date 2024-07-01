package com.deyvid.sistema_alarme.controllers;

import com.deyvid.sistema_alarme.models.Agendamento;
import com.deyvid.sistema_alarme.models.Historico;
import com.deyvid.sistema_alarme.models.Usuario;
import com.deyvid.sistema_alarme.repositories.AgendamentoRepository;
import com.deyvid.sistema_alarme.repositories.HistoricoRepository;
import com.deyvid.sistema_alarme.repositories.UsuarioRepository;
import com.deyvid.sistema_alarme.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        List<Usuario> usuarios = (List<Usuario>)usuarioRepository.findAll();
        Historico ultimoHistorico = this.historicoRepository.ultimoHistorico();
        List<Agendamento> agendamentos = this.agendamentoRepository.agendamentosDecrecente();

        if (ultimoHistorico != null) {
            model.addAttribute("ultimoHistorico", ultimoHistorico);
        } else {
            ultimoHistorico = new Historico();
            ultimoHistorico.setStatus(' ');
            ultimoHistorico.setAcionador("");
            ultimoHistorico.setDataHora(LocalDateTime.MIN);
        }

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("nome", CookieService.getCookie(request, "nomeUsuario"));
        model.addAttribute("agendamentos", agendamentos);
        return "index";
    }
}
