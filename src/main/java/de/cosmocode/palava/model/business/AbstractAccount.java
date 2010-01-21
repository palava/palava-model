package de.cosmocode.palava.model.business;

import de.cosmocode.json.JSONRenderer;
import de.cosmocode.palava.model.base.AbstractEntity;

/**
 * Abstract base implementation of the {@link AccountBase} interface.
 *
 * @author Willi Schoenborn
 */
public abstract class AbstractAccount extends AbstractEntity implements AccountBase {

    private String name;

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public JSONRenderer renderAsMap(JSONRenderer renderer) {
        return 
            super.renderAsMap(renderer).
            key("name").value(getName()).
            key("address").object(getAddress()).
            key("contacts").array(getContacts());
    }

}
