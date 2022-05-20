package bill44.commandtoday;

import bill44.commandtoday.commands.CommandGoHome;
import bill44.commandtoday.commands.CommandSetHome;
import bill44.commandtoday.commands.CommandTeleportTo;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CommandToday.MODID, name = CommandToday.NAME, version = CommandToday.VERSION)
public class CommandToday
{
    public static final String MODID = "commandtoday";
    public static final String NAME = "CommandToDay";
    public static final String VERSION = "0.1";
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandTeleportTo());
        event.registerServerCommand(new CommandSetHome());
        event.registerServerCommand(new CommandGoHome());
    }
}
