package br.com.nunes.sports.products.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.nunes.sports.products.Entity.Produto;
import br.com.nunes.sports.products.Repository.ProdutcRepository;
import br.com.nunes.sports.products.Service.ProdutoService;
import jakarta.transaction.Transactional;

@Controller
//@RequestMapping("/produtos")
public class ProductController {
    
    @Autowired
    private final ProdutoService produtoService;

    @Autowired
    private  ProdutcRepository produtoRepository;

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
        return "redirect:/listaProdutos";
    }

    @GetMapping("/listaProdutos")
    public ModelAndView  listarProdutos(Produto produto) {
        ModelAndView mv = new ModelAndView("listaProdutos");
        Iterable<Produto> produtos = this.produtoService.obterTodosOsProdutos();
        mv.addObject("produtos", produtos);
        return mv;
    }
 
  
    @Transactional
    @GetMapping("/excluirProduto/{codigo}")
    public String excluirProduto(@PathVariable ("codigo")Long codigo) {
        produtoRepository.deleteByCodigo(codigo);
        return "redirect:/listaProdutos";
    }

    @GetMapping("/editarProduto/{codigo}")
    public ModelAndView editarProduto(@PathVariable("codigo")Long codigo){
        ModelAndView mv = new ModelAndView("cadastrarProduto");
        Produto produto = this.produtoRepository.findById(codigo).get();
        return mv;

    }
}

