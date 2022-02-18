package com.example.exc02.dao;

import com.example.exc02.entidades.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoDao extends JpaRepository<ItemPedido, Long> {

}
