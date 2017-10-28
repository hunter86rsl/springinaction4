package com.sia.knights;

import java.io.PrintStream;

public class Minstrel {

	private PrintStream stream;

	public Minstrel(PrintStream stream) {
		this.stream = stream;
	}

	public void singBeforeQuest() {
		stream.println("Tra la la; This knight is brave!");
	}

	public void singAfterQuest() {
		stream.println("Hip hip hura; The brave knight filled the quest!");
	}

}
