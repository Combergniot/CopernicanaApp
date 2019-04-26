package com.copernicana.tripregistry.controller;

import com.copernicana.tripregistry.model.personalData.Client;
import com.copernicana.tripregistry.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/klienci")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public Iterable<Client> getAll() {
        Iterable<Client> clients = clientService.getAll();
        return clients;
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        Optional<Client> clientOptional =
                clientService.findById(id);
        return clientOptional;
    }

    @GetMapping("/name={name}")
    public Iterable<Client> getClientByName(@PathVariable String name) {
        Iterable<Client> clients = clientService.findByName(name);
        return clients;
    }


}
