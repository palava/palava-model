/**
 * palava - a java-php-bridge
 * Copyright (C) 2007-2010  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

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
