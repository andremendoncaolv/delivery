package br.com.delivery.dao;

import java.util.List;

import br.com.delivery.domain.Pedido;

public interface PedidoDao {

	void save(Pedido pedido);

    void update(Pedido pedido);

    void delete(Long id);

    Pedido findById(Long id);

    List<Pedido> findAll();
}
