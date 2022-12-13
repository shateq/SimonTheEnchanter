package shateq.theenchanter.bukkit;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import shateq.theenchanter.bukkit.enchantments.Fertilizer;

import java.util.List;

public final class BukkitEnchanter extends JavaPlugin implements CommandExecutor, TabCompleter {
	public static final String THE_ENCHANTER = "simons";
	private static BukkitEnchanter inst;

	public static BukkitEnchanter it() {
		return inst;
	}

	@Contract("_ -> new")
	public static @NotNull NamespacedKey namespacedKey(@NotNull String key) {
		return new NamespacedKey(THE_ENCHANTER, key);
	}

	@Override
	public void onEnable() {
		inst = new BukkitEnchanter();
		ItemStack i = new ItemStack(Material.POTATO);
//		i.addEnchantment();

		try {
			claimEnchantments();
		} catch (Exception e) {
			getSLF4JLogger().error(e.toString());
		}

		System.out.println("hi");
	}

	public void claimEnchantments() {
		new Fertilizer().listenForEvents();
	}

	@Override
	public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
		return super.onTabComplete(sender, command, alias, args);
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
		return super.onCommand(sender, command, label, args);
	}
}
