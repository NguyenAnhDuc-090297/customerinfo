package com.securemetric.infomanager.service;

import com.securemetric.infomanager.entity.Organization;
import com.securemetric.infomanager.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAllOrganization(){
        List<Organization> organizationList = organizationRepository.findAll();
        return organizationList;
    }

    public void addOrganization(Organization organization) {
        organizationRepository.save(organization);
    }

    public void updateOrganization(Organization organization) {
        organizationRepository.save(organization);
    }

    public Organization findOrganizationById(int id) {
        Optional<Organization> organization = organizationRepository.findById(id);
        if (organization != null) {
            return organization.get();
        }
        else {
            return null;
        }
    }
}
