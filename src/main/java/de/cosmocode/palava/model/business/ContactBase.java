package de.cosmocode.palava.model.business;

import java.util.Date;

import de.cosmocode.palava.model.base.AddressBase;
import de.cosmocode.palava.model.base.EntityBase;

public interface ContactBase extends EntityBase {
    
    AccountBase getAccount();

    String getTitle();
    
    void setTitle(String title);
    
    String getForename();
    
    void setForename(String forename);
    
    String getSurname();
    
    void setSurname(String surname);
    
    AddressBase getAddress();
    
    // TODO useful here?
    
    String getUsername();
    
    void setUsername(String username);
    
    String getPassword();
    
    /**
     * TODO Highly recommended to use crypto...
     * 
     * @param password
     */
    void setPassword(String password);
    
    Date getActivatedAt();
    
    void setActivatedAt(Date activatedAt);
    
    void setActivated();
    
    boolean isActivated();
    
    String getLanguageCode();
    
    /**
     * ISO 639, lowercase
     * 
     * @param languageCode
     */
    void setLanguageCode(String languageCode);
    
}
