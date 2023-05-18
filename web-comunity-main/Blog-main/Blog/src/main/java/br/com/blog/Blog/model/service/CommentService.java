package br.com.blog.Blog.model.service;

import br.com.blog.Blog.model.domain.Comment;
import br.com.blog.Blog.model.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> listarTodos(){
        return commentRepository.findAll();
    }
    public Comment buscarPorid(long id) {
        if (commentRepository.existsById(id)) {
            Comment comment = commentRepository.findById(id).get();
            return comment;
        }
        return null;
    }
    public Comment novoComentario(Comment newComment){
        newComment.setDataCriacao(LocalDateTime.now());
        newComment.setDataAtualizacao(LocalDateTime.now());
        return commentRepository.save(newComment);
    }
    public boolean deletarPorId(long id){
        if(commentRepository.existsById(id)){
            commentRepository.deleteById(id);
                return true;
        }
        return false;
    }
}

