package srpfacadelab;

public class DamageCalculator {
    RpgPlayer rpgPlayer;
    InventoryManager im = new InventoryManager();


    public void takeDamage(int damage) {
        if (damage < rpgPlayer.getArmour()) {
            rpgPlayer.gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - rpgPlayer.getArmour();
        rpgPlayer.setHealth(rpgPlayer.getHealth() - damageToDeal);

        if (im.calculateInventoryWeight() < 0.5 * rpgPlayer.getCarryingCapacity()) {
            damage = Math.round((float)(damage - (damage * .25)));
        }

        rpgPlayer.gameEngine.playSpecialEffect("lots_of_gore");
    }
}
