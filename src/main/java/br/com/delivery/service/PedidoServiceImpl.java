package br.com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.delivery.dao.PedidoDao;
import br.com.delivery.domain.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	private PedidoDao dao;
	
	@Transactional(readOnly = false)	
	@Override
	public void salvar(Pedido pedido) {
		dao.save(pedido);
	}

	@Transactional(readOnly = false)	
	@Override
	public void editar(Pedido pedido) {
		dao.update(pedido);
	}

	@Transactional(readOnly = false)	
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = false)	
	@Override
	public Pedido buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = false)	
	@Override
	public List<Pedido> buscarTodos() {
		return dao.findAll();
	}
}
