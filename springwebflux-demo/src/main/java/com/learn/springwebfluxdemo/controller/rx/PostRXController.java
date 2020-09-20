package com.learn.springwebfluxdemo.controller.rx;

import com.learn.springwebfluxdemo.model.Post;
import com.learn.springwebfluxdemo.response.GetPostByIdResponse;
import com.learn.springwebfluxdemo.service.rx.PostRXService;
import com.learn.springwebfluxdemo.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/rx/posts")
public class PostRXController {

    @Autowired
    private PostRXService postService;



    @GetMapping
    public ResponseEntity< Flux<Post> > getPosts(){
        Flux<Post> postsFlux = postService.getPosts();
        Utility.sleep(20000);
        return ResponseEntity.ok().body( postsFlux);
    }

    @GetMapping("/{id}")
    public ResponseEntity< GetPostByIdResponse > getPostById(@PathVariable int id ){
        Mono<Post> postMono = postService.getPostById(id);
        Utility.sleep(20000);
        return ResponseEntity.ok().body(
                new GetPostByIdResponse(id, postMono.block())
        );
    }

}
