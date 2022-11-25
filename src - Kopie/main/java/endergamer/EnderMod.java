package endergamer;

import endergamer.Guis.FovCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ServerCommandManager;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;


@Mod(modid = ModSpecs.MODID,name = ModSpecs.NAME,version=ModSpecs.VERSION, clientSideOnly = true)
public class EnderMod {

    private EnderMod instance;
    private  Minecraft minecraft;
    public boolean connected = false;

    @Mod.EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new FovCommand());
        ServerCommandManager manager = new ServerCommandManager();
        manager.registerCommand(new FovCommand());
    }

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new FovCommand());
        MinecraftForge.EVENT_BUS.register(new ModSpecs());
    }

    @SubscribeEvent
    public void onFMLNetworkServerConnectionFromClient(FMLNetworkEvent.ServerConnectionFromClientEvent event) {
        connected = true;
    }

    @SubscribeEvent
    public void onFMLNetworkServerDisconnectionFromClient(FMLNetworkEvent.ServerDisconnectionFromClientEvent event) {
        connected = false;
    }


    public EnderMod getInstance() {
        return instance;
    }
}
