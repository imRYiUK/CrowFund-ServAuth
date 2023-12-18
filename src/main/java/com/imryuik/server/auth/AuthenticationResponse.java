package com.imryuik.server.auth;

import com.imryuik.server.dto.UserDTO;

public class AuthenticationResponse {
    private String token;
    private UserDTO userDTO;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, UserDTO userDTO) {
        this.token = token;
        this.userDTO = userDTO;
    }

    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public UserDTO getUserDTO() {
        return this.userDTO;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AuthenticationResponse)) return false;
        final AuthenticationResponse other = (AuthenticationResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$userDTO = this.getUserDTO();
        final Object other$userDTO = other.getUserDTO();
        if (this$userDTO == null ? other$userDTO != null : !this$userDTO.equals(other$userDTO)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AuthenticationResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $userDTO = this.getUserDTO();
        result = result * PRIME + ($userDTO == null ? 43 : $userDTO.hashCode());
        return result;
    }

    public String toString() {
        return "AuthenticationResponse(token=" + this.getToken() + ", userDTO=" + this.getUserDTO() + ")";
    }

    public static class AuthenticationResponseBuilder {
        private String token;
        private UserDTO userDTO;

        AuthenticationResponseBuilder() {
        }

        public AuthenticationResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponseBuilder userDTO(UserDTO userDTO) {
            this.userDTO = userDTO;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this.token, this.userDTO);
        }

        public String toString() {
            return "AuthenticationResponse.AuthenticationResponseBuilder(token=" + this.token + ", userDTO=" + this.userDTO + ")";
        }
    }
}
