package shateq.theenchanter.bukkit.enchantments;

import io.papermc.paper.enchantments.EnchantmentRarity;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityCategory;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import shateq.theenchanter.bukkit.BukkitEnchanter;
import shateq.theenchanter.bukkit.SimonsEnchant;

import java.util.EnumSet;
import java.util.Set;

public class Fertilizer extends SimonsEnchant {
	public Fertilizer() {
		super("Fertilizer","fertilizer");
	}

	@EventHandler
	public void onMove(@NotNull PlayerMoveEvent e) {
		BukkitEnchanter.it().getSLF4JLogger().info("Moved who? {}", e.getPlayer().getName());
	}

	@Override
	public int getMaxLevel() {
		return 0;
	}

	@Override
	public @NotNull EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.ARMOR_FEET;
	}

	@Override
	public boolean conflictsWith(@NotNull Enchantment other) {
		return false;
	}

	@Override
	public boolean canEnchantItem(@NotNull ItemStack item) {
		return false;
	}

	@Override
	public @NotNull EnchantmentRarity getRarity() {
		return EnchantmentRarity.RARE;
	}

	@Override
	public float getDamageIncrease(int level, @NotNull EntityCategory entityCategory) {
		return 0;
	}

	@Override
	public @NotNull Set<EquipmentSlot> getActiveSlots() {
		return EnumSet.of(EquipmentSlot.FEET);
	}
}
