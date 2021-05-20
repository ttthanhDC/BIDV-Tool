package com.ngs.response;

import com.ngs.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetListUserResponse {
    List<User> users;
}
