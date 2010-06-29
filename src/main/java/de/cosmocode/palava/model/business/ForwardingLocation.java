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
