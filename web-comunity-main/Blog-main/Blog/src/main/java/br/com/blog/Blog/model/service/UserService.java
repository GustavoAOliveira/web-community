package br.com.blog.Blog.model.service;

import br.com.blog.Blog.model.domain.User;
import br.com.blog.Blog.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User>listarTodos(){
        return userRepository.findAll();
    }

    public User buscarPorId(long id){
        if(!userRepository.existsById(id)){
            return null;
        }
        return userRepository.findById(id).get();
    }
    public User adicionar(User newUser){
        return userRepository.save(newUser);
    }
    public User atualizar(User newUser, long id){
        if(userRepository.existsById(id)){
            newUser.setId(id);
            return userRepository.save(newUser);
        }
        return null;
    }

    public Boolean excluirPorId(long id){
        if(!userRepository.existsById(id)){
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }
}
