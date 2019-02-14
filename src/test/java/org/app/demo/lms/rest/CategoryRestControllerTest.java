package org.app.demo.lms.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.app.demo.lms.service.CategoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryRestController.class)
public class CategoryRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
 
    @MockBean
    private CategoryService categoryService;
	
	String exampleCategoryJson = "{\"name\":\"fiction\"}";

    @Test
    public void canCreateANewCategory() throws Exception {
        // when
        MockHttpServletResponse response = mockMvc.perform(
        		MockMvcRequestBuilders.post("/api/categories").contentType(MediaType.APPLICATION_JSON).content(
        				exampleCategoryJson)).andReturn().getResponse();
 
        // then
		assertEquals(response.getStatus(), HttpStatus.OK.value());

    }
}
