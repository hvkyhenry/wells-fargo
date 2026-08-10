package com.wellsfargo.counselor.mapper;

import com.wellsfargo.counselor.dto.ClientRequest;
import com.wellsfargo.counselor.dto.ClientResponse;
import com.wellsfargo.counselor.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // MapStruct automatically extracts advisor.advisorId into the flat advisorId field in ClientResponse
    @Mapping(source = "advisor.advisorId", target = "advisorId")
    ClientResponse toResponse(Client client);

    List<ClientResponse> toResponseList(List<Client> clients);

    // Ignore ID and Advisor entity during initial mapping from Request DTO
    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "advisor", ignore = true)
    @Mapping(target = "portfolios", ignore = true)
    Client toEntity(ClientRequest request);
}