package br.com.p8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.p8.data.model.Book;
import br.com.p8.data.vo.BookVO;

@Configuration
public class AppConfig {

	@Bean
	public Book book() {
		return new Book();
	}
	
	@Bean
	public BookVO bookVO() {
		return new BookVO();
	}
}
