package br.com.blog.Blog.model.service;

import br.com.blog.Blog.model.domain.Post;
import br.com.blog.Blog.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> listarTodos(){
        return postRepository.findAll();
    }

    public Post buscarPorId(long id){
        if(!postRepository.existsById(id)){
           return null;
        }
        return postRepository.findById(id).get();
    }
    public Post novoPost(Post newPost){
        newPost.setDataCriacao(LocalDateTime.now());
        newPost.setDataAtualizacao(LocalDateTime.now());

        return postRepository.save(newPost);
    }
    public boolean deletarPorId(long id){
        if(postRepository.existsById(id)){
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}






