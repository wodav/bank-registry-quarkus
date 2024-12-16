package org.acme.mapper;

import org.acme.Bank;
import org.mapstruct.Mapper;
import org.openapi.quarkus.api_yaml.model.BankDTO;

@Mapper(componentModel = "CDI")//TODO read!
public interface BankMapper {

   // @Mapping(target = "surname", source = "lastname")
    BankDTO toResource(Bank bank);
}
