package pl.alvion.rpem.rpessentials.health_dr.playerPart.Interfaces;

import org.bukkit.inventory.ItemStack;
import pl.alvion.rpem.rpessentials.health_dr.enums.HealingStages;

public interface HealableInjury {
    int regenerationTimeMax(); // Maksymalny czas wyzdrowienia
    int healingLevelMin(); // Minimalny level leczenia
    ItemStack[] itemsMandatoryToHeal();
}
