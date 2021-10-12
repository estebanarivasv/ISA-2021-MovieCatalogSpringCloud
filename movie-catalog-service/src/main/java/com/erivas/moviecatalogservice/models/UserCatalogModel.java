package com.erivas.moviecatalogservice.models;

import java.util.List;

public class UserCatalogModel {

    List<CatalogModel> userCatalog;

    public UserCatalogModel() {
    }

    public List<CatalogModel> getUserCatalog() {
        return userCatalog;
    }

    public void setUserCatalog(List<CatalogModel> userCatalog) {
        this.userCatalog = userCatalog;
    }
}
