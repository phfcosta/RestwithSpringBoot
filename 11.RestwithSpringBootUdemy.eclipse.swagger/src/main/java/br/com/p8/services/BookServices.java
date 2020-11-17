package br.com.p8.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.p8.converter.DozerConverter;
import br.com.p8.data.model.Book;
import br.com.p8.data.vo.BookVO;
import br.com.p8.request.repository.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public List<BookVO> findAll(){
		return null;
	}


}
