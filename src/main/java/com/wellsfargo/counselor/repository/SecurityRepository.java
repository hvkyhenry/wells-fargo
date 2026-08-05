package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
    boolean existsByTickerSymbol(String tickerSymbol);
    List<Security> findByCategoryIgnoreCase(String category);
}