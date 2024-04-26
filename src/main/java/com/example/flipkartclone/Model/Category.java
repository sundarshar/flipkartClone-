package com.example.flipkartclone.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Category extends BaseModel implements Serializable {
    private String name;
}
