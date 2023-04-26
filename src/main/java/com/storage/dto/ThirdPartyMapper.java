package com.storage.dto;

import com.storage.entity.ThirdParty;
import org.mapstruct.*;

import javax.inject.Inject;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "cdi")
public interface ThirdPartyMapper {

    @Mapping(source = "partnerName", target = "thirdPartyName")
    ThirdParty thirdPartyDtoToThirdParty(ThirdPartyDto thirdPartyDto);


    @InheritInverseConfiguration(name = "thirdPartyDtoToThirdParty")
    ThirdPartyDto thirdPartyToThirdPartyDto(ThirdParty thirdParty);

    @InheritConfiguration
    ThirdParty updateThirdPartyFromThirdPartyDto(ThirdPartyDto thirdPartyDto, @MappingTarget ThirdParty thirdParty);

    List<ThirdPartyDto> thirdPartyListToThirdPartyDtoList(List<ThirdParty> thirdParty);
}
