package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    // Custom query method to find clients by advisor entity
    List<Client> findByAdvisor(Advisor advisor); 
}