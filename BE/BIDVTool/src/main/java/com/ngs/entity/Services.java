package com.ngs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Services implements Serializable {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private Set<Operation> operations;

    @OneToMany(mappedBy = "service" , fetch = FetchType.EAGER)
    private Set<ApplicationServiceMap> applicationServiceMaps;

}
