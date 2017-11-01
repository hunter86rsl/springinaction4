package com.soundsystem.properties;

import com.soundsystem.CompactDisc;
import com.soundsystem.MediaPlayer;

public class CDPlayer implements MediaPlayer {

	private CompactDisc compactDisc;

	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

	public void play() {
		compactDisc.play();
	}

}
