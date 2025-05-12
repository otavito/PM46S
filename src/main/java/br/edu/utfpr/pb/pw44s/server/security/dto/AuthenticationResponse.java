package br.edu.utfpr.pb.pw44s.server.security.dto;

import lombok.*;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private UserResponseDTO user;

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(String token, UserResponseDTO user) {
        this.token = token;
        this.user = user;
    }
}
