package com.learn.springwebfluxdemo.service.block;

import com.learn.springwebfluxdemo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private WebClient webClient;



    public List<Post> getPosts(){
        try {
            List<Post> response = (List<Post>) webClient.get()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                    .retrieve()
                    .bodyToFlux(Post.class).collectList().block();
            System.out.println(">>> call API done");
            return response;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Post getPostById(int idPost ){
        try {
            ResponseEntity<Post> response =  webClient.get()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts/"+idPost))
                    .retrieve()
                    //.bodyToMono(Post.class);
                    .toEntity(Post.class).block();
            System.out.println(">>> call API done");
            return response.getBody();

        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
