package srpfacadelab;

import srpfacadelab.Item;
import java.util.List;

public class InventoryManager {

    RpgPlayer rpgPlayer;

    private List<Item> inventory;

    private boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }

        return false;
    }

    public boolean pickUpItem(Item item) {
        int weight = calculateInventoryWeight();
        if (weight + item.getWeight() > rpgPlayer.getCarryingCapacity())
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            rpgPlayer.setHealth(rpgPlayer.getHealth() + item.getHeal());

            if (rpgPlayer.getHealth() > rpgPlayer.getMaxHealth())
                rpgPlayer.setHealth(rpgPlayer.getMaxHealth());

            if (item.getHeal() > 500) {
                rpgPlayer.gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            rpgPlayer.gameEngine.playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique()) {
            rpgPlayer.gameEngine.playSpecialEffect("blue_swirly");
        }

        inventory.add(item);

        rpgPlayer.calculateStats();

        return true;
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = rpgPlayer.gameEngine.getEnemiesNear(rpgPlayer);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

}