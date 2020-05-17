package net.runelite.client.plugins.itemstats;

import com.google.common.collect.ImmutableMap;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.ACCURATE;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.ACCURATE_RANGING;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.AGGRESSIVE;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.AIM_AND_FIRE;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.BLOCK;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.CASTING;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.CONTROLLED;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.DEFENSIVE;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.DEFENSIVE_CASTING;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.LONGRANGE;
import static net.runelite.client.plugins.itemstats.ItemStatAttackStyle.RANGING;
import java.util.Map;

enum ItemStatWeaponType
{
	TYPE_0(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //Unarmed
	TYPE_1(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Axe
	TYPE_2(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //Blunt
	TYPE_3(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Bow
	TYPE_4(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Claws
	TYPE_5(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Crossbow
	TYPE_6(AGGRESSIVE, RANGING, CASTING, null), //Salamander
	TYPE_7(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Chinchompa
	TYPE_8(AIM_AND_FIRE, AGGRESSIVE, null, null), //Gun
	TYPE_9(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Slash sword
	TYPE_10(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //2h sword
	TYPE_11(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Pickaxe
	TYPE_12(CONTROLLED, AGGRESSIVE, null, DEFENSIVE), //Gauntlet halberd
	TYPE_13(ACCURATE, AGGRESSIVE, null, DEFENSIVE), //Polestaff
	TYPE_14(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Scythe
	TYPE_15(CONTROLLED, CONTROLLED, CONTROLLED, DEFENSIVE), //Spear/Hasta
	TYPE_16(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Spiked
	TYPE_17(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //Stab sword
	TYPE_18(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING), //Staff/Wand
	TYPE_19(ACCURATE_RANGING, RANGING, null, LONGRANGE), //Thrown weapon
	TYPE_20(ACCURATE, CONTROLLED, null, DEFENSIVE), //Whip
	TYPE_21(ACCURATE, AGGRESSIVE, null, DEFENSIVE, CASTING, DEFENSIVE_CASTING), //Bladed staff
	TYPE_22(ACCURATE, AGGRESSIVE, AGGRESSIVE, DEFENSIVE), //2h sword(Godsword)
	TYPE_23(CASTING, CASTING, null, DEFENSIVE_CASTING), //Powered staff
	TYPE_24(ACCURATE, AGGRESSIVE, CONTROLLED, DEFENSIVE), //Banner
	TYPE_25(CONTROLLED, AGGRESSIVE, null, DEFENSIVE), //Polearm
	TYPE_26(AGGRESSIVE, AGGRESSIVE, null, AGGRESSIVE), //Bludgeon
	TYPE_27(ACCURATE, null, null, BLOCK); //Bulwark

	private final ItemStatAttackStyle[] attackStyles;

	private static final Map<Integer, ItemStatWeaponType> weaponTypes;

	static
	{
		ImmutableMap.Builder<Integer, ItemStatWeaponType> builder = new ImmutableMap.Builder<>();

		for (ItemStatWeaponType weaponType : values())
		{
			builder.put(weaponType.ordinal(), weaponType);
		}

		weaponTypes = builder.build();
	}

	ItemStatWeaponType(ItemStatAttackStyle... attackStyles)
	{
		this.attackStyles = attackStyles;
	}

	public ItemStatAttackStyle[] getAttackStyles()
	{
		return attackStyles;
	}

	public static ItemStatWeaponType getWeaponType(int id)
	{
		return weaponTypes.get(id);
	}
}
