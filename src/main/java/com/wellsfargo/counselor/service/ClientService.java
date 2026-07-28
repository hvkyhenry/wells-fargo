package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;
import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;

import jakarta.transaction.Transactional;

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
    //public Client createClient(Client client, Long advisorId){
        // 
    //}
    
    
}
