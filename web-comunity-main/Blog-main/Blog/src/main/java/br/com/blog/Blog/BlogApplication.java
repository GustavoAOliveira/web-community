package br.com.blog.Blog;

import br.com.blog.Blog.model.domain.User;
import br.com.blog.Blog.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

	@Bean
	public CommandLineRunner init (
			@Autowired UserService userService
	) {
		return args -> {
			userService.adicionar(new User(1L, "Matheus F", "matheus.fs.contato@gmail.com"));
			userService.adicionar(new User(2L, "Gustavo A", "gustavoA@gmail.com"));
			userService.adicionar(new User(3L, "Lucas M", "lucasM@gmail.com"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
