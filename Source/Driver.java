import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // For monkeys

    // Instance variables (if needed)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals()
        // method.

        // Main menu loop
        String choice = "";
        while (!choice.equalsIgnoreCase("q")) {
            displayMenu();
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }

        scanner.close();

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
                "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    // Optional for testing
    public static void initializeMonkeyList() {

    }

    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list

        // Get other details for the dog
        System.out.println("Enter breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter age:");
        String age = scanner.nextLine();
        System.out.println("Enter weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter acquisition date:");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter training status:");
        String trainingStatus = scanner.nextLine();

        // Create new dog and add to list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                false, "United States");
        dogList.add(newDog);
        System.out.println("Dog added successfully.");
    }

    // Complete intakeNewMonkey
    // Instantiate and add the new monkey to the appropriate list
    // For the project submission you must also validate the input
    // to make sure the monkey doesn't already exist and the species type is allowed
    public static void intakeNewMonkey(Scanner scanner) {
        // System.out.println("The method intakeNewMonkey needs to be implemented");

        System.out.println("Enter the monkey's name:");
        String name = scanner.nextLine();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("This monkey is already in the system.");
                return;
            }
        }

        // Get other details from user
        System.out.println("Enter species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin):");
        String species = scanner.nextLine();
        if (!isValidMonkeySpecies(species)) {
            System.out.println("Invalid species entered.");
            return;
        }
        System.out.println("Enter tail length:");
        float tailLength = scanner.nextFloat();
        System.out.println("Enter height:");
        float height = scanner.nextFloat();
        System.out.println("Enter body length:");
        float bodyLength = scanner.nextFloat();
        scanner.nextLine(); // Consume leftover newline

        // Create new monkey and add to list
        Monkey newMonkey = new Monkey(species, tailLength, height, bodyLength);
        monkeyList.add(newMonkey);
        System.out.println("Monkey added successfully.");

    }

    // Complete reserveAnimal
    // You will need to find the animal by animal type and in service country
    public static void reserveAnimal(Scanner scanner) {
        // System.out.println("The method reserveAnimal needs to be implemented");

        System.out.println("Enter animal type (dog/monkey):");
        String animalType = scanner.nextLine();
        System.out.println("Enter service country:");
        String country = scanner.nextLine();

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(country) && !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println("Dog reserved successfully.");
                    return;
                }
            }
        } else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(country) && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println("Monkey reserved successfully.");
                    return;
                }
            }
        }
        System.out.println("No available animal found.");

    }

    // Complete printAnimals
    // Include the animal name, status, acquisition country and if the animal is
    // reserved.
    // Remember that this method connects to three different menu items.
    // The printAnimals() method has three different outputs
    // based on the listType parameter
    // dog - prints the list of dogs
    // monkey - prints the list of monkeys
    // available - prints a combined list of all animals that are
    // fully trained ("in service") but not reserved
    // Remember that you only have to fully implement ONE of these lists.
    // The other lists can have a print statement saying "This option needs to be
    // implemented".
    // To score "exemplary" you must correctly implement the "available" list.
    public static void printAnimals(String listType) {
        // System.out.println("The method printAnimals needs to be implemented");

        // Print animals based on list type using a switch to determine which list to
        // print
        switch (listType) {
            case "dog":
                for (Dog dog : dogList) {
                    System.out.println(dog.getName() + ", " + dog.getTrainingStatus() + ", "
                            + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
                }
                break;
            case "monkey":
                for (Monkey monkey : monkeyList) {
                    System.out.println(monkey.getName() + ", " + monkey.getTrainingStatus() + ", "
                            + monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved());
                }
                break;
            case "available":
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equals("in service") && !dog.getReserved()) {
                        System.out.println(
                                dog.getName() + ", " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation());
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equals("in service") && !monkey.getReserved()) {
                        System.out.println(monkey.getName() + ", " + monkey.getTrainingStatus() + ", "
                                + monkey.getAcquisitionLocation());
                    }
                }
                break;
            default:
                System.out.println("Invalid list type.");
        }

    }

    // Method to validate monkey species
    public static boolean isValidMonkeySpecies(String species) {
        return species.equalsIgnoreCase("Capuchin") || species.equalsIgnoreCase("Guenon") ||
                species.equalsIgnoreCase("Macaque") || species.equalsIgnoreCase("Marmoset") ||
                species.equalsIgnoreCase("Squirrel monkey") || species.equalsIgnoreCase("Tamarin");
    }
}
