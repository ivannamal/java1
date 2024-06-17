import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    public static void main(String[] args) throws IOException {
        BufferedWriter file = new BufferedWriter(new FileWriter("results.txt", true));
        file.write("\n"+"Maps:" + "\n");

        Map<CorrectClass, String> correctMap = new HashMap<>();
        CorrectClass correct1 = new CorrectClass(1, "name1");
        CorrectClass correct2 = new CorrectClass(2, "name2");
        correctMap.put(correct1, "Correct name1");
        correctMap.put(correct2, "Correct name2");

        System.out.println("\nCorrectClass Map:" +"\n");
        file.write("\nCorrectClass Map:" + "\n");
        correctMap.forEach((key, value) -> System.out.println(key.hashCode() + ": " + value));
        correctMap.forEach((key, value) -> {
            try {
                file.write(key.hashCode() + ": " + value +"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

                Map<IncorrectClass, String> incorrectMap = new HashMap<>();
        IncorrectClass incorrect1 = new IncorrectClass(1, "name1");
        IncorrectClass incorrect2 = new IncorrectClass(2, "name2");
        incorrectMap.put(incorrect1, "Incorrect name1");
        incorrectMap.put(incorrect2, "Incorrect name2");

        System.out.println("\nIncorrectClass Map:" +"\n");
        file.write("\nIncorrectClass Map:" + "\n");
        incorrectMap.forEach((key, value) -> System.out.println(key.hashCode() + ": " + value));
        incorrectMap.forEach((key, value) -> {
            try {
                file.write(key.hashCode() + ": " + value +"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        file.close();
    }
}
