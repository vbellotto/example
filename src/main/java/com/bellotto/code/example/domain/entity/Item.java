package com.bellotto.code.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for Item table.
 */
@Table(name = "item")
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String creator;
    private String version;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreator() {
        return creator;
    }

    public String getVersion() {
        return version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
