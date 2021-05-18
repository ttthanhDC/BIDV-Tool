package com.ngs.entity;

import javax.persistence.*;

@Entity
@Table(name = "application_service_map")
public class ApplicationServiceMap {
    @Id
    @Column(name = "map_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services service;
}
