package com.zarina.zarinabackend.payload.request;

public record UserRequest(
        String email,
        String name,
        String password,
        String surname
){
}
