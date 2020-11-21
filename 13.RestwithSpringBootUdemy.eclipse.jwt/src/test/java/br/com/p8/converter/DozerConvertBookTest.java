package br.com.p8.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.p8.converter.mocks.MockBook;
import br.com.p8.data.vo.BookVO;


@RunWith(SpringRunner.class)
public class DozerConvertBookTest {

	MockBook inputObject;

    @Before
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerConverter.parseObject(inputObject.mockEntity(), BookVO.class);
       
        Assert.assertEquals(Long.valueOf(0L).longValue(), output.getKey());
        Assert.assertEquals("Author 1", output.getAuthor());
        Assert.assertEquals("Title 1", output.getTitle());
        Assert.assertEquals(0D, output.getPrice().doubleValue(),0);
    }
}
