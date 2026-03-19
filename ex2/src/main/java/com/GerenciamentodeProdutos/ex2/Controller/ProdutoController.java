package com.GerenciamentodeProdutos.ex2.Controller;


import com.GerenciamentodeProdutos.ex2.Service.ProdutoService;
import com.GerenciamentodeProdutos.ex2.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<Produto>>findAll(){
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> criarObjeto(@RequestBody Produto produto){
        Produto criarProduto = produtoService.criarProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(criarProduto);
    }

    @GetMapping("/{id}")
    public Optional<Produto>buscarProduto(@PathVariable Long id){
        return produtoService.buscarProduto(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletar (@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
