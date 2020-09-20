package com.learn.springwebfluxdemo.controller.block;

import com.learn.springwebfluxdemo.model.Post;
import com.learn.springwebfluxdemo.service.block.PostService;
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
@RequestMapping("/block/posts")
public class PostController {

    @Autowired
    private PostService postService;



    @GetMapping
    public ResponseEntity< List<Post> > getPosts(){
        List<Post> posts = postService.getPosts();
        Utility.sleep(20000);
        return ResponseEntity.ok().body( posts );
    }

    @GetMapping("/{id}")
    public ResponseEntity< Post > getPostById( @PathVariable int id ){
        Post post = postService.getPostById(id);
        Utility.sleep(20000);
        return ResponseEntity.ok().body( post );
    }

}
