package com.imryuik.server.auth;

public class AuthenticateAction {
    private String token;

    public AuthenticateAction() {
    }

    public AuthenticateAction(String token) {
        this.token = token;
    }

    public static AuthenticateActionBuilder builder() {
        return new AuthenticateActionBuilder();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class AuthenticateActionBuilder {
        private String token;

        AuthenticateActionBuilder() {
        }

        public AuthenticateActionBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticateAction build() {
            return new AuthenticateAction(this.token);
        }

        public String toString() {
            return "AuthenticateAction.AuthenticateActionBuilder(token=" + this.token + ")";
        }
    }
}
