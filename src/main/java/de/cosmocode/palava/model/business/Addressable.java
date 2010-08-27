package de.cosmocode.palava.model.business;

/**
 * An object associated with an {@link AddressBase}.
 *
 * @since 3.1
 * @author Willi Schoenborn
 */
public interface Addressable {

    /**
     * Retrieves the address of this addressable.
     * 
     * @return the address or null if there is no address
     */
    AddressBase getAddress();
    
}
