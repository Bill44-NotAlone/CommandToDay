package bill44.commandtoday.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nonnull;

public class CommandTeleportTo extends CommandBase {

    @Nonnull
    @Override
    public String getName() {
        return "commandtoday-teleportto";
    }

    @Nonnull
    @Override
    public String getUsage(ICommandSender sender)
    {
        return "commands.teleport.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            EntityPlayerMP entity = (EntityPlayerMP) sender;
            Vec3d vec3d = entity.getPositionVector();
            CommandBase.CoordinateArg x = parseCoordinate(vec3d.x, args[0], true);
            CommandBase.CoordinateArg y = parseCoordinate(vec3d.y, args[1], -4096, 4096, false);
            CommandBase.CoordinateArg z = parseCoordinate(vec3d.z, args[2], true);
            entity.dismountRidingEntity();
            entity.connection.setPlayerLocation(x.getResult(), y.getResult(), z.getResult(), 0, 0);
        }
    }
}
