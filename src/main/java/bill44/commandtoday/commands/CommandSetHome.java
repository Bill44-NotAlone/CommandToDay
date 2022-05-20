package bill44.commandtoday.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class CommandSetHome extends CommandBase {
    public static NBTTagCompound data = new NBTTagCompound();

    @Override
    public String getName() {
        return "commandtoday-sethome";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) sender;
            data.setString("ctd-sethome", CommandSetHome.getPositionPlayer(player));
        }
    }

    private static String getPositionPlayer(EntityPlayer player) {
        return String.format("%d;%d.5;%d.2;%d.5;",
                player.dimension,
                (int) player.posX,
                (int) player.posY,
                (int) player.posZ
        );
    }

}
