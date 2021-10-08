package com.securemetric.infomanager.message;

import com.securemetric.infomanager.entity.Organization;

import java.util.ArrayList;
import java.util.List;

public class MessageOrganization {

    private String message = "";
    private List<Organization> organizations = new ArrayList<Organization>();
    private String error = "";

    public MessageOrganization(String message, List<Organization> organizations, String error) {
        this.message = message;
        this.organizations = organizations;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
