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
public class Service {
    @Id
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "integration_app_code")
    private String integrationAppCode;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private List<Operation> operations;

    @OneToMany(mappedBy = "serviceMapped", fetch = FetchType.EAGER)
    private List<ApplicationServiceMap> applicationServiceMaps;

}
