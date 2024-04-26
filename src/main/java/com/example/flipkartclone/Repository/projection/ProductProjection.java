package com.example.flipkartclone.Repository.projection;

import com.example.flipkartclone.Model.Category;

public interface ProductProjection {
    Long getId();
    String getTitle();
    String getDescription();
    String getImageUrl();
    Category getCategory();
}
