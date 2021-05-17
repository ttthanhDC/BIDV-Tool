package com.ngs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "application")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Application implements Serializable {
    private static final long serialVersionUID = 5216821564242825076L;

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

    @Column(name = "in_scope")
    private Boolean inScope;

    @OneToMany(mappedBy = "application")
    @JsonIgnore
    private List<ApplicationServiceMap> applicationServiceMaps;

}
