package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.getAll();
	}

	public Optional<Client> getClient(int id) {
		return clientRepository.getClient(id);
	}

	public Client save(Client client) {
		if (client.getIdClient() == null) {
			return clientRepository.save(client);
		} else {
			Optional<Client> clientAux = clientRepository.getClient(client.getIdClient());
			if (clientAux.isEmpty()) {
				return clientRepository.save(client);
			} else {
				return client;
			}
		}
	}
}
