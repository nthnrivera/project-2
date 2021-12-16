package com.revature.project2.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
