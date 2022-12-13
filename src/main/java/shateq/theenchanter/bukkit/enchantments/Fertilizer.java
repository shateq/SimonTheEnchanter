package shateq.theenchanter.bukkit.enchantments;

import io.papermc.paper.enchantments.EnchantmentRarity;
import net.kyori.adventure.text.Component;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityCategory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import shateq.theenchanter.bukkit.RecordableEnchant;

import java.util.EnumSet;
import java.util.Set;

public class Fertilizer extends RecordableEnchant {
	public Fertilizer() {
		super("fertilizer");
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
	public boolean isTreasure() {
		return false;
	}

	@Override
	public boolean isCursed() {
		return false;
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
	public @NotNull Component displayName(int level) {
		return Component.text("Fertilizer");
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
