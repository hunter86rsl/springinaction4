package com.sia.knights;

public class DamselRescuingKnight implements Knight {

	private RescuingQuest quest;

	public DamselRescuingKnight() {
		this.quest = new RescuingQuest();
	}

	public void embarkOnQuest() {
		quest.embark();
	}

}
