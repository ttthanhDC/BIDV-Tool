package com.ngs.response;

import com.ngs.response.bean.Issue;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetListIssueResponse {
    private List<Issue> issues;

}
