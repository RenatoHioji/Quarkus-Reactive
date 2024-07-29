package org.acme.models;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Cacheable
public class Test extends PanacheEntity {



    @Column(length = 25, unique = true)
    public String name;


}
