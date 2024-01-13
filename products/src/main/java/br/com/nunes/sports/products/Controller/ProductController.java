package br.com.nunes.sports.products.Controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutoRepository;
import br.com.nunes.sports.products.Service.ProdutoService;
import jakarta.transaction.Transactional;

@Controller
//@RequestMapping("/produtos")
public class ProductController {
    

    @Autowired
    private  ProdutoRepository produtoRepository;

    @Autowired
    private final ProdutoService produtoService;

    List<Produto> produtos = new ArrayList<>();
   
    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    
    @GetMapping("/cadastrarProduto")
    public String cadastro(){
        return "cadastrarProduto";
    }

    @PostMapping("/salvarProduto")
    public String salvarProduto(Produto produto) {
        this.produtoService.saveProduto(produto);
        return "redirect:/listaProdutos";
    }

    @GetMapping("/listaProdutos")
    public ModelAndView  listarProdutos(Produto produto) {
        ModelAndView mv = new ModelAndView("listaProdutos");
        Iterable<Produto> produtos = this.produtoService.getAllProduto();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/editarProduto/{codigo}")
    public ModelAndView editarPerfil(@PathVariable("codigo") Long codigo,Produto produto) {
        ModelAndView mv = new ModelAndView("cadastrarProduto");
     mv.addObject("produto", produto);
      this.produtoService.updateProduto(produto);
        return mv;
    }

      
    @Transactional
    @GetMapping("/excluirProduto/{codigo}")
    public String excluirProduto(@PathVariable ("codigo")Long codigo) {
        produtoRepository.deleteByCodigo(codigo);
        return "redirect:/listaProdutos";
    }

}
 
