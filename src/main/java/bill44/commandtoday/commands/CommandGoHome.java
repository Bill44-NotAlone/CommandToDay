package bill44.commandtoday.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandGoHome extends CommandBase {
    @Override
    public String getName() {
        return "commandtoday-home";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender instanceof EntityPlayer) {
            EntityPlayerMP playerMP = (EntityPlayerMP)sender;
            String home = CommandSetHome.data.getString("ctd-sethome");
            String[] data = home.replace(',', '.').split(";");
            playerMP.connection.setPlayerLocation(Double.parseDouble(data[1]), Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]), 0, 0);

        }
    }
}
