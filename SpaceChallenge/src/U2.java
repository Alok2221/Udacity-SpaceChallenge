public class U2 extends Rocket {

    U2() {
        setCost(120000000);
        setRocketWeight(18000);
        setTotalWeight(29000);
        setMaxCargo(getTotalWeight() - getRocketWeight());
    }

    @Override
    public boolean launch() {
        double rand = Math.random();
        double chanceLaunched = 0.04 * ((double) getCargoCarried() / (double) getMaxCargo());
        return !(chanceLaunched >= rand);
    }

    @Override
    public boolean land() {
        double rand = Math.random();
        double chanceLanded = 0.08 * ((double) getCargoCarried() / (double) getMaxCargo());
        return !(chanceLanded >= rand);
    }
}