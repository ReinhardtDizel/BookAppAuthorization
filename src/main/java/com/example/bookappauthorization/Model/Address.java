package com.example.bookappauthorization.Model;

import com.example.bookappauthorization.Types.Implementation.AddressImpl;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_address")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    /**<P>Address Column
     * <P><code>@Type(type = "com.example.bookappauthorization.Types.AddressTypeDescriptor")</code>
     * <P>names:
     * <UL>
     * <LI> address_line_1
     * <LI> address_line_2
     * <LI> country
     * <LI> city
     * <LI> zip_code
     * </UL>
     */
    @Columns(columns = {
            @Column(name = "address_line_1"),
            @Column(name = "address_line_2"),
            @Column(name = "country"),
            @Column(name = "city"),
            @Column(name = "zip_code")
    })
    @Type(type = "com.example.bookappauthorization.Types.AddressTypeDescriptor")
    private AddressImpl address;

    @Column(name = "CREATED_AT", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
