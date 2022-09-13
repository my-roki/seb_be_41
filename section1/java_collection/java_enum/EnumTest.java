package section1.java_collection.java_enum;

enum EnumLevel {
    LOW, MEDIUM, HIGH
}

public class EnumTest {
    public static void main(String[] args) {
        EnumLevel level = EnumLevel.MEDIUM;

        EnumLevel[] allEnumLevels = EnumLevel.values();
        for (EnumLevel x : allEnumLevels) {
            System.out.printf("%s=%d%n", x.name(), x.ordinal());
        }

        System.out.println("");

        EnumLevel findEnumLevel = EnumLevel.valueOf("LOW");
        System.out.println(findEnumLevel);
        System.out.println(EnumLevel.LOW == EnumLevel.valueOf("LOW"));

        System.out.println("");

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
