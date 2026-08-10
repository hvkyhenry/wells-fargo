package com.wellsfargo.counselor.mapper;

import com.wellsfargo.counselor.dto.PortfolioRequest;
import com.wellsfargo.counselor.dto.PortfolioResponse;
import com.wellsfargo.counselor.entity.Portfolio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {

    // Automatically extracts client.clientId into the flat clientId field
    @Mapping(source = "client.clientId", target = "clientId")
    PortfolioResponse toResponse(Portfolio portfolio);

    List<PortfolioResponse> toResponseList(List<Portfolio> portfolios);

    @Mapping(target = "portfolioId", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "portfolioSecurities", ignore = true)
    Portfolio toEntity(PortfolioRequest request);
}