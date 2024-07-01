package com.deyvid.sistema_alarme.controllers;

import com.deyvid.sistema_alarme.models.Usuario;
import com.deyvid.sistema_alarme.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario/cadastrar")
    public String novo(){
        return "usuarios";
    }

    @PostMapping("/usuario/criar")
    public String criar(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/usuario/{id}")
    public String busca(@PathVariable Integer id , Model model){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            model.addAttribute("usuario", usuarioOptional.get());
            return "alterar-usuarios";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/usuario/{id}/atualizar")
    public String atualizar(@PathVariable Integer id, Usuario usuario){
        if (!usuarioRepository.existsById(id)){
            return "redirect:/";
        }
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/usuario/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        usuarioRepository.deleteById(id);
        return "redirect:/";
    }
}
