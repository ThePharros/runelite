/*
 * Copyright (c) 2019, honeyhoney <https://github.com/honeyhoney>
 * Copyright (c) 2020, ThePharros <https://github.com/ThePharros>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.stealingartefacts;

import java.awt.Color;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter(AccessLevel.PACKAGE)
@AllArgsConstructor
enum StealingArtefactState
{

	NO_TASK("No Task", Color.WHITE, new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0)),
	LOCATION_NORTH("North House", Color.YELLOW, new WorldPoint(1767, 3753, 1), new WorldPoint(1767, 3751, 0)),
	LOCATION_SOUTHEAST("Southeast House", Color.YELLOW, new WorldPoint(1774, 3730, 1), new WorldPoint(1776, 3730, 0)),
	LOCATION_SOUTH("South House", Color.YELLOW, new WorldPoint(1764, 3735, 1), new WorldPoint(1768, 3733, 0)),
	LOCATION_SOUTHWEST("Southwest House", Color.YELLOW, new WorldPoint(1750, 3735, 1), new WorldPoint(1749, 3730, 0)),
	LOCATION_WEST("West House", Color.YELLOW, new WorldPoint(1747, 3749, 1), new WorldPoint(1751, 3751, 0)),
	LOCATION_NORTHWEST("Northwest House", Color.YELLOW, new WorldPoint(1751, 3763, 1), new WorldPoint(1750, 3756, 0)),
	FAILURE("Failure", Color.RED, new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0)),
	DELIVER_ARTEFACT("Deliver Artefact", Color.GREEN, new WorldPoint(0, 0, 0), new WorldPoint(0, 0, 0));

	private final String description;
	private final Color color;
	private final WorldPoint worldPoint;
	private final WorldPoint ladderPoint;
}
