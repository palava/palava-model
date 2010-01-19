package de.cosmocode.palava.model;

import com.google.common.collect.ImmutableSet;

public interface AccountBase {

    ImmutableSet<? extends ContactBase> getContacts();
    
}
