package com.securemetric.infomanager.controller;

import com.securemetric.infomanager.entity.Organization;
import com.securemetric.infomanager.message.MessageOrganization;
import com.securemetric.infomanager.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("")
    public String getOrganization(Model model){
        List<Organization> organizationList = organizationService.getAllOrganization();
        model.addAttribute("organizations", organizationList);
        return "organization";
    }

    @PostMapping("/add-organization")
    public ResponseEntity<MessageOrganization> addOrganization(@RequestParam("name") String name,
                                                               @RequestParam("fullName") String fullName){

        try {
            Organization newOrganization = new Organization();
            newOrganization.setName(name);
            newOrganization.setFullName(fullName);
            organizationService.addOrganization(newOrganization);
            return new ResponseEntity<>(new MessageOrganization("Add organization successful",
                    Arrays.asList(newOrganization), ""), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new MessageOrganization("",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-organization")
    public ResponseEntity<MessageOrganization> editOrganization(@RequestParam("id") int id,
                                                                @RequestParam("shortName") String shortName,
                                                                @RequestParam("fullName") String fullName){

        try {
            // Check organization exist or not
            Organization organizationFound = organizationService.findOrganizationById(id);
            if(organizationFound != null) {
                organizationFound.setName(shortName);
                organizationFound.setFullName(fullName);

                // Save change
                organizationService.updateOrganization(organizationFound);

                return new ResponseEntity<>(new MessageOrganization("update successful",
                        Arrays.asList(organizationFound), ""), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MessageOrganization("",
                        null, ""), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageOrganization("Failure",
                    null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
