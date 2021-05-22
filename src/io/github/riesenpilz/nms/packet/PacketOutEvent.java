package io.github.riesenpilz.nms.packet;

import org.bukkit.entity.Player;

public abstract class PacketOutEvent extends PacketEvent {

	public PacketOutEvent(Player injectedPlayer, PacketType packetType) {
		super(injectedPlayer, packetType);
	}
	public void sendToClient() {
		new PacketConnection(getInjectedPlayer()).sendPacketToClient(this);
	}
}