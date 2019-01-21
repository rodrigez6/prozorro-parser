package org.rodrigez.service;

import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Contract;
import org.rodrigez.model.domain.Organization;
import org.rodrigez.model.dto.OrganizationDTO;
import org.rodrigez.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository organizationRepository;

    public void persist(Bid bid, OrganizationDTO dto){
        Organization organization = new Organization(dto);
        bid.addOrganization(organization);
        organizationRepository.save(organization);
    }

    public void persist(Contract contract, OrganizationDTO dto){
        Organization organization = new Organization(dto);
        contract.addSupplier(organization);
        organizationRepository.save(organization);
    }


}
