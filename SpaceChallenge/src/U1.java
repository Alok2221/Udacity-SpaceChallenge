public class U1 extends Rocket {
    private double chanceLaunched;
    private double chanceLanded;

    U1() {
        setCost(100000000);
        setRocketWeight(10000);
        setTotalWeight(18000);
        setMaxCargo(getTotalWeight() - getRocketWeight());
    }

    @Override
    public boolean launch() {
        double rand = Math.random();
        chanceLaunched = 0.05 * ((double) getCargoCarried() / (double) getMaxCargo());
        if (chanceLaunched >= rand) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean land() {
        double rand = Math.random();
        chanceLanded = 0.01 * ((double) getCargoCarried() / (double) getMaxCargo());
        if (chanceLanded >= rand) {
            return false;
        } else {
            return true;
        }
    }
}