package com.system.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;

@Entity(name = "Role")
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    private String nameRole;

    @ManyToMany
    private List<User> users;

    @Override
    public String getAuthority() {
        return this.nameRole;
    }
}
