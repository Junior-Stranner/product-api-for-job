package br.com.nunes.sports.products.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutcRepository;
import br.com.nunes.sports.products.Service.ProdutoService;

@Controller
//@RequestMapping("/produtos")
public class ProductController {
    
    @Autowired
    private final ProdutoService produtoService;

    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/cadastrarProduto")
    public String cadastro(){
        return "cadastrarProduto";
    }

    @PostMapping("/salvarProduto")
    public String salvarProduto(Produto produto) {
        this.produtoService.salvarProduto(produto);
        return "redirect:/listarProdutos";
    }

    @GetMapping("/listarProdutos")
    public String listarProdutos(Produto produto) {
        Iterable<Produto> produtos = this.produtoService.obterTodosOsProdutos();

        return "listaProdutos";
    }

  

}
