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
