package com.healthrx.automation.model;

public class WebhookResponse {
    private String webhook; // This the URL to submit to

    private String accessToken; // This is the JWT token

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
