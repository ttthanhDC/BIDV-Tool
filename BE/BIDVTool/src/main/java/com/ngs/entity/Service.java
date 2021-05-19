package com.ngs.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service implements Serializable {

    @Id
    @Getter
    @Setter
    @Column(name = "service_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "service_name")
    private String serviceName;

    @Getter
    @Setter
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "service")
    private List<Operation> operations;

    @OneToMany(mappedBy = "service")
    private List<ApplicationServiceMap> applicationServiceMaps;
}
