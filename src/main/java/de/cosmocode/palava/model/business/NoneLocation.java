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

import de.cosmocode.rendering.Renderer;
import de.cosmocode.rendering.RenderingException;
import de.cosmocode.rendering.RenderingLevel;

/**
 * Constant noop {@link Location} implementation, used by {@link Locations#none()}.
 *
 * @since 3.3
 * @author Willi Schoenborn
 */
enum NoneLocation implements Location {

    INSTANCE;
    
    @Override
    public Double getLatitude() {
        return null;
    }
    
    @Override
    public Double getLongitude() {
        return null;
    }
    
    @Override
    public void setLatitude(Double latitude) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setLongitude(Double longitude) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void render(Renderer r, RenderingLevel level) throws RenderingException {
        r.key("latiude").nullValue();
        r.key("longitude").nullValue();
    }

    @Override
    public String toString() {
        return "Locations.none()";
    }
    
}
