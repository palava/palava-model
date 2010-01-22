package de.cosmocode.palava.model.business;

import de.cosmocode.json.JSONMapable;

public interface Geographical extends JSONMapable {

    LocationBase getLocation();
    
}
