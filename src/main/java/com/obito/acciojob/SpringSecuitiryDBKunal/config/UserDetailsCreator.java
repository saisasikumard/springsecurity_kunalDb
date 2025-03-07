package com.obito.acciojob.SpringSecuitiryDBKunal.config;

import com.obito.acciojob.SpringSecuitiryDBKunal.entity.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsCreator  implements UserDetails {
    String userName;
    String password;
    List<GrantedAuthority> authorities;
    public UserDetailsCreator(Person person) {
        this.userName=person.getUserName();
        this.password= person.getPassword();
        String roles[] =person.getRole().split(",");
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for(String role:roles){
            SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
            grantedAuthorities.add(simpleGrantedAuthority);

        }
        this.authorities=grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
}
