package com.javaMadeEasy.Entertainment.authentication.AUth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponce {

    private String token;

    public AuthenticationResponce(String token) {
        this.token = token;
    }

    public AuthenticationResponce() {
    }
}
