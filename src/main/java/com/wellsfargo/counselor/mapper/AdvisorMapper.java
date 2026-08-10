package com.wellsfargo.counselor.mapper;

import com.wellsfargo.counselor.dto.AdvisorRequest;
import com.wellsfargo.counselor.dto.AdvisorResponse;
import com.wellsfargo.counselor.entity.Advisor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvisorMapper {

    AdvisorResponse toResponse(Advisor advisor);

    List<AdvisorResponse> toResponseList(List<Advisor> advisors);

    @Mapping(target = "advisorId", ignore = true)
    @Mapping(target = "clients", ignore = true)
    Advisor toEntity(AdvisorRequest request);
}