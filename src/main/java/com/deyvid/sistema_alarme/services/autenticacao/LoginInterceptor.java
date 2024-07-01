package com.deyvid.sistema_alarme.services.autenticacao;

import com.deyvid.sistema_alarme.services.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (CookieService.getCookie(request, "usuariosId") != null) {
            return true; // Permite o acesso se o cookie 'usuariosId' estiver presente
        }

        response.sendRedirect("/login"); // Redireciona para a página de login se o cookie não estiver presente
        return false;
    }
}