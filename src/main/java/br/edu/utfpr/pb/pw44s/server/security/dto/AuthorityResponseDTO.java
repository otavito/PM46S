package br.edu.utfpr.pb.pw44s.server.security.dto;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
public class AuthorityResponseDTO {
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public AuthorityResponseDTO(String authority) {
        this.authority = authority;
    }
}
