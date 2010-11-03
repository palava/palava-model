package de.cosmocode.palava.model.business;

import de.cosmocode.commons.Conditions;

/**
 * Implementation of {@link Locations#modifiableLocation(Double, Double)}.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
final class ModifiableLocation extends AbstractLocation {
    
    private Double latitude;
    
    private Double longitude;

    public ModifiableLocation(Double latitude, Double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }

    @Override
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public void setLatitude(Double latitude) {
        this.latitude = latitude == null ? null : Conditions.checkArgument(Location.VALID_LATITUDE, latitude);
    }

    @Override
    public void setLongitude(Double longitude) {
        this.longitude = longitude == null ? null : Conditions.checkArgument(Location.VALID_LONGITUDE, longitude);
    }
    
}
