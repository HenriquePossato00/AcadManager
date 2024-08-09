package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.DAO.UsuarioDAO;
import com.app.model.Usuario;

@Controller
public class MyController {
    private final UsuarioDAO userDAO = new UsuarioDAO();

    @GetMapping("/AcadManager")
    public String hello() {
        return "index";
    }

    @PostMapping("/buttonAction")
    public String buttonAction(@RequestParam(name = "param", required = false, defaultValue = "default") String param) {
        // TODO: process POST request

        return "result";
    }

    @PostMapping("/login")
    public String login(@RequestParam("nome") String nome,
            @RequestParam("senha") String senha,
            Model model) {

        Usuario usuario = userDAO.lerUsuario(nome, senha);
        
        if (usuario != null) {
            return "result";
        } else {
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "login";
        }
    }

}
