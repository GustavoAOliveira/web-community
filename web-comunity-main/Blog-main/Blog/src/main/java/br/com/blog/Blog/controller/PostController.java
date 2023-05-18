package br.com.blog.Blog.controller;

import br.com.blog.Blog.model.domain.Post;
import br.com.blog.Blog.model.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> listarTodos(){
        return postService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> buscarPorId(@PathVariable long id){
        if(postService.buscarPorId(id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postService.buscarPorId(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post novoPost(@Valid @RequestBody Post newPost){
        return postService.novoPost(newPost);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id){
        if(!postService.deletarPorId(id)){
            return ResponseEntity.notFound().build();
        }
        postService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
