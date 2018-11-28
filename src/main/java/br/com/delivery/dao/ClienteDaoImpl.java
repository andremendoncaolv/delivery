package br.com.delivery.dao;

import org.springframework.stereotype.Repository;

import br.com.delivery.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {

}
