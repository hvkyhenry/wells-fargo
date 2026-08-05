package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;
import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.stereotype.Service;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;

import org.springframework.transaction.annotation.Transactional;

//import com.wellsfargo.counselor.exception.ResourceNotFoundException;
//import com.wellsfargo.counselor.exception.UnauthorizedAccessException;
import java.util.List;
@Service
public class ClientService {
    
    
    private final ClientRepository clientRepository;
    private final AdvisorRepository advisorRepository;   
    private final PortfolioRepository portfolioRepository;

    //Constructor
    public ClientService(ClientRepository clientRepository, AdvisorRepository advisorRepository, PortfolioRepository portfolioRepository) {
        this.clientRepository = clientRepository;
        this.advisorRepository = advisorRepository;
        this.portfolioRepository = portfolioRepository;
    }

    //Create a Client
    @Transactional
    public Client createClient(Client client, Long advisorId){
    
        Advisor advisor = advisorRepository.findById(advisorId)
                .orElseThrow(() -> new RuntimeException("Advisor not found with id: " + advisorId));

        client.setAdvisor(advisor);

        Client savedClient = clientRepository.save(client);

        // Initialize a new portfolio for the client
        Portfolio portfolio = new Portfolio();
        portfolio.setClient(savedClient);
        portfolio.setPortfolioName("Default Portfolio");
        portfolioRepository.save(portfolio);

        return savedClient;


    }

    //Read clients by advisor
    @Transactional(readOnly = true)
    public List<Client> getClientsByAdvisor(long advisorId){
        Advisor advisor = advisorRepository.findById(advisorId)
                .orElseThrow(() -> new RuntimeException("Advisor not found with id: " + advisorId));

        return clientRepository.findByAdvisor(advisor);
    }

    // Update client
    @Transactional
    public Client updateClient(long advisorId, long clientId, Client updatedData){
        //Fetch existing client
        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));

        //Verify advisor ownership
        if(existingClient.getAdvisor().getAdvisorId() != advisorId){
            throw new RuntimeException("Unauthorized access: Client does not belong to the specified advisor");
        }

        //Update client details
        existingClient.setFirstName(updatedData.getFirstName());
        existingClient.setLastName(updatedData.getLastName());
        existingClient.setAddress(updatedData.getAddress());
        existingClient.setPhoneNumber(updatedData.getPhoneNumber());

        //Save updated client
        return clientRepository.save(existingClient);
    }

    //Delete client
    @Transactional
    public void deleteClient(Long advisorId, Long clientId){

        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));

        //Verify advisor ownership
        if(existingClient.getAdvisor().getAdvisorId() != advisorId){
            throw new RuntimeException("Unauthorized access: Client does not belong to the specified advisor");
        }

        //Prevent deletion if client has active portfolios with active holdings
        boolean hasActivePortfolios = existingClient.getPortfolios().stream()
                .anyMatch(portfolio -> !portfolio.getPortfolioSecurities().isEmpty());

        if(hasActivePortfolios){
            throw new RuntimeException("Cannot delete client with active portfolios or holdings");
        }

        clientRepository.delete(existingClient);
    }

    
    
}
