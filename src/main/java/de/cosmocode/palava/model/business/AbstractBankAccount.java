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

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import de.cosmocode.commons.TrimMode;

/**
 * Abstract base implementation of the {@link BankAccountBase} interface
 * which can be used as an {@link Embeddable} or a {@link MappedSuperclass}.
 *
 * @author Willi Schoenborn
 */
@Embeddable
@MappedSuperclass
public abstract class AbstractBankAccount implements BankAccountBase {

    @Column(name = "account_holder")
    private String accountHolder;
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "city_name")
    private String cityName;
    
    @Column(name = "account_number")
    private String accountNumber;
    
    private String iban;
    
    @Column(name = "bank_code")
    private String bankCode;
    
    private String bic;
    
    @Override
    public String getAccountHolder() {
        return accountHolder;
    }
    
    @Override
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = TrimMode.NULL.apply(accountHolder);
    }
    
    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public void setBankName(String bankName) {
        this.bankName = TrimMode.NULL.apply(bankName);
    }
    
    @Override
    public String getCityName() {
        return cityName;
    }
    
    @Override
    public void setCityName(String cityName) {
        this.cityName = TrimMode.NULL.apply(cityName);
    }
    
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
    
    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = TrimMode.NULL.apply(accountNumber);
    }
    
    @Override
    public String getIban() {
        return iban;
    }
    
    @Override
    public void setIban(String iban) {
        this.iban = TrimMode.NULL.apply(iban);
    }
    
    @Override
    public String getBankCode() {
        return bankCode;
    }
    
    @Override
    public void setBankCode(String bankCode) {
        this.bankCode = TrimMode.NULL.apply(bankCode);
    }

    @Override
    public String getBic() {
        return bic;
    }
    
    @Override
    public void setBic(String bic) {
        this.bic = TrimMode.NULL.apply(bic);
    }

}
