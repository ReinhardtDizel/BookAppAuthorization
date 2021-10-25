package com.example.bookappauthorization.Model;

import com.example.bookappauthorization.Types.Implementation.NameImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_data")
public class User {
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
    @Type(type="text")
    private String email;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("user")
    private Set<Address> address = new HashSet<>();

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private Security security;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<Role> roles = new HashSet<>();

    @Column(name = "CREATED_AT", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public String getId() {
        return id;
    }

    public NameImpl getName() {
        return name;
    }

    public void setName(NameImpl name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", security=" + security +
                ", roles=" + roles +
                ", createdAt=" + createdAt +
                '}';
    }
}
