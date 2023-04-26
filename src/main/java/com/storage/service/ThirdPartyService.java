package com.storage.service;

import com.storage.entity.Product;
import com.storage.entity.ThirdParty;
import com.storage.repository.ProductRepository;
import com.storage.repository.ThirdPartyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ThirdPartyService {

    @Inject
    ThirdPartyRepository thirdPartyRepository;

    public List<ThirdParty> getAllThirdParty() {
        return thirdPartyRepository.findAll();
    }
}
