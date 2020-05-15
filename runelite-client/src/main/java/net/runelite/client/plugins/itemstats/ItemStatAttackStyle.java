package net.runelite.client.plugins.itemstats;

enum ItemStatAttackStyle
{
	ACCURATE("Accurate", ItemStatCombatType.MELEE),
	AGGRESSIVE("Aggressive", ItemStatCombatType.MELEE),
	DEFENSIVE("Defensive", ItemStatCombatType.MELEE),
	CONTROLLED("Controlled", ItemStatCombatType.MELEE),
	ACCURATE_RANGING("Accurate Ranging", ItemStatCombatType.RANGED),
	RANGING("Ranging", ItemStatCombatType.RANGED),
	LONGRANGE("Longrange", ItemStatCombatType.RANGED),
	CASTING("Casting", ItemStatCombatType.MAGIC),
	DEFENSIVE_CASTING("Defensive Casting", ItemStatCombatType.MAGIC),
	AIM_AND_FIRE("Aim and Fire", ItemStatCombatType.NONE),
	BLOCK("Block", ItemStatCombatType.NONE);

	private final String name;
	private final ItemStatCombatType combatType;

	ItemStatAttackStyle(String name, ItemStatCombatType combatType)
	{
		this.name = name;
		this.combatType = combatType;
	}

	public String getName()
	{
		return name;
	}

	public ItemStatCombatType getCombatType()
	{
		return combatType;
	}
}
