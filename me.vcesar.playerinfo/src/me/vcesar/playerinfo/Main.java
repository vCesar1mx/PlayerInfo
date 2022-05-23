
package me.vcesar.playerinfo;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println(ChatColor.DARK_PURPLE+("--------------------------------"));
        System.out.println(ChatColor.DARK_PURPLE+("--------------------------------"));
    	System.out.println(ChatColor.GOLD+"PlayerInfo based for 1.16.1");
        System.out.println(ChatColor.GOLD+("Version: 1.0 - Dev: vCesar#001"));
        System.out.println(ChatColor.DARK_PURPLE+("--------------------------------"));
        System.out.println(ChatColor.DARK_PURPLE+("--------------------------------"));
        
       this.getCommand("info").setExecutor(new playerinfo());
       this.getCommand("playerinfo").setExecutor(new playerinfo());
       this.getCommand("pi").setExecutor(new playerinfo());
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED+("--------------------------------"));
        System.out.println(ChatColor.RED+("--------------------------------"));
    	System.out.println(ChatColor.GOLD+"PlayerInfo based for 1.16.1");
        System.out.println(ChatColor.GOLD+("Version: 1.0 - Dev: vCesar#001"));
        System.out.println(ChatColor.RED+("--------------------------------"));
        System.out.println(ChatColor.RED+("--------------------------------"));
    }
    
    public class playerinfo implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Player player = (Player) sender;
            
    if (sender instanceof Player) {
                if(args.length == 0){
                    sender.sendMessage(ChatColor.RED+("Necesitas especificar un jugador"));
                }
            Player target = Bukkit.getPlayer(args[0]);
            
            if (target == null){
                sender.sendMessage(ChatColor.RED+"El jugador esta desconectado");
                
                return true;
            }
            sender.sendMessage(ChatColor.GREEN+" IP: "+ChatColor.RESET+ChatColor.WHITE+target.getAddress());
            sender.sendMessage(ChatColor.GREEN+" Modo de juego: "+ChatColor.RESET+ChatColor.WHITE+target.getGameMode());
            sender.sendMessage(ChatColor.GREEN+" Idioma: "+ChatColor.RESET+ChatColor.WHITE+target.getLocale());
            sender.sendMessage(ChatColor.GREEN+" XP: "+ChatColor.RESET+ChatColor.WHITE+target.getExp());
            sender.sendMessage(ChatColor.GREEN+" UUID: "+ChatColor.RESET+ChatColor.WHITE+target.getUniqueId());
            sender.sendMessage(ChatColor.GREEN+" World: "+ChatColor.RESET+ChatColor.WHITE+target.getWorld());
    } else{
        System.out.println(ChatColor.RED+"Este comando es para uso exclusivo dentro del juego");
    }
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
    }
        
    public boolean hasPermission(Player player, String permission) {
        return player.hasPermission("playerinfo." + permission);
    }

    public ConsoleCommandSender getConsole() {
        return getServer().getConsoleSender();
    }


}

