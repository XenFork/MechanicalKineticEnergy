package org.overrun.mechanicalkineticenergy.recipe;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Utils {

    public static ShapedRecipe shapedRecipe(NamespacedKey key, ItemStack stack,
                                            Ing[] ings, String... strings) {
        if (strings !=null && strings.length !=0) {
            ShapedRecipe recipe = new ShapedRecipe(key, stack);
            if (strings.length == 2) {
                recipe.shape(strings[0], strings[1]);
            } else if (strings.length == 1) {
                recipe.shape(strings[0]);
            } else {
                recipe.shape(strings[0], strings[1], strings[2]);
            }
            for (var t : ings) {
                recipe.setIngredient(t.key,t.m);
            }
        }
        return null;
    }

    public record Ing(char key, Material m){}
}
