package com.zarina.zarinabackend.payload.request;


public record CommentRequest (
        String value,
        Long postId,
        Long userId
){
}
