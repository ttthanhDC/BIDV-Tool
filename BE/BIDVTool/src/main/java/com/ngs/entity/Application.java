package com.ngs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "application")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Application {

    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bidv_app_code")
    private String bidvAppCode;

    @Column(name = "integration_app_code")
    private String integrationAppCode;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "abbreviation")
    private String abbreviation;

    @OneToMany(mappedBy = "application")
    private List<ApplicationServiceMap> applicationServiceMaps;

}
