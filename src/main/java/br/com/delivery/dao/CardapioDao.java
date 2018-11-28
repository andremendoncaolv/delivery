package br.com.delivery.dao;

import java.util.List;

import br.com.delivery.domain.Cardapio;

public interface CardapioDao {

	void save(Cardapio cardapio);

    void update(Cardapio cardapio);

    void delete(Long id);

    Cardapio findById(Long id);

    List<Cardapio> findAll();
}
