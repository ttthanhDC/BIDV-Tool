package com.ngs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Services {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "service")
    private List<Operation> operations;

    @OneToMany(mappedBy = "service")
    private List<ApplicationServiceMap> applicationServiceMaps;

}
