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

import de.cosmocode.rendering.Renderable;

/**
 * Interface definition of international bank accounts.
 *
 * @since 2.0
 * @author Willi Schoenborn
 */
public interface BankAccountBase extends Renderable {

    /**
     * Retrieves the account holder of this account.
     * 
     * @since 2.0
     * @return the account holder
     */
    String getAccountHolder();
    
    /**
     * Changes the account holder of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param accountHolder the new account holder
     */
    void setAccountHolder(String accountHolder);
    
    /**
     * Retrieves the bank name of this account.
     * 
     * @since 2.0
     * @return the bank name of this account
     */
    String getBankName();
    
    /**
     * Changes the bank name of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param bankName the new bank name
     */
    void setBankName(String bankName);
    
    /**
     * Retrieves the city name of this address.
     * 
     * @since 2.0
     * @return the city name
     */
    String getCityName();
    
    /**
     * Changes the city name of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param cityName the new city name
     */
    void setCityName(String cityName);
    
    /**
     * Retrieves the account number of this account.
     * 
     * @since 2.0
     * @return the account number
     */
    String getAccountNumber();
    
    /**
     * Changes the account number of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param accountNumber the new account number
     */
    void setAccountNumber(String accountNumber);
    
    /**
     * Retrieves the international bank account number (iban) of this
     * account.
     * 
     * @since 2.0
     * @return the iban of this account
     */
    String getIban();
    
    /**
     * Changes the international bank account number (iban) of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param iban the new iban of this account
     */
    void setIban(String iban);
    
    /**
     * Retrieves the bank code of this account.
     * 
     * @since 2.0
     * @return the bank code
     */
    String getBankCode();
    
    /**
     * Changes the bank code of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param bankCode the new bank code
     */
    void setBankCode(String bankCode);
    
    /**
     * Retrieves the bank identifier code (bic) of this account.
     * 
     * @since 2.0
     * @return the bic of this account
     */
    String getBic();
    
    /**
     * Changes the bank identifier code (bic) of this account. The specified
     * value may be trimmed before applied.
     * 
     * @since 2.0
     * @param bic the new bic of this account
     */
    void setBic(String bic);
    
}
