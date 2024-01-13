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

    /*Irei deixar essa lógica , pois quando vou editar , os dados que eu cadastrei 
    ficará assim consigo alterar só um campo ao invês de empreencher tudo novamente */
    @GetMapping("/editarProduto/{codigo}")
    public ModelAndView editarPerfil(@PathVariable("codigo") Long codigo) {
        ModelAndView mv = new ModelAndView("cadastrarProduto");
       Optional<Produto> optionalProduto = produtoRepository.findByCodigo(codigo);
    
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            mv.addObject("produto", produto);
        } else {
           
            return new ModelAndView("redirect:/listaProdutos");
        }
    
        return mv;
    }
    


/* 	@PostMapping("/editarProduto/{codigo}")
	public String updateStudent(@PathVariable("codigo") @ModelAttribute  Produto produto) {
        produto.setCodigo(produto.getCodigo()); 
		// salva o Produto existente
		produtoService.updateProduto(produto);
		return "redirect:/listaProdutos";		
	}*/

      
    @Transactional
    @GetMapping("/excluirProduto/{codigo}")
    public String excluirProduto(@PathVariable ("codigo")Long codigo) {
        produtoRepository.deleteByCodigo(codigo);
        return "redirect:/listaProdutos";
    }

}
 
