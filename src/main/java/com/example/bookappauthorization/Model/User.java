package com.example.bookappauthorization.Model;

import com.example.bookappauthorization.Types.Implementation.NameImpl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_data")
public class User implements UserDetails{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
/** <P>Name Column
 * <P><code>@Type(type = "com.example.bookappauthorization.Types.NameTypeDescriptor")</code>
 *
 * <P>names:
 * <UL>
 * <LI> full_name
 * <LI> first_name
 * <LI> middle_name
 * <LI> last_name
 * <LI> short_name
 * </UL>
 */
    @Columns(columns = {
            @Column(name = "full_name"),
            @Column(name = "first_name"),
            @Column(name = "middle_name"),
            @Column(name = "last_name"),
            @Column(name = "short_name")
    })
    @Type(type = "com.example.bookappauthorization.Types.NameTypeDescriptor")
    private NameImpl name;

    @Column(name = "user_email")
    private String email;

    @OneToOne(mappedBy = "user", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Address address;

    @Column(name = "CREATED_AT", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Size(min=2, message = "Не меньше 5 знаков")
    private String username;

    @Size(min=2, message = "Не меньше 5 знаков")
    @JsonIgnore
    private String password;

    @Transient
    @JsonIgnore
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getId() {
        return id;
    }

    public NameImpl getName() {
        return name;
    }

    public void setName(NameImpl name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
