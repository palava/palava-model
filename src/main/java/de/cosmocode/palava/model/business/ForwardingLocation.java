package de.cosmocode.palava.model.business;

import com.google.common.collect.ForwardingObject;

import de.cosmocode.rendering.Renderer;
import de.cosmocode.rendering.RenderingException;
import de.cosmocode.rendering.RenderingLevel;

/**
 * Abstract decorator for {@link Location}s.
 *
 * @since 2.1
 * @author Willi Schoenborn
 */
abstract class ForwardingLocation extends ForwardingObject implements Location {

    @Override
    protected abstract Location delegate();

    @Override
    public Double getLatitude() {
        return delegate().getLatitude();
    }

    @Override
    public Double getLongitude() {
        return delegate().getLongitude();
    }

    @Override
    public void setLatitude(Double latitude) {
        delegate().setLatitude(latitude);
    }

    @Override
    public void setLongitude(Double longitude) {
        delegate().setLongitude(longitude);
    }

    @Override
    public void render(Renderer renderer, RenderingLevel level) throws RenderingException {
        delegate().render(renderer, level);
    }
    
}
