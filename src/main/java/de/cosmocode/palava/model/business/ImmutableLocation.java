package de.cosmocode.palava.model.business;

/**
 * Implementation of {@link Locations#immutableLocation(double, double)}.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
final class ImmutableLocation extends AbstractLocation {

    private final Double latitude;
    private final Double longitude;

    public ImmutableLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLongitude(Double longitude) {
        throw new UnsupportedOperationException();
    }

}
