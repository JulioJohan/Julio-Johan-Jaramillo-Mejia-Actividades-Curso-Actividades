package com.amurfu.tienda.data.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
//Esta anotación ayuda a que no crees otra tabla
@Embeddable
public class TransactionProductId implements Serializable {

    private Integer idTransaction;

    private Integer idProduct;

//    Validando que no sean iguales los productos
    public  boolean equals(Object object){
        if(this == object) return  true;
        if(object == null || Hibernate.getClass(this) != Hibernate.getClass(object)) return false;
        TransactionProductId entity = (TransactionProductId) object;
        return Objects.equals(this.idProduct, entity.idTransaction) &&
                Objects.equals(this.idTransaction,entity.idProduct);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idTransaction,idProduct);
    }
}
