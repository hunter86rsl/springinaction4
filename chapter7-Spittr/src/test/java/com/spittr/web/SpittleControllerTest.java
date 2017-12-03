package com.spittr.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;

public class SpittleControllerTest {

	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(get("/spittles"))
			.andExpect(view().name("spittles"))
			.andExpect(model().attributeExists("spittleList"))
			.andExpect(model().attribute("spittleList", 
					hasItems(expectedSpittles.toArray())));
	}
		
	@Test
	public void shouldShowPagedSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(50);
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(get("/spittles?max=238900&count=50"))
			.andExpect(view().name("spittles"))
			.andExpect(model().attributeExists("spittleList"))
			.andExpect(model().attribute("spittleList", 
					hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void testSpittle() throws Exception {
		
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spittles/12345"))
				.andExpect(view().name("spittle"))
				.andExpect(model().attributeExists("spittle"))
				.andExpect(model().attribute("spittle", expectedSpittle));			
	}
	
	@Test
	public void saveSpittle() throws Exception {
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/spittles")
			.param("message", "Hello World")
			.param("longitude", "-81.58")
			.param("latitude", "28.41"))
		.andExpect(redirectedUrl("/spittles"));		
		
		verify(mockRepository, atLeastOnce()).save(new Spittle(null, "Hello World", new Date(), -81.58, 28.41));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();

		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}

		return spittles;
	}
}