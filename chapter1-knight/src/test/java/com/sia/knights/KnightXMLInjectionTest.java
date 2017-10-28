package com.sia.knights;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class KnightXMLInjectionTest {

	@Autowired
	private Knight knight;

	@Autowired
	private FakePrintStream printStream;

	@After
	public void clearPrintStream() {
		printStream.clear();
	}

	@Test
	public void shouldInjectKnightWithSlayDragonQuest() {
		knight.embarkOnQuest();
		assertEquals("Tra la la; This knight is brave!\n" + 
					"I will embark quest of slaying dragon!\n" + 
					"Hip hip hura; The brave knight filled the quest!\n",
				printStream.getPrintedBuffer());
	}

}
