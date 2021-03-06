package com.ngs.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "application_service_map")
@Data
public class ApplicationServiceMap {
    @Id
    @Column(name = "map_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
