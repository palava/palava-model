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

import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.google.common.base.Preconditions;

import de.cosmocode.commons.TrimMode;
import de.cosmocode.palava.model.base.AbstractEntity;

/**
 * Abstract base implementation of the {@link ContactBase} interface.
 *
 * @author Willi Schoenborn
 */
@MappedSuperclass
public abstract class AbstractContact extends AbstractEntity implements ContactBase {

    private String title;

    private String forename;

    private String surname;

    private String password;

    @Column(name = "activated_at")
    private Date activatedAt;

    private Locale locale;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = TrimMode.NULL.apply(title);
    }

    @Override
    public String getForename() {
        return forename;
    }

    @Override
    public void setForename(String forename) {
        this.forename = TrimMode.NULL.apply(forename);
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = TrimMode.NULL.apply(surname);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = TrimMode.NULL.apply(password);
    }

    @Override
    public Date getActivatedAt() {
        return activatedAt;
    }

    @Override
    public void setActivatedAt(Date activatedAt) {
        this.activatedAt = activatedAt;
    }

    @Override
    public void setActivated() {
        setActivatedAt(new Date());
    }

    @Override
    public boolean isActivated() {
        return getActivatedAt() != null;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public void setLocale(Locale locale) {
        this.locale = Preconditions.checkNotNull(locale, "Locale");
    }

}
