package com.zuporangetalents.contabancaria.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuporangetalents.contabancaria.dto.ClienteDTO;
import com.zuporangetalents.contabancaria.entities.Cliente;
import com.zuporangetalents.contabancaria.repositories.ClienteRepository;
import com.zuporangetalents.contabancaria.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<ClienteDTO> findAll() {
		List<Cliente> list = repository.findAll();
		
		return list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClienteDTO findByID(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity  = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setDataDeNascimento(dto.getDataDeNascimento());
		entity = repository.save(entity);
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setCpf(dto.getCpf());
			entity.setDataDeNascimento(dto.getDataDeNascimento());
			entity = repository.save(entity);
			return new ClienteDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
}
