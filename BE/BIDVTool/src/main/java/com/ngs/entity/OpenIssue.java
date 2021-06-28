package com.ngs.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "open_issues")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenIssue implements Serializable {

    private static final long serialVersionUID = -6866562928721702218L;

    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    @Getter
    @Setter
    private User reporter;

    @Column(name = "resolution")
    @Getter
    @Setter
    private String resolution;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    @Getter
    @Setter
    private Operation operation;

    @Column(name = "owner")
    @Getter
    @Setter
    private String owner;

    @Column(name = "support")
    @Getter
    @Setter
    private String support;
    @Column(name = "open_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date openDate;

    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date dueDate;

    @Column(name = "close_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date closeDate;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Column(name = "comment")
    @Getter
    @Setter
    private String comment;

    @Column(name = "jra_number")
    @Getter
    @Setter
    private String jraNumber;
}
