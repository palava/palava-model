package de.cosmocode.palava.model.business;

import de.cosmocode.rendering.Renderer;
import de.cosmocode.rendering.RenderingException;
import de.cosmocode.rendering.RenderingLevel;

/**
 * Abstract implementation of the {@link Location} interface.
 *
 * @since 
 * @author Willi Schoenborn
 */
public abstract class AbstractLocation implements Location {

    @Override
    public void render(Renderer renderer, RenderingLevel level) throws RenderingException {
        renderer.
            key("latitude").value(getLatitude()).
            key("longitude").value(getLongitude());
    }

}
