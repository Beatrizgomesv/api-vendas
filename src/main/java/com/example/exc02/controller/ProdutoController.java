package com.example.exc02.controller;


import com.example.exc02.dao.ProdutoDao;
import com.example.exc02.entidades.Produto;
import com.example.exc02.utils.RequestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    ProdutoDao produtoDao;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoDao.findAll();
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoDao.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(
            @PathVariable Long id,
            @RequestBody Produto produto
    ) {
        Optional<Produto> produtoAtual = produtoDao.findById(id);
        if (produtoAtual.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Produto produtoAtualizado = produtoAtual.get();
        BeanUtils.copyProperties(produto, produtoAtualizado, RequestUtils.getNullPropertyNames(produto));
        produtoDao.save(produtoAtualizado);
        return ResponseEntity.of(Optional.of(produtoAtualizado));
    }
}
