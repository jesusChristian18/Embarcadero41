package pe.upn.embarcadero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upn.embarcadero.model.entity.Cliente;
import pe.upn.embarcadero.model.repository.ClienteRepository;
import pe.upn.embarcadero.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	
	@Autowired
	private ClienteRepository clienteRepository;

	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Transactional
	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Transactional
	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
	}
	
	
}
