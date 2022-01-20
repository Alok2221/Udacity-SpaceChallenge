public class Rocket implements SpaceShip {
    private int cost;
    private int rocketWeight;
    private int maxCargo;
    private int cargoCarried;
    private int totalWeight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public final boolean canCarry(Item item) {
        return (cargoCarried + rocketWeight) < totalWeight;
    }

    public final int carry(Item item) {
        cargoCarried += item.getWeight();
        return cargoCarried;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getCargoCarried() {
        return cargoCarried;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    public void setMaxCargo(int maxCargo) {
        this.maxCargo = maxCargo;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }
}