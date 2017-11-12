package com.soundsystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class EnvironmentInjectionTest {

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("classpath:placeholder-config.xml")
	public static class InjectFromProperties_XMLConfig {

		@Autowired
		private BlankDisc blankDisc;

		@Test
		public void assertBlankDiscProperties() {
			assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
			assertEquals("The Beatles", blankDisc.getArtist());
		}
	}

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = EnvironmentConfig.class)
	public static class InjectFromProperties {

		@Autowired
		private BlankDisc blankDisc;

		@Test
		public void assertBlankDiscProperties() {
			assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
			assertEquals("The Beatles", blankDisc.getArtist());
		}
	}

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = EnvironmentConfigWithDefaults.class)
	public static class InjectFromPropertiesWithDefaults {

		@Autowired
		private BlankDisc blankDisc;

		@Test
		public void assertBlankDiscProperties() {
			assertEquals("Rattle and Hum", blankDisc.getTitle());
			assertEquals("U2", blankDisc.getArtist());
		}
	}

	public static class InjectFromPropertiesWithRequiredProperties {

		@Test
		public void assertBlankDiscProperties() {
			new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
		}
	}
}
