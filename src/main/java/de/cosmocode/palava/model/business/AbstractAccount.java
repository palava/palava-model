package de.cosmocode.palava.model.business;

import de.cosmocode.commons.TrimMode;
import de.cosmocode.json.JSONRenderer;
import de.cosmocode.json.RenderLevel;
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
        this.name = TrimMode.NULL.apply(name);
    }
    
    @Override
    public JSONRenderer renderAsMap(JSONRenderer renderer) {
        super.renderAsMap(renderer);
        
        if (renderer.ge(RenderLevel.TINY)) {
            renderer.
                key("name").value(getName());
        }
        if (renderer.ge(RenderLevel.SHORT)) {
            renderer.
                key("address").object(getAddress());
        }
        if (renderer.ge(RenderLevel.MEDIUM)) {
            renderer.
                key("contacts").array(getContacts());
        }
        return renderer;
    }

}
