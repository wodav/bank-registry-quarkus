package org.acme.mapper;


import org.acme.entity.Bank;
import org.mapstruct.Mapper;
import org.openapi.quarkus.api_yaml.model.BankDTO;

import java.util.List;

@Mapper(componentModel = "CDI")//TODO read!
public interface BankMapper {

   // @Mapping(target = "surname", source = "lastname")
    BankDTO toResource(Bank bank);
    Bank toDTO(BankDTO bankDTO);
    List<BankDTO> toDtoList(List<Bank> banks);
}
