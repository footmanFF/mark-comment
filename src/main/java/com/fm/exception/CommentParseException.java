package com.fm.exception;

/**
 * @author zhangli on 2017/8/22.
 */
public class CommentParseException extends RuntimeException {

    public CommentParseException() {
    }

    public CommentParseException(String message) {
        super(message);
    }

    public CommentParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
