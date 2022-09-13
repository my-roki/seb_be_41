package section1.java_collection.java_enum;

enum MainLevel {
    LOW, MEDIUM, HIGH
}

public class Main {
    public static void main(String[] args) {
        MainLevel level = MainLevel.MEDIUM;
        switch (level) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
    }
}
