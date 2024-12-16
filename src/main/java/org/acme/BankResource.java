package org.acme;

import io.quarkiverse.openapi.generator.annotations.GeneratedMethod;
import io.quarkiverse.openapi.generator.markers.OperationMarker;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.service.BankService;
import org.openapi.quarkus.api_yaml.api.BankApi;
import org.openapi.quarkus.api_yaml.model.BankDTO;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Path("/banks")
public class BankResource implements BankApi {

    @Inject
    BankService bankService;

    private Set<Bank> banks = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));


    @GET
    public Response list(){
        return Response.ok(banks).build();
    }

    @Override
    public List<BankDTO> banksGet() {

        return bankService.getAll();

    }

    @Override
    public BankDTO createBank(BankDTO bankDTO){
        bankDTO = bankService.createBank(bankDTO);
        return bankDTO;
    }



    @DELETE
    public Bank delete(Bank bank){
        banks.removeIf(existingBank ->
                existingBank.getName().equals(bank.getName())
        );
        return bank;
    }

}
