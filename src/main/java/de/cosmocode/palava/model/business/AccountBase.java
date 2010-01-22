package de.cosmocode.palava.model.business;

import java.util.Set;

import de.cosmocode.palava.model.base.EntityBase;

public interface AccountBase extends EntityBase {

    /**
     * Generic, can be anything...
     * 
     * @return
     */
    String getName();
    
    void setName(String name);
    
    AddressBase getAddress();
    
    /**
     * Left to the implementation ...
     * 
     * @return
     */
    Set<? extends ContactBase> getContacts();
    
}
