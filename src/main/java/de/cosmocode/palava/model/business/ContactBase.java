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

import de.cosmocode.palava.model.base.EntityBase;

/**
 * Interface definition of contacts. A contact usually refers to a real person.
 * A contact is part of one and only one {@link AccountBase account}.
 *
 * @since 2.0
 * @author Willi Schoenborn
 */
public interface ContactBase extends EntityBase, AccountMember {
   
    /**
     * Retrieves the title of this contact. This is usually something like
     * her/his academic grade, job title, etc.
     * 
     * @since 2.0
     * @return the title of this contact
     */
    String getTitle();
    
    /**
     * Changes the title of this contact. The specified
     * name may be trimmed before applied.
     * 
     * @since 2.0
     * @param title the new title
     */
    void setTitle(String title);
    
    /**
     * Retrieves the first name of this contact.
     * 
     * @since 2.0
     * @return the first name
     */
    String getForename();
    
    /**
     * Changes the first name of this contact. The specified
     * name may be trimmed before applied.
     * 
     * @since 2.0
     * @param forename the new forename
     */
    void setForename(String forename);
    
    /**
     * Retrieves the last name of this contact.
     * 
     * @since 2.0
     * @return the last name
     */
    String getSurname();
    
    /**
     * Changes the last name of this contact. The specified
     * name may be trimmed before applied.
     * 
     * @since 2.0
     * @param surname the new last name
     */
    void setSurname(String surname);
    
    /**
     * Retrieves the associated address of this contact.
     * 
     * @since 2.0
     * @return the associated address, may never be null
     */
    AddressBase getAddress();
    
    /**
     * Retrieves the probably encrypted password of this contact.
     * 
     * @since 2.0
     * @return the password of this contact
     */
    String getPassword();
    
    /**
     * Changes the password of this contact.
     * 
     * <strong>
     *   You are strongly encouraged to use some kind of
     *   one-way hash algorithm before storing passwords.
     * </strong>
     * 
     * @param password the new password
     */
    void setPassword(String password);
    
    /**
     * Retrieves the activation date of this contact. This date
     * specifies the date at which this contact has activated her/his
     * access.
     * 
     * @since 2.0
     * @return the date of activation
     */
    Date getActivatedAt();
    
    /**
     * Changes the date of activation of this acontact.
     * 
     * @since 2.0
     * @param activatedAt the new activation date, null will be treated
     *        as deactivation
     */
    void setActivatedAt(Date activatedAt);
    
    /**
     * Marks this contact as activated by setting its activatedAt
     * date to now.
     * 
     * @since 2.0
     */
    void setActivated();
    
    /**
     * Checks whether this contact is activated.
     * 
     * @since 2.0
     * @return true if this contact is activated, false otherwise
     */
    boolean isActivated();
    
    /**
     * Retrieves the locale of this contact.
     * 
     * @since 2.0
     * @return the locale
     */
    Locale getLocale();
    
    /**
     * Changes the locale of this contact.
     * 
     * @since 2.0
     * @param locale the new locale
     */
    void setLocale(Locale locale);
    
}
