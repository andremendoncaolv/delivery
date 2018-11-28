package br.com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.delivery.dao.CardapioDao;
import br.com.delivery.domain.Cardapio;

@Service
public class CardapioServiceImpl implements CardapioService {
	
	@Autowired
	private CardapioDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Cardapio cardapio) {
		dao.save(cardapio);
	}

	@Transactional(readOnly = false)	
	@Override
	public void editar(Cardapio cardapio) {
		dao.update(cardapio);
	}

	@Transactional(readOnly = false)	
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = false)	
	@Override
	public Cardapio buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = false)	
	@Override
	public List<Cardapio> buscarTodos() {
		return dao.findAll();
	}

}
