package shateq.theenchanter.bukkit;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import shateq.theenchanter.bukkit.enchantments.Fertilizer;

import java.util.List;

public final class BukkitEnchanter extends JavaPlugin implements CommandExecutor, TabCompleter {
	public static SimonsEnchant FERTILIZER;

	private static BukkitEnchanter inst;

	public static @NotNull BukkitEnchanter it() {
		return inst;
	}

	@Contract("_ -> new")
	public @NotNull NamespacedKey namespace(@NotNull String key) {
		return new NamespacedKey(inst, key);
	}

	@Override
	public void onEnable() {
		this.setNaggable(true);
		getSLF4JLogger().info("{} with API version {}", getDescription().getName(), getDescription().getAPIVersion());
		BukkitEnchanter.inst = this;

		(FERTILIZER = new Fertilizer()).listenForEvents();

		ItemStack stack = new ItemStack(Material.POTATO);
		ItemMeta meta = stack.getItemMeta();

		meta.addEnchant(FERTILIZER, 1, true);

		meta.getPersistentDataContainer().set(namespace("ourkey"), PersistentDataType.INTEGER, 2);
		stack.setItemMeta(meta);

		getSLF4JLogger().info("Meta: {}\nStack: {}\n", meta.getEnchants(), stack.getEnchantments());
		/*
		try {
			claimEnchantment(FERTILIZER);
		} catch (Exception e) {
			getSLF4JLogger().error("Problem registering an enchantment:  " + e);
		}*/
	}

	public void claimEnchantment(@NotNull SimonsEnchant enchant) {
		var key = enchant.getKey();
		enchant.listenForEvents();

		Enchantment.registerEnchantment(enchant);
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
