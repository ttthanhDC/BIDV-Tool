package com.ngs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "application")
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Application implements Serializable {
    private static final long serialVersionUID = 5216821564242825076L;

    @Id
    @Column(name = "application_id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bidv_app_code")
    @Getter
    @Setter
    private String bidvAppCode;

    @Column(name = "integration_app_code")
    @Getter
    @Setter
    private String integrationAppCode;

    @Column(name = "application_name")
    @Getter
    @Setter
    private String applicationName;

    @Column(name = "abbreviation")
    @Getter
    @Setter
    private String abbreviation;

    @Column(name = "in_scope")
    @Getter
    @Setter
    private Boolean inScope;

    @OneToMany(mappedBy = "application")
    @JsonIgnore
    private List<ApplicationServiceMap> applicationServiceMaps;

}
