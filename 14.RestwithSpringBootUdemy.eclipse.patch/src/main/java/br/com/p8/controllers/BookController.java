package br.com.p8.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.p8.data.vo.BookVO;
import br.com.p8.services.BookServices;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookServices bookServices;
	
	@GetMapping(produces= {"application/json","application/xml","application/x-yaml"})
	public List<BookVO> findAll() throws Exception{
		List<BookVO> books = bookServices.findAll();
		books
			.stream()
			.forEach(
					p -> p.add(
							linkTo(
									methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return books;
		
	}
	
	@GetMapping(value="/{id}",produces= {"application/json","application/xml","application/x-yaml"})
	public BookVO findById(long id )  {
		BookVO book = bookServices.findById(id);
		book.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return book;
	}
	
	
	@PostMapping(consumes = {"application/json","application/xml","application/x-yaml"},
			produces = {"application/json","application/xml","application/x-yaml"})
	public BookVO create(@RequestBody BookVO book) throws Exception {
		BookVO bookVO = bookServices.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@PutMapping(consumes = {"application/json","application/xml","application/x-yaml"},
			produces = {"application/json","application/xml","application/x-yaml"})
	public BookVO update(@RequestBody BookVO book) throws Exception {
		BookVO bookVO = bookServices.update(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value="id") Long id) throws Exception {
		bookServices.delete(id);
	}

}
