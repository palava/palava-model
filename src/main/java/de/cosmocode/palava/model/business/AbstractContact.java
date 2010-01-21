package de.cosmocode.palava.model.business;

import java.util.Date;

import javax.persistence.Column;

import de.cosmocode.commons.TrimMode;
import de.cosmocode.json.JSONRenderer;
import de.cosmocode.palava.model.base.AbstractEntity;

/**
 * Abstract base implementation of the {@link ContactBase} interface.
 *
 * @author Willi Schoenborn
 */
public abstract class AbstractContact extends AbstractEntity implements ContactBase {

    private String title;
    
    private String forename;
    
    private String surname;
    
    private String username;
    
    private String password;
    
    @Column(name = "activated_at")
    private Date activatedAt;
    
    private String languageCode;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = TrimMode.NULL.apply(title);
    }

    @Override
    public String getForename() {
        return forename;
    }

    @Override
    public void setForename(String forename) {
        this.forename = TrimMode.NULL.apply(forename);
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = TrimMode.NULL.apply(surname);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = TrimMode.NULL.apply(username);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = TrimMode.NULL.apply(password);
    }

    @Override
    public Date getActivatedAt() {
        return activatedAt;
    }

    @Override
    public void setActivatedAt(Date activatedAt) {
        this.activatedAt = activatedAt;
    }
    
    @Override
    public void setActivated() {
        setActivatedAt(new Date());
    }
    
    @Override
    public boolean isActivated() {
        return getActivatedAt() != null;
    }

    @Override
    public String getLanguageCode() {
        return languageCode;
    }

    @Override
    public void setLanguageCode(String languageCode) {
        this.languageCode = TrimMode.NULL.apply(languageCode);
        if (this.languageCode == null) return;
        this.languageCode = this.languageCode.toLowerCase();
    }
    
    @Override
    public JSONRenderer renderAsMap(JSONRenderer renderer) {
        return
            super.renderAsMap(renderer).
            key("account").object().
                key("id").value(getAccount().getId()).
            endObject().
            key("title").value(getTitle()).
            key("forename").value(getForename()).
            key("surname").value(getSurname()).
            key("address").object(getAddress()).
            key("username").value(getUsername()).
            key("activatedAt").value(getActivatedAt()).
            key("isActivated").value(isActivated()).
            key("languageCode").value(getLanguageCode());
    }

}
