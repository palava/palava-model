package de.cosmocode.palava.model.business;

import com.google.common.base.Preconditions;

/**
 * Implementation of {@link Locations#unmodifiableLocation(Location)}.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
final class UnmodifiableLocation extends ForwardingLocation {
    
    private final Location location;

    public UnmodifiableLocation(Location location) {
        this.location = Preconditions.checkNotNull(location, "Location");
    }

    @Override
    protected Location delegate() {
        return location;
    }

    @Override
    public void setLatitude(Double latitude) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLongitude(Double longitude) {
        throw new UnsupportedOperationException();
    }
    
}
