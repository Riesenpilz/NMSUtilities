package io.github.riesenpilz.nmsUtilities.packet.playIn;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;

import io.github.riesenpilz.nmsUtilities.reflections.Field;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PacketListenerPlayIn;
import net.minecraft.server.v1_16_R3.PacketPlayInHeldItemSlot;

/**
 * https://wiki.vg/Protocol#Held_Item_Change_.28serverbound.29
 * <p>
 * Sent when the player changes the slot selection.
 * <p>
 * Packet ID: 0x25<br>
 * State: Play<br>
 * Bound To: Server
 * 
 * @author Martin
 *
 */
public class PacketPlayInChangeHeldItemEvent extends PacketPlayInEvent {

	/**
	 * The slot which the player has selected (0�8).
	 */
	private int slot;

	public PacketPlayInChangeHeldItemEvent(Player injectedPlayer, PacketPlayInHeldItemSlot packet) {
		super(injectedPlayer);
		Validate.notNull(packet);
		slot = packet.b();
	}

	public PacketPlayInChangeHeldItemEvent(Player injectedPlayer, int slot) {
		super(injectedPlayer);
		this.slot = slot;
	}

	public int getSlot() {
		return slot;
	}

	@Override
	public Packet<PacketListenerPlayIn> getNMS() {
		final PacketPlayInHeldItemSlot packet = new PacketPlayInHeldItemSlot();
		Field.set(packet, "itemInHandIndex", slot);
		return packet;
	}

	@Override
	public int getPacketID() {
		return 0x25;
	}

	@Override
	public String getProtocolURLString() {
		return "https://wiki.vg/Protocol#Held_Item_Change_.28serverbound.29";
	}
}
