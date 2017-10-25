package com.javaeeeee.dwstart.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AccessToken {
    @JsonProperty("accessToken")
    @NotNull
    private UUID token;

    @NotNull
    @JsonIgnore
    private DateTime lastAccessUTC;

    @JsonIgnore
    private User user;

    public AccessToken(UUID token, DateTime lastAccessUTC, User user) {
        this.token = token;
        this.lastAccessUTC = lastAccessUTC;
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public DateTime getLastAccessUTC() {
        return lastAccessUTC;
    }

    public void setLastAccessUTC(DateTime lastAccessUTC) {
        this.lastAccessUTC = lastAccessUTC;
    }

    public AccessToken(UUID token) {
        this.token = token;
    }


}