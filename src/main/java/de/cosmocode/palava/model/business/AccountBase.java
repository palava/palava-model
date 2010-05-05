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

import de.cosmocode.palava.model.base.EntityBase;

/**
 * Interface definitions of accounts. An account is container for
 * {@link ContactBase contacts} and many more related entities. An instance of this type
 * usually maps directly to a company or a business partner in real life.
 *
 * @since 2.0
 * @author Willi Schoenborn
 */
public interface AccountBase extends EntityBase {

    /**
     * Retrieves the name of this account. The name can be virtually
     * anything but usually refers to the official company name.
     *
     * @return the name of this account
     */
    String getName();

    /**
     * Changes the name of this account to the specified name. The specified
     * name may be trimmed before applied.
     * 
     * @param name the new name of this account
     */
    void setName(String name);

    /**
     * Retrieves the associated {@link AddressBase address} of this account.
     *
     * @return the address associated with this account, may never be null
     */
    AddressBase getAddress();

    /**
     * Retrieves all associated contacts of this account.
     * 
     * <p>
     *   Implementation note: This method breaks a fundamental rule by specifying a
     *   generic return value using wildcards. This is an intended <em>feature</em>
     *   to allow sub classes to specify both: The collection type and the concrete
     *   element type.
     * </p>
     *
     * @return all associated contacts
     */
    Iterable<? extends ContactBase> getContacts();

}
