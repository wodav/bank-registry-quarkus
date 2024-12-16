package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.Bank;
import org.acme.mapper.BankMapperImpl;
import org.openapi.quarkus.api_yaml.model.BankDTO;

import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class BankService {

    @Inject
    BankMapperImpl bankMapper;

    @Transactional
    public BankDTO createBank(BankDTO bankDto){

        Bank bank = new Bank();

        bank.setName(bankDto.getName());
        bank.setCountrycode(bankDto.getCountrycode());
        bank.setCheckdigits(Math.toIntExact(bankDto.getCheckdigits()));
        bank.setBankcode(Math.toIntExact(bankDto.getBankcode()));

        bank.persist();

        return bankDto;
    }

    @Transactional
    public List<BankDTO> getAll() {
        List<BankDTO> bankDTOList = new ArrayList<>();
        List<Bank> banks= Bank.listAll();
        banks.forEach(bank ->
            bankDTOList.add(bankMapper.toResource(bank))
                );

        return bankDTOList;
    }
}
