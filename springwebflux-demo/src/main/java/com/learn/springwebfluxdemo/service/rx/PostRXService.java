package com.learn.springwebfluxdemo.service.rx;

import com.learn.springwebfluxdemo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class PostRXService {

    @Autowired
    private WebClient webClient;



    public Flux<Post> getPosts(){
        try {
            Flux<Post> responseFlux =  webClient.get()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                    .retrieve()
                    .bodyToFlux(Post.class);
            responseFlux.subscribe(
                    post -> System.out.println("post from flux: " + post),
                    error -> System.out.println("ERROR from flux: " + error.getMessage()),
                    () -> System.out.println("DONE from flux")
            );
            System.out.println(">>> call API done");
            return responseFlux;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Mono<Post> getPostById(int idPost ){
        try {
            Mono<Post> responseMono =  webClient.get()
                    .uri(new URI("https://jsonplaceholder.typicode.com/posts/"+idPost))
                    .retrieve()
                    .bodyToMono(Post.class);
            responseMono.subscribe(
                    post -> System.out.println("post from mono: " + post),
                    error -> System.out.println("ERROR from mono: " + error.getMessage()),
                    () -> System.out.println("DONE from mono")
            );
            System.out.println(">>> call API done");
            return responseMono;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
