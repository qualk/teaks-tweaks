package me.teakivy.teakstweaks.commands;

import me.teakivy.teakstweaks.packs.tag.Tag;
import me.teakivy.teakstweaks.utils.command.AbstractCommand;
import me.teakivy.teakstweaks.utils.command.Arg;
import me.teakivy.teakstweaks.utils.command.CommandType;
import me.teakivy.teakstweaks.utils.command.PlayerCommandEvent;
import me.teakivy.teakstweaks.utils.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TagGameCommand extends AbstractCommand {

    public TagGameCommand() {
        super(CommandType.PLAYER_ONLY, "tag", "taggame", Permission.COMMAND_TAGGAME, Arg.optional("uninstall"));
    }

    @Override
    public void playerCommand(PlayerCommandEvent event) {
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("TaggedTeam");

        if (!event.hasArgs()) {
            if (!checkPermission(Permission.COMMAND_TAGGAME_GIVE)) return;

            Player player = event.getPlayer();

            player.getInventory().addItem(Tag.getTagItem());
            player.addScoreboardTag("tag_it");

            if (team == null) {
                team = sb.registerNewTeam("TaggedTeam");
                team.setColor(ChatColor.RED);
            }

            team.addEntry(player.getName());
            sendMessage("begun");
            return;
        }

        if (event.isArg(0, "uninstall")) {
            if (!checkPermission(Permission.COMMAND_TAGGAME_UNINSTALL)) return;

            if (team == null) return;
            team.unregister();
            sendMessage("uninstalled");
        }
    }
}
