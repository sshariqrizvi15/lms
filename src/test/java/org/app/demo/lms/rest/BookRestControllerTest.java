package org.app.demo.lms.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.app.demo.lms.entity.Category;
import org.app.demo.lms.service.BookService;
import org.app.demo.lms.service.CategoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
 
    @MockBean
    private BookService bookService;
	
    @MockBean
    private CategoryService categoryService;
    
	String exampleBookJson = "{\"name\":\"alchemist\",\"authorName\":\"coelho\",\"categoryId\":1}";

    @Test
    public void canCreateANewBook() throws Exception {
        // when
        Category category = new Category(1, "drama");
        
        Mockito.when(categoryService.findById(category.getId()))
          .thenReturn(category);
        
        MockHttpServletResponse response = mockMvc.perform(
        		MockMvcRequestBuilders.post("/api/books").contentType(MediaType.APPLICATION_JSON).content(
        				exampleBookJson)).andReturn().getResponse();
 
        // then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

    }
}
