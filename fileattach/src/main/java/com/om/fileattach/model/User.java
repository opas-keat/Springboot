package com.om.fileattach.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author opas
 */
@Data
@Builder
public class User {

    private String id;

    private String username;

    private String password;

    private String email;

}
