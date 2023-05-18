package br.com.blog.Blog.controller;

import br.com.blog.Blog.model.domain.User;
import br.com.blog.Blog.model.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listarTodos() {
        return userService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable long id) {
        if (userService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userService.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User adicionar(@Valid @RequestBody User newUser) {
        return userService.adicionar(newUser);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> atualizar(@Valid @PathVariable long id, @RequestBody User newUser) {
        User user = userService.atualizar(newUser, id);
        if(user == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPorId(@PathVariable long id) {
       if(!userService.excluirPorId(id)){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.noContent().build();
    }
}











