package com.wellsfargo.counselor.mapper;

import com.wellsfargo.counselor.dto.AdvisorRequest;
import com.wellsfargo.counselor.dto.AdvisorResponse;
import com.wellsfargo.counselor.entity.Advisor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // generate a AdvisorMapperImpl class taht implements this interface
public interface AdvisorMapper {

    AdvisorResponse toResponse(Advisor advisor);

    List<AdvisorResponse> toResponseList(List<Advisor> advisors);

    @Mapping(target = "advisorId", ignore = true)
    @Mapping(target = "clients", ignore = true) //new advisor does not have any cient. Prevents mapstruct frrom trying to map the clients field from the request to the entity
    Advisor toEntity(AdvisorRequest request);
}