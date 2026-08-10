package com.wellsfargo.counselor.mapper;

import com.wellsfargo.counselor.dto.PortfolioSecurityRequest;
import com.wellsfargo.counselor.dto.PortfolioSecurityResponse;
import com.wellsfargo.counselor.entity.PortfolioSecurity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PortfolioSecurityMapper {

    @Mapping(source = "portfolio.portfolioId", target = "portfolioId")
    @Mapping(source = "security.securityId", target = "securityId")
    @Mapping(source = "security.securityName", target = "securityName")
    @Mapping(source = "security.tickerSymbol", target = "tickerSymbol")
    PortfolioSecurityResponse toResponse(PortfolioSecurity portfolioSecurity);

    List<PortfolioSecurityResponse> toResponseList(List<PortfolioSecurity> holdings);

    @Mapping(target = "porSecId", ignore = true)
    @Mapping(target = "portfolio", ignore = true)
    @Mapping(target = "security", ignore = true)
    PortfolioSecurity toEntity(PortfolioSecurityRequest request);
}