package br.com.delivery.dao;

import org.springframework.stereotype.Repository;

import br.com.delivery.domain.Pedido;

@Repository
public class PedidoDaoImpl extends AbstractDao<Pedido, Long> implements PedidoDao{

}
