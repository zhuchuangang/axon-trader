package com.szss.axon.trader.api.users;

import org.axonframework.common.Assert;
import org.axonframework.domain.IdentifierFactory;

import java.io.Serializable;

/**
 * Created by zcg on 15/9/21.
 */
public class UserId implements Serializable {

    private String identifier;

    public UserId() {
        identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public UserId(String identifier) {
        Assert.notNull(identifier, "identifier is not null");
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId)) return false;
        UserId userId = (UserId) o;
        if (!identifier.equals(userId.identifier)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public String toString() {
        return this.identifier;
    }
}
