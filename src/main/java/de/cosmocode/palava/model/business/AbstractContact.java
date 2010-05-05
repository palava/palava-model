/**
 * palava - a java-php-bridge
 * Copyright (C) 2007-2010  CosmoCode GmbH
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
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
