/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
public interface ContactBase extends EntityBase, AccountMember, Addressable {
   
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
