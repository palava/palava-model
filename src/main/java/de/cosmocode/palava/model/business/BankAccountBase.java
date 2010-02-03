package de.cosmocode.palava.model.business;

public interface BankAccountBase {

    String getAccountHolder();
    
    void setAccountHolder(String accountHolder);
    
    String getBankName();
    
    void setBankName(String bankName);
    
    String getCityName();
    
    void setCityName(String cityName);
    
    String getAccountNumber();
    
    void setAccountNumber(String accountNumber);
    
    String getIban();
    
    void setIban(String iban);
    
    String getBankCode();
    
    void setBankCode(String bankCode);
    
    String getBic();
    
    void setBic(String bic);
    
}
