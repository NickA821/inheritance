package labs.five;

public class Driver {
    public static void main(String[] args) {

        Animal [] animals = new Animal[4];

        animals[0] = new Animal("Mountain Zebra", 7);
        animals[1] = new CaptiveAnimal("Plains Zebra", 8, "555432");
        animals[2] = new Vertebrate("Grevy's Zebra", 10, "555433", "Sexual", "EndoSkeleton");
        animals[3] = new Invertebrate("Stomolophus meleagris", 1, "77723", "both");

        for (Animal p : animals) {
            System.out.println(p);
        }
        System.out.println();

        for (int i = 0; i < animals.length; ++i) {
            for (int j = 0; j < animals.length; ++j) {
                if (animals[i].equals(animals[j])) {
                    System.out.println(  animals[i] + "\n\tIS EQUAL TO\n" + animals[j]);
                } else {
                    System.out.println(  animals[i] + "\n\tIS NOT EQUAL TO\n" + animals[j]);
                }
                System.out.println("\n-----------------------------------------------" +
                        "----------------------------------");
            }
        }
        Animal puzzle = new Vertebrate("Mountain Zebra", 7, "555621", "Sexual", "Endoskeleton" );
        if (puzzle.equals(animals[0])) {
            System.out.println(puzzle + "\n\tIS EQUAL TO\n" + animals[0]);
        } else {
            System.out.println(puzzle + "\n\tIS NOT EQUAL TO\n" + animals[0]);
        }
        System.out.println();


        if (animals[0].equals(puzzle)) {
            System.out.println(animals[0] + "\n\tIS EQUAL TO\n" + puzzle);
        } else {
            System.out.println(animals[0] + "\n\tIS NOT EQUAL TO\n" + puzzle);
        }
    }
}
