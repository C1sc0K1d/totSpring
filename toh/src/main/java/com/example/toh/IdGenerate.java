package com.example.toh;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

public class IdGenerate extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);
        return id != null ? id : super.generate(s, obj);
    }
}
