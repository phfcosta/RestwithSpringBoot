package br.com.p8.converter.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.p8.data.model.Book;
import br.com.p8.data.vo.BookVO;


public class MockBook {


	public Book mockEntity() {
    	return mockEntity(0);
    }
    
    public BookVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }
    
    private Book mockEntity(Integer number) {
    	Book book = new Book();
    	book.setId(number.longValue());
    	book.setAuthor("Author " + 1);
    	book.setLaunchDate(new Date());
    	book.setPrice(0D);
    	book.setTitle("Title " + 1);
        return book;
    }

    private BookVO mockVO(Integer number) {
    	BookVO bookVO = new BookVO();
    	bookVO.setKey(number.longValue());
    	bookVO.setAuthor("Author " + 1);
    	bookVO.setLaunchDate(new Date());
    	bookVO.setPrice(0D);
    	bookVO.setTitle("Title " + 1);
        return bookVO;
    }

}
