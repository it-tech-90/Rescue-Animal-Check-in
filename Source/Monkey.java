public class Monkey extends RescueAnimal {

    // Monkey-specific variables
    private String species;
    private float tailLength; // Measured in inches
    private float bodyLength; // Measured in inches
    private float height; // Measured in inches

    // Monkey class constructor
    public Monkey(String species, float tailLength, float height, float bodyLength) {
        this.species = species;
        this.tailLength = tailLength;
        this.bodyLength = bodyLength;
        this.height = height;
    }

    // Getter and setter methods for Monkey-specific attributes
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        // Ensuring the species is one of the approved types
        if (species.equalsIgnoreCase("Capuchin") || species.equalsIgnoreCase("Guenon") ||
                species.equalsIgnoreCase("Macaque") || species.equalsIgnoreCase("Marmoset") ||
                species.equalsIgnoreCase("Squirrel monkey") || species.equalsIgnoreCase("Tamarin")) {
            this.species = species;
        } else {
            System.out.println("Invalid species. Please enter a valid species.");
        }
    }

    public float getTailLength() {
        return tailLength;
    }

    public void setTailLength(float tailLength) {
        this.tailLength = tailLength;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(float bodyLength) {
        this.bodyLength = bodyLength;
    }

}
