package br.com.nunes.sports.products.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaIncial {
    
       @GetMapping("/paginaInicial")
    public ModelAndView acessarPagina(){
        ModelAndView mv = new ModelAndView("paginaInicial");
        return mv;

    }
     @PostMapping("/paginaInicial")
     public String mostrarPagina(){
        return "paginaInicial";

     }
}
