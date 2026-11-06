package com.trashslot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TrashSlot implements ModInitializer {
    public static final Identifier TRASH_PACKET = new Identifier("trashslot", "trash");

    @Override
    public void onInitialize() {
        ServerPlayNetworking.registerGlobalReceiver(TRASH_PACKET,
            (server, player, handler, buf, responseSender) ->
                server.execute(() -> player.currentScreenHandler.setCursorStack(ItemStack.EMPTY)));
    }
}
