package com.newrev.p1.dto.cart;

public class StripeResponse {
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public StripeResponse(String sessionId) {
        this.sessionId = sessionId;
    }

    public StripeResponse() {
    }
}

