package com.example.yuchihan.doordashpro.model;

import android.support.annotation.Nullable;

/**
 * Address.
 */
public class Address {

    @Nullable private String city;
    @Nullable private String state;
    @Nullable private String street;

    @Nullable
    public String getCity() {
        return city;
    }

    @Nullable
    public String getState() {
        return state;
    }

    @Nullable
    public String getStreet() {
        return street;
    }
}
