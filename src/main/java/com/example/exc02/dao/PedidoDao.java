package com.example.exc02.dao;

import com.example.exc02.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Long> {
}
