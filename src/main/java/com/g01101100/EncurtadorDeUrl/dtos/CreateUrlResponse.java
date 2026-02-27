package com.g01101100.EncurtadorDeUrl.dtos;

public class CreateUrlResponse {

    private String shortCode;

    public CreateUrlResponse(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getShortCode() {
        return shortCode;
    }
}
