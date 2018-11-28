package br.com.delivery.service;

import java.util.List;

import br.com.delivery.domain.Cardapio;

public interface CardapioService {

	void salvar(Cardapio cardapio);

    void editar(Cardapio cardapio);

    void excluir(Long id);

    Cardapio buscarPorId(Long id);
    
    List<Cardapio> buscarTodos();

	//boolean departamentoTemCargos(Long id);
}
