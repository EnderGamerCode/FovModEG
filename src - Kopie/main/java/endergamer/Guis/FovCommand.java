package endergamer.Guis;

import endergamer.EnderMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class FovCommand implements ICommand{

    @Override
    public String getCommandName() {
        return "fov";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "EnderGamerMod!";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> commandAliases = new ArrayList<>();
        return commandAliases;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if (strings.length == 0) {
            iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Usage: " + EnumChatFormatting.GREEN + "/high,low"));

        } else {
            switch (strings[0].toLowerCase()) {
                case "high":
                    Minecraft.getMinecraft().gameSettings.fovSetting += 5;
                    break;
                case "low":
                    Minecraft.getMinecraft().gameSettings.fovSetting -= 5;
                    break;
                default:
                    iCommandSender.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "Usage: " + EnumChatFormatting.GREEN + "/high,low"));
                    break;
            }
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] strings, BlockPos blockPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
