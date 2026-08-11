package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/advisors/{advisorId}/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // CREATE: Add a new client for a specific advisor
    @PostMapping
    public ResponseEntity<Client> createClient(@PathVariable Long advisorId, 
                                              @RequestBody Client client) {
        Client created = clientService.createClient(client, advisorId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ: Fetch all clients assigned to an advisor
    @GetMapping
    public ResponseEntity<List<Client>> getClientsByAdvisor(@PathVariable Long advisorId) {
        return ResponseEntity.ok(clientService.getClientsByAdvisor(advisorId));
    }

    // UPDATE: Update client details with ownership validation
    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long advisorId,
                                                @PathVariable Long clientId,
                                                @RequestBody Client updatedData) {
        Client updated = clientService.updateClient(advisorId, clientId, updatedData);
        return ResponseEntity.ok(updated);
    }

    // DELETE: Delete a client
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long advisorId, 
                                             @PathVariable Long clientId) {
        clientService.deleteClient(advisorId, clientId);
        return ResponseEntity.noContent().build();
    }
}