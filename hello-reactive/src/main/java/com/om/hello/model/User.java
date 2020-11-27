package com.om.hello.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String id;

    private String username;

    private String password;

    private String email;

}
