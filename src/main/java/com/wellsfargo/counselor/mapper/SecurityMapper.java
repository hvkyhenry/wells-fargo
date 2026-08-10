package com.wellsfargo.counselor.mapper;

import com.wellsfargo.counselor.dto.SecurityRequest;
import com.wellsfargo.counselor.dto.SecurityResponse;
import com.wellsfargo.counselor.entity.Security;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SecurityMapper {

    SecurityResponse toResponse(Security security);

    List<SecurityResponse> toResponseList(List<Security> securities);

    @Mapping(target = "securityId", ignore = true)
    Security toEntity(SecurityRequest request);
}