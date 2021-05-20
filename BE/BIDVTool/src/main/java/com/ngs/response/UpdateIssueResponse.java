package com.ngs.response;

import com.ngs.entity.OpenIssue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIssueResponse {
    private OpenIssue previousIssue;
    private OpenIssue updatedIssue;
}
