package com.ngs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "open_issues")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenIssue {

    @Id
    @Column(name = "issue_id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private User reporter;

    @Column(name = "resolution")
    private String resolution;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Column(name = "owner")
    private String owner;
    @Column(name = "open_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openDate;

    @Column(name = "due_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @Column(name = "close_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;
}
