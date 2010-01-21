package de.cosmocode.palava.model.business;

import com.google.common.collect.ImmutableSet;

import de.cosmocode.palava.model.base.EntityBase;

public interface AccountBase extends EntityBase {

    ImmutableSet<? extends ContactBase> getContacts();
    
}
