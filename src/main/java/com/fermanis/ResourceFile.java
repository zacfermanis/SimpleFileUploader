package com.fermanis;

import javax.persistence.*;

/**
 * Created by zacfe on 8/20/2017.
 */

@Entity
public class ResourceFile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private byte[] image;

    public ResourceFile() {
    }

    public ResourceFile(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public int getSize() {
        return image.length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
