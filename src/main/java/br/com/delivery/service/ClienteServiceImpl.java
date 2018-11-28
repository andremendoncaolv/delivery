package br.com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.delivery.dao.ClienteDao;
import br.com.delivery.domain.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDao dao;
	
	@Transactional(readOnly = false)	
	@Override
	public void salvar(Cliente cliente) {
		dao.save(cliente);
	}

	@Transactional(readOnly = false)	
	@Override
	public void editar(Cliente cliente) {
		dao.update(cliente);
	}

	@Transactional(readOnly = false)	
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = false)	
	@Override
	public Cliente buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = false)	
	@Override
	public List<Cliente> buscarTodos() {
		return dao.findAll();
	}

}
