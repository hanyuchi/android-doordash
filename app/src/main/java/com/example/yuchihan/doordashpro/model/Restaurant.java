package com.example.yuchihan.doordashpro.model;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Restaurant.
 */
public class Restaurant {

    @Nullable private Address address;
    @Nullable private String cover_img_url;
    @Nullable private String description;
    @Nullable private String id;
    @Nullable private String name;
    @Nullable private List<Menu> menus;

    @Nullable
    public Address getAddress() {
        return address;
    }

    @Nullable
    public String getCoverImageUrl() {
        return cover_img_url;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public String getId() {
        return id;
    }

    @Nullable
    public List<Menu> getMenus() {
        return menus;
    }

    @Nullable
    public String getName() {
        return name;
    }
}
