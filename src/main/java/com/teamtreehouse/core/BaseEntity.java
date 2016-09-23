package com.teamtreehouse.core;

import javax.persistence.*;

/**
 * Created by lDahlberg on 9/21/2016.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }
}
