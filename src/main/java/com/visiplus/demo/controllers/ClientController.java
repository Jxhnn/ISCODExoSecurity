package com.visiplus.demo.controllers;

import com.visiplus.demo.models.Client;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final List<Client> clients = new ArrayList<>();

    @GetMapping
    public List<Client> getAllClients() {
        return clients;
    }

    @PostMapping
    public String addClient(@RequestBody Client client) {
        clients.add(client);
        return "Client added successfully!";
    }

    @DeleteMapping
    public String deleteClient(@RequestParam String firstName, @RequestParam String lastName) {
        int beforeCount = clients.size();
        clients.removeIf(client -> client.getFirstName().equals(firstName) && client.getLastName().equals(lastName));
        if (clients.size() != beforeCount) {
            return "Client deleted successfully!";
        } else {
            return "Client not found.";
        }
    }
}
