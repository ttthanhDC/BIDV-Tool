package com.ngs.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -7092298831772741231L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "user_name")
    @Getter
    @Setter
    private String userName;

    @Column(name = "full_name")
    @Getter
    @Setter
    private String fullName;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @OneToMany(mappedBy = "reporter", fetch = FetchType.LAZY)
    private List<OpenIssue> issues;

}
