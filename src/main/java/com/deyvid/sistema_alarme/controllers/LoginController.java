package com.deyvid.sistema_alarme.controllers;

import com.deyvid.sistema_alarme.models.Usuario;
import com.deyvid.sistema_alarme.repositories.UsuarioRepository;
import com.deyvid.sistema_alarme.services.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/logar")
    public String logar(Model model, Usuario usuarioParam, String lembrar, HttpServletResponse response) throws IOException {
        Usuario usuario = this.usuarioRepository.login(usuarioParam.getEmail(), usuarioParam.getSenha());

        if (usuario != null) {
            int tempoLogado = (60 * 60); // 1 hora de cookie
            if (lembrar != null) tempoLogado = (60 * 60 * 24 * 365); // 1 ano de cookie

            CookieService.setCookie(response, "usuariosId", String.valueOf(usuario.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", usuario.getNome(), tempoLogado);

            return "redirect:/"; // Redireciona para a página principal
        }

        model.addAttribute("erro", "Email ou senha inválido(s).");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) throws IOException {
        CookieService.setCookie(response, "usuariosId", "", 0);
        return "redirect:/login";
    }
}
