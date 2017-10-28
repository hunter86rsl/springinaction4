package com.sia.knights;

import java.io.PrintStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sia.knights.BraveKnight;
import com.sia.knights.Knight;
import com.sia.knights.Quest;
import com.sia.knights.SlayDragonQuest;

@Configuration
public class KnightConfig {

	@Bean
	public Knight knight() {
		return new BraveKnight(quest());
	}

	@Bean
	public Quest quest() {
		return new SlayDragonQuest(stream());
	}

	@Bean
	public PrintStream stream() {
		return new FakePrintStream();
	}

}
