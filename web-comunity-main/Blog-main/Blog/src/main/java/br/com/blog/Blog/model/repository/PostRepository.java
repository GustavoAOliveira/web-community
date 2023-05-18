package br.com.blog.Blog.model.repository;

import br.com.blog.Blog.model.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {
}
