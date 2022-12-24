package org.overrun.mechanicalkineticenergy.recipes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ShapedRegister extends ShapedRecipe {
    private final Map<Character, RecipeChoice> ingredients = new HashMap<>();
    public ShapedRegister(@NotNull NamespacedKey key, @NotNull ItemStack result) {
        super(key, result);
    }

    @SuppressWarnings("UnusedReturnValue")
    public ShapedRecipe setIngredient(char key, ItemStack stack) {
        super.setIngredient(key, new RecipeChoice.MaterialChoice.ExactChoice(stack));
        return this;
    }

    @SuppressWarnings("unused")
    public ShapedRecipe setIngredient(char[] keys, ItemStack... stacks) {
        for (int i = 0; i < keys.length; i++) {
            this.setIngredient(keys[i], stacks[i]);
        }
        return this;
    }
}
