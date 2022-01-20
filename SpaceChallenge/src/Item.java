public class Item {
    private final String name;
    private final int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}