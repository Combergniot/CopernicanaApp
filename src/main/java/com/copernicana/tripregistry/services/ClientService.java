package com.copernicana.tripregistry.services;

import com.copernicana.tripregistry.exceptions.IdException;
import com.copernicana.tripregistry.model.personalData.Client;
import com.copernicana.tripregistry.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

    public Iterable<Client> findByName(String name){
        return clientRepository.findByName(name);
    }

    public void deleteClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElse(null);

        if (client == null) {
            throw new IdException("Cannot delete client with ID " + id + ". This ID does not exist");
        }
        clientRepository.delete(client);

    }
}

