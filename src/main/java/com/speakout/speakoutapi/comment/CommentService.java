package com.speakout.speakoutapi.comment;

public interface CommentService {

    Comment save(CommentDto commentDto);
    CommentDto likeComment(Long commentId);
}
