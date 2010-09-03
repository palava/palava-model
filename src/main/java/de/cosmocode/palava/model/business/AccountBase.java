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

import de.cosmocode.palava.model.base.EntityBase;

/**
 * Interface definitions of accounts. An account is container for
 * {@link ContactBase contacts} and many more related entities. An instance of this type
 * usually maps directly to a company or a business partner in real life.
 *
 * @since 2.0
 * @author Willi Schoenborn
 */
public interface AccountBase extends EntityBase, Addressable {

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
    @Override
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
