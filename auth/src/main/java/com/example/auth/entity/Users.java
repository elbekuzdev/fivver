package com.example.auth.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstname;
    private String lastname;
    private String profession;
    private String summary;
    private String password;
    @ManyToOne
    private Region region;
    @ManyToOne
    private District district;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
    private Set<Links> links;
    private Boolean isactive = true;
    private CommonsMultipartFile profilePicture;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Permissions> permissions;

    Users(Set<Permissions> permissions){
        this.permissions = permissions;
    }

    public Users(Integer id, String firstname, String lastname, String profession, String summary, String password, Region region, District district, String phoneNumber, String email, Set<Links> links, Boolean isactive, CommonsMultipartFile profilePicture) {
        Id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profession = profession;
        this.summary = summary;
        this.password = password;
        this.region = region;
        this.district = district;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.links = links;
        this.isactive = isactive;
        this.profilePicture = profilePicture;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = permissions.stream().map(p -> new SimpleGrantedAuthority(p.getPermissionName()))
                .collect(Collectors.toSet());
        System.out.println(authorities);
        return authorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
