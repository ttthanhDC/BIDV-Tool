package com.ngs.repository;

import com.ngs.entity.OpenIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface IssueRepository extends CrudRepository<OpenIssue, Integer> {


}
