package com.securemetric.infomanager.security;

import com.securemetric.infomanager.entity.Roles;
import com.securemetric.infomanager.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> auth = new HashSet<>();
        List<Roles> rolesList = user.getRolesList();

//        rolesList.forEach(r -> auth.add(new SimpleGrantedAuthority(r.getRoles())));

        for (Roles role : rolesList) {
            String roleString = role.getRoles();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleString);
            auth.add(authority);
        }

        return auth;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName(){
        return user.getFirstName() + " " +  user.getLastName();
    }
}
