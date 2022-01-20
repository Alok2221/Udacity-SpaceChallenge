import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {

    public void startSimulation() {
        long phase1U1 = runSimulation(loadU1(loadItems("buildingequipment.txt")));
        System.out.println("Budget for Phase 1 (U1): $" + phase1U1);
        long phase2U1 = runSimulation(loadU1(loadItems("colonyandfoodresources.txt")));
        System.out.println("Budget for Phase 2 (U1): $" + phase2U1);
        long totalBudgetU1 = phase1U1 + phase2U1;
        System.out.println("Total Budget (U1) $" + totalBudgetU1);

        long phase1U2 = runSimulation(loadU1(loadItems("buildingequipment.txt")));
        System.out.println("Budget for Phase 1 (U2): $" + phase1U2);
        long phase2U2 = runSimulation(loadU1(loadItems("colonyandfoodresources.txt")));
        System.out.println("Budget for Phase 2 (U2): $" + phase2U2);
        long totalBudgetU2 = phase1U2 + phase2U2;
        System.out.println("Total Budget (U2) $" + totalBudgetU2);

        if (totalBudgetU1 > totalBudgetU2) {
            System.out.println("\nU2 Rockets are Cheaper");
        } else if (totalBudgetU1 < totalBudgetU2) {
            System.out.println("\nU1 Rockets are Cheaper");
        } else {
            System.out.println("\nBoth will cost same");
        }
    }

    private ArrayList<Item> loadItems(String fName) {
        ArrayList<Item> arrayList = new ArrayList<>();
        File file = new File(fName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("=");
                Item item = new Item(line[0], Integer.parseInt(line[1]));
                arrayList.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    private ArrayList<Rocket> loadU1(ArrayList<Item> arrayList) {
        ArrayList arrayListOfU1 = new ArrayList<>();
        Rocket u1 = new U1();
        Iterator<Item> iterator = arrayList.iterator();
        return getRockets(arrayListOfU1, u1, iterator);
    }

    private ArrayList<Rocket> loadU2(ArrayList<Item> arrayList) {
        ArrayList<Rocket> arrayListOfU2 = new ArrayList<>();
        Rocket u2 = new U2();
        Iterator iterator = arrayList.iterator();
        return getRockets(arrayListOfU2, u2, iterator);
    }

    private ArrayList<Rocket> getRockets(ArrayList<Rocket> arrayListOfU2, Rocket u2, Iterator iterator) {
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                arrayListOfU2.add(u2);
                u2 = new U1();
                u2.carry(item);
            }
            if (!iterator.hasNext()) {
                arrayListOfU2.add(u2);
            }
        }
        return arrayListOfU2;
    }

    private long runSimulation(ArrayList<Rocket> rocket) {
        long totalBudget = 0;

        for (Rocket rocket1 : rocket) {
            while (!rocket1.launch()) {
                totalBudget += rocket1.getCost();
            }
            while (!rocket1.land()) {
                while (!rocket1.launch()) {
                    totalBudget += rocket1.getCost();
                }
                totalBudget += rocket1.getCost();
            }
            totalBudget += rocket1.getCost();
        }
        return totalBudget;
    }
}