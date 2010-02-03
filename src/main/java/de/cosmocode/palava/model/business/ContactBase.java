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

import java.util.Date;
import java.util.Locale;

public interface ContactBase extends AccountMemberBase {
    
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
    
    Locale getLocale();
    
    void setLocale(Locale locale);
    
}
