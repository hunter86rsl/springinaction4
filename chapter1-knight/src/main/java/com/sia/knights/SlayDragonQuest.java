package com.sia.knights;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

	private PrintStream stream;

	public SlayDragonQuest(PrintStream stream) {
		this.stream = stream;
	}

	public void embark() {

		stream.println("I will embark quest of slaying dragon!");
	}

}
