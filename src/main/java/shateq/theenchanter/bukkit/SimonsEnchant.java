package shateq.theenchanter.bukkit;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

/**
 * It's all my fault!
 */
public abstract class SimonsEnchant extends Enchantment implements Listener {
	private final String name;

	public SimonsEnchant(String name, @NotNull String key) {
		super(new NamespacedKey(BukkitEnchanter.it(), key));
		this.name = name;
	}

	public void listenForEvents() {
		BukkitEnchanter.it().getServer().getPluginManager().registerEvents(this, BukkitEnchanter.it());
	}

	@Override
	public @NotNull String getName() {
		return name;
	}

	@Override
	public @NotNull Component displayName(int level) {
		return Component.text(name).append(Component.text(level));
	}

	@Override
	public boolean isTreasure() {
		return false;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public int getStartLevel() {
		return 0;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public @NotNull String translationKey() {
		return "enchantment." + this.getKey().namespace().toLowerCase(Locale.ROOT) + "." + this.getKey().getKey();
	}
}
