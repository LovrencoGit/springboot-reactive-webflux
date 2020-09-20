package com.learn.springwebfluxdemo.response;

import com.learn.springwebfluxdemo.model.Post;
import reactor.core.publisher.Mono;

public class GetPostByIdResponse extends Response {

    private int id;
    private Post post;

    public GetPostByIdResponse(int id, Post post) {
        super();
        this.id = id;
        this.post = post;
    }

    public GetPostByIdResponse(int code, String message, boolean error, int id, Post post) {
        super(code, message, error);
        this.id = id;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
