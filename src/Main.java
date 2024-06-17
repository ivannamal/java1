import java.util.HashMap;
import java.util.Map;

class CorrectClass {
    private int id;
    private String name;

    public CorrectClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectClass that = (CorrectClass) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + name.hashCode();
        return result;
    }
}

class IncorrectClass {
    private int id;
    private String name;

    public IncorrectClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<CorrectClass, String> correctMap = new HashMap<>();
        CorrectClass correct1 = new CorrectClass(1, "Alice");
        CorrectClass correct2 = new CorrectClass(2, "Bob");
        correctMap.put(correct1, "Correct Alice");
        correctMap.put(correct2, "Correct Bob");

        System.out.println("CorrectClass Map:");
        correctMap.forEach((key, value) -> System.out.println(key.hashCode() + ": " + value));

        Map<IncorrectClass, String> incorrectMap = new HashMap<>();
        IncorrectClass incorrect1 = new IncorrectClass(1, "Alice");
        IncorrectClass incorrect2 = new IncorrectClass(2, "Bob");
        incorrectMap.put(incorrect1, "Incorrect Alice");
        incorrectMap.put(incorrect2, "Incorrect Bob");

        System.out.println("\nIncorrectClass Map:");
        incorrectMap.forEach((key, value) -> System.out.println(key.hashCode() + ": " + value));
    }
}
