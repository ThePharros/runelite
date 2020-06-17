/*
 * Copyright (c) 2020, Truth Forger <https://github.com/Blackberry0Pie>
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
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

class ClickboxOverlay extends Overlay
{
	//the max click distance is approximately 22 tiles
	private static final int MAX_DISTANCE = 22 * 128;

	private final StealingArtefactsPlugin plugin;
	private final Client client;

	@Inject
	private ClickboxOverlay(Client client, StealingArtefactsPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		LocalPoint playerLocation = client.getLocalPlayer().getLocalLocation();
		StealingArtefactState state = plugin.getStealingArtefactState();
		if (state == null || !plugin.isInPortPiscariliusRegion())
		{
			return null;
		}
		TileObject object = plugin.getObjectToHighlight();
		if (object != null && object.getLocalLocation().distanceTo(playerLocation) <= MAX_DISTANCE)
		{
			drawObjectLocation(graphics, plugin.getObjectToHighlight(), Color.CYAN);
		}

		return null;
	}

	private void drawObjectLocation(Graphics2D graphics, TileObject object, Color color)
	{
		if (object == null)
		{
			return;
		}

		Shape clickbox = object.getClickbox();
		if (clickbox != null)
		{
			Color fillColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), 20);

			graphics.setColor(color);
			graphics.draw(clickbox);
			graphics.setColor(fillColor);
			graphics.fill(clickbox);
		}
	}
}
