package com.ngs.response;

import com.ngs.entity.OpenIssue;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetListIssueResponse {
    private List<OpenIssue> issues;

}
