import java.util.*;
import java.io.*;
import java.util.logging.Logger;

public class LegacyApp {
    private static final Logger logger = Logger.getLogger(LegacyApp.class.getName());

    public static void main(String[] args) {
        String state = "invalid";

        printToConsole("Welcome to the Legacy Application!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        String command = scanner.nextLine();

        if (command.equals("process")) {
            File file = new File("input.txt");
            processCommand(file);
        } else if (command.equals("report")) {
        ReportGenerator generator = new ReportGenerator();
            generateReport(generator);
        } else {
            // Code Smell: Condiciones ineficaces
            if (command.length() > 0) {
                printToConsole("Unrecognized command.");
            }
        }

        fragileMethod(state);
        unusedMethod();
        complexMethod();
        spaghettiCode();
        riskyMethod(0);
        handleInput();
        methodWithTooManyParams(new String[] {"param1 ", "param2 ", "param3 "});
        performLongOperation();

        // Code Smell: Método con múltiples responsabilidades
        ResourceManager manager = new ResourceManager();
        manageResourcesAndCleanup(manager, manager);

        printToConsole("This is a redundant operation.");
    }

    private static void printToConsole(String message) {
        System.out.println(message);
    }

    // Code Smell: Método demasiado largo
    private static void performLongOperation() {
        printToConsole("Starting long operation...");

        for (int i = 0; i < 100; i++) {
            printToConsole("Processing step " + i);
        }

        printToConsole("Long operation completed.");
    }

    // Code Smell: Dependencia cíclica (entre clases)
    private static void processCommand(File file) {
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    printToConsole("File created successfully: " + file.getName());
                } else {
                    printToConsole("File already exists: " + file.getName());
                }
            }

            String data = readFile(file);
            writeToFile(data);
        } catch (IOException e) {
            printToConsole("Error during file operations.");
        }
    }

    // Code Smell: Jerarquía de herencia demasiado profunda
    private static String readFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    private static void writeToFile(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));) {
            writer.write(data);
        }
    }

    private static void generateReport(ReportGenerator generator) {
        generator.createReport();
    }

    private static void unusedMethod() {
        printToConsole("This method does nothing.");
    }

    interface Initializer {
        void initialize();
    }

    interface Cleaner {
        void cleanup();
    }

    static class ResourceManager implements Initializer, Cleaner {
        @Override
        public void initialize() {
            // Lógica de inicialización
        }

        @Override
        public void cleanup() {
            // Lógica de limpieza
        }
    }

    private static void manageResourcesAndCleanup(Initializer initializer, Cleaner cleaner) {
        initializer.initialize();
        cleaner.cleanup();
    }

    private static void printEvenNumber() {
        printToConsole("Even number");
    }

    private static void printMultipleOfThree() {
        printToConsole("Multiple of 3");
    }

    private static void printOtherNumber() {
        printToConsole("Other number");
    }

    private static void spaghettiCode() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                printEvenNumber();
            } else if (i % 3 == 0) {
                printMultipleOfThree();
            } else {
                printOtherNumber();
            }
        }
    }

    private static void methodWithTooManyParams(String[] params) {
        StringBuilder result = new StringBuilder();
        for (String param : params) {
            result.append(param);
        }
        printToConsole(result.toString());
    }

    private static void riskyMethod(int divisor) {
        try {
            if (divisor == 0) {
                throw new ArithmeticException("Divisor cannot be zero");
            }
            int result = 10 / divisor;

            printToConsole("Result: " + result);
        } catch (ArithmeticException e) {
            logger.severe(e.getMessage());
        }
    }

    private static void processNumbers() {
        printToConsole("Complex logic begins");
        for (int i = 0; i < 10; i++) {
            printToConsole("Processing number: " + i);
        }
    }

    private static void generateComplexReport() {
        printToConsole("Reporting results...");
        String report = "Report data";
        printToConsole(report);
    }

    private static void complexMethod() {
        processNumbers();
        generateComplexReport();
    }

    static class ReportGenerator {
        void createReport() {
            printToConsole("Report created.");
        }
    }

    private static void fragileMethod(String state) {
        if (state.equals("invalid")) {
            printToConsole("State is invalid.");
        }
    }

    private static void handleInput() {
        processInput("");
    }

    private static void processInput(String input) {
        if (input.isEmpty()) {
            printToConsole("Empty input");
        } else {
            switch (input) {
                case "1":
                    handleOption1();
                    break;
                case "2":
                    handleOption2();
                    break;
                default:
                    printToConsole("Unknown option");
            }
        }
    }

    private static void handleOption1() {
        printToConsole("Option 1 selected");
    }

    private static void handleOption2() {
        printToConsole("Option 2 selected");
    }
}
