package shateq.theenchanter.bukkit;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public abstract class RecordableEnchant extends Enchantment implements Listener {

	public RecordableEnchant(@NotNull String key) {
		super(BukkitEnchanter.namespacedKey(key));
	}

	public void listenForEvents() {
		BukkitEnchanter.it().getServer().getPluginManager().registerEvents(this, BukkitEnchanter.it());
	}

	@Override
	public @NotNull String getName() {
		return "@deprecated";
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
		return "enchantment.simons"+this.getKey().getKey();
	}
}
