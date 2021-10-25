package com.example.bookappauthorization.Types;

import com.example.bookappauthorization.Types.Implementation.AddressImpl;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressTypeDescriptor implements CompositeUserType {

    public int[] sqlTypes() {
        return new int[] {
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.INTEGER.sqlType()
        };
    }
/** <P>Address Implementation properties:
 * <UL>
    * <LI> addressLine1: <P><code>StringType.INSTANCE;</code>
    * <LI> addressLine2: <P><code>StringType.INSTANCE</code>;
    * <LI> country:      <P><code>StringType.INSTANCE</code>;
    * <LI> city:         <P><code>StringType.INSTANCE</code>;
    * <LI> zipCode:      <P><code>IntegerType.INSTANCE</code>;
 * </UL>
*/
    @Override
    public String[] getPropertyNames() {
        return new String[] {
                "addressLine1",
                "addressLine2",
                "country",
                "city",
                "zipCode"
        };
    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[] { StringType.INSTANCE,
                StringType.INSTANCE,
                StringType.INSTANCE,
                StringType.INSTANCE,
                IntegerType.INSTANCE
        };
    }

    @Override
    public Object getPropertyValue(Object component, int property) throws HibernateException {
        AddressImpl empAdd = (AddressImpl) component;

        switch (property) {
            case 0:
                return empAdd.getAddressLine1();
            case 1:
                return empAdd.getAddressLine2();
            case 2:
                return empAdd.getCity();
            case 3:
                return empAdd.getCountry();
            case 4:
                return empAdd.getZipCode();
        }

        throw new IllegalArgumentException(property + " is an invalid property index for class type "
                + component.getClass().getName());
    }

    @Override
    public void setPropertyValue(Object component1, int property, Object component2) throws HibernateException {
        AddressImpl empAdd1 = (AddressImpl) component1;
        AddressImpl empAdd2 = (AddressImpl) component2;

        switch (property) {
            case 0:
                empAdd1.setAddressLine1(empAdd2.getAddressLine1());
            case 1:
                empAdd1.setAddressLine2(empAdd2.getAddressLine2());
            case 2:
                empAdd1.setCity(empAdd2.getCity());
            case 3:
                empAdd1.setCountry(empAdd2.getCountry());
            case 4:
                empAdd1.setZipCode(empAdd2.getZipCode());
        }

        throw new IllegalArgumentException(property + " is an invalid property index for class type "
                + component1.getClass().getName());
    }

    @Override
    public Class returnedClass() {
        return AddressImpl.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        if (o == null) return 0;
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings,
                              SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException, SQLException {
        AddressImpl address = new AddressImpl();
        address.setAddressLine1(resultSet.getString(strings[0]));
        address.setAddressLine2(resultSet.getString(strings[1]));
        address.setCity(resultSet.getString(strings[2]));
        address.setCountry(resultSet.getString(strings[3]));
        address.setZipCode(Integer.parseInt(resultSet.getString(strings[4])));
        return address;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value,
                            int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        AddressImpl address = (AddressImpl) value;
        if(address != null) {
            st.setString(index, address.getAddressLine1());
            st.setString(index+1, address.getAddressLine2());
            st.setString(index+2, address.getCity());
            st.setString(index+3, address.getCountry());
            st.setInt(index+4, address.getZipCode());
        }
        else {
            st.setNull(index, sqlTypes()[0]);
            st.setNull(index+1, sqlTypes()[1]);
            st.setNull(index+2, sqlTypes()[2]);
            st.setNull(index+3, sqlTypes()[3]);
            st.setNull(index+4, sqlTypes()[4]);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable serializable, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object original, Object target, SharedSessionContractImplementor sharedSessionContractImplementor, Object owner) throws HibernateException {
        return original;
    }
}
