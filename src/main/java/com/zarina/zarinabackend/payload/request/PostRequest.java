package com.zarina.zarinabackend.payload.request;

public record PostRequest(
        String title,
        String body,
        Long userId
) {
}
