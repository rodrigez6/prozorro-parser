package org.rodrigez.service;

import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Contract;
import org.rodrigez.model.domain.Organization;
import org.rodrigez.model.dto.OrganizationDTO;
import org.rodrigez.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;

    public void persist(Bid bid, OrganizationDTO dto){
        Organization organization = findOrCreate(dto);

        bid.addOrganization(organization);

        organizationRepository.save(organization);
    }

    public void persist(Contract contract, OrganizationDTO dto){
        Organization organization = findOrCreate(dto);

        contract.addSupplier(organization);

        organizationRepository.save(organization);
    }

    Organization findOrCreate(OrganizationDTO dto){
        String id = dto.getIdentifierDTO().getId();
        Optional<Organization> organizationOptional = organizationRepository.findById(id);
        return organizationOptional.orElseGet(() -> new Organization(dto));
    }


}
