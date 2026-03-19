package com.GerenciamentodeProdutos.ex2.Service;


import com.GerenciamentodeProdutos.ex2.model.Produto;
import com.GerenciamentodeProdutos.ex2.repository.RepositorioProduto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private RepositorioProduto repositorioProduto;

    public Produto criarProduto(Produto produto){
      return repositorioProduto.save(produto);
    }

    public List<Produto>listarTodos(){
        return repositorioProduto.findAll();
    }

    public Optional<Produto>buscarProduto(Long id){
        return repositorioProduto.findById(id);
    }

    public void deletar(Long id){
        repositorioProduto.deleteById(id);
    }
}
