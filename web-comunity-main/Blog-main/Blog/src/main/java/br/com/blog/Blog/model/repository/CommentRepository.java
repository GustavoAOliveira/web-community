package br.com.blog.Blog.model.repository;

import br.com.blog.Blog.model.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
