package com.ngs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "operation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {

    @Id
    @Column(name = "operation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "operation_name")
    private String operationName;

    @Column(name = "interact_with_core")
    private Boolean interactWithCore;

    @Column(name = "status")
    private String status;

    @Column(name = "ssd_soa")
    private String ssdSOA;

    @Column(name = "ssd_legacy")
    private String ssdLegacy;

    @Column(name = "is_workshop")
    private String isWorkshop;

}