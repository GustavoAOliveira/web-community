package br.com.blog.Blog.controller;

import br.com.blog.Blog.model.domain.Comment;
import br.com.blog.Blog.model.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping
    public List<Comment> listarTodos(){
        return commentService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> buscarPorId(@PathVariable long id){
        if(commentService.buscarPorid(id) != null){
            return ResponseEntity.ok().body(commentService.buscarPorid(id));
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment novoComment(@Valid @RequestBody Comment newComment){
        return commentService.novoComentario(newComment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable long id){
        if(commentService.deletarPorId(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}















