package com.GerenciamentodeProdutos.ex2.repository;

import com.GerenciamentodeProdutos.ex2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {
}
