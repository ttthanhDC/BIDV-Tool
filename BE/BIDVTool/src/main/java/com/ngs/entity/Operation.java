package com.ngs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "operation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation implements Serializable {
    private static final long serialVersionUID = -7117418021077896914L;

    @Id
    @Column(name = "operation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @Getter
    @Setter
    private Service service;

    @Column(name = "application_id")
    @Getter
    @Setter
    private Integer applicationId;

    @Column(name = "operation_name")
    @Getter
    @Setter
    private String operationName;

    @Column(name = "interact_with_core")
    @Getter
    @Setter
    private Boolean interactWithCore;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Column(name = "ssd_soa")
    @Getter
    @Setter
    private String ssdSOA;

    @Column(name = "ssd_legacy")
    @Getter
    @Setter
    private String ssdLegacy;

    @Column(name = "is_workshop")
    @Getter
    @Setter
    private Boolean workshop;

    @JsonIgnore
    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @JsonIgnore
    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OpenIssue> issues;

}
