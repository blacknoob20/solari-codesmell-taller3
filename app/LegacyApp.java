import java.util.*;
import java.io.*;

public class LegacyApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Legacy Application!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command: ");
        String command = scanner.nextLine();

        if (command.equals("process")) {
            processCommand();
        } else if (command.equals("report")) {
            generateReport();
        } else {
            // Code Smell: Condiciones ineficaces
            if (command.length() > 0) {
                System.out.println("Unrecognized command.");
            }
        }

        // Code Smell: Método demasiado largo
        performLongOperation();

        // Code Smell: Método con múltiples responsabilidades
        manageResourcesAndCleanup();

        // Code Smell: Lógica redundante
        for (int i = 0; i < 5; i++) {
            System.out.println("This is a redundant operation.");
        }

        // Code Smell: Lógica especulativa
        System.out.println("Preparing for future features...");
    }

    // Code Smell: Método demasiado largo
    private static void performLongOperation() {
        System.out.println("Starting long operation...");

        for (int i = 0; i < 100; i++) {
            System.out.println("Processing step " + i);
        }

        // Code Smell: Redundancia
        System.out.println("Processing step 1");
        System.out.println("Processing step 1");

        System.out.println("Long operation completed.");
    }

    // Code Smell: Dependencia cíclica (entre clases)
    private static void processCommand() {
        try {
            File file = new File("input.txt");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File created successfully: " + file.getName());
                } else {
                    System.out.println("File already exists: " + file.getName());
                }
            }

            String data = readFile(file);
            writeToFile(data);
        } catch (IOException e) {
            System.out.println("Error during file operations.");
        }
    }

    // Code Smell: Jerarquía de herencia demasiado profunda
    private static String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        return content.toString();
    }

    private static void writeToFile(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(data);
        writer.close();
    }

    // Code Smell: Abuso de instanciación directa
    private static void generateReport() {
        ReportGenerator generator = new ReportGenerator();
        generator.createReport();
    }

    // Code Smell: Código no utilizado (métodos no utilizados)
    private static void unusedMethod() {
        System.out.println("This method does nothing.");
    }

    // Code Smell: Variables innecesarias
    private static int unusedResult = 0;

    // Code Smell: Dependencias no necesarias (clase que hace todo)
    private static void manageResourcesAndCleanup() {
        ResourceManager manager = new ResourceManager();
        manager.initialize();
        manager.cleanup();
    }

    // Code Smell: Código frágil (dependencia a estado global)
    private static void fragileMethod() {
        String state = globalState();
        if (state.equals("invalid")) {
            System.out.println("State is invalid.");
        }
    }

    // Code Smell: Método innecesariamente público
    public static void unnecessaryPublicMethod() {
        System.out.println("This method is public, but it is not needed.");
    }

    // Code Smell: Spaghetti code (flujos de control complejos)
    private static void spaghettiCode() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Even number");
            } else if (i % 3 == 0) {
                System.out.println("Multiple of 3");
            } else {
                System.out.println("Other number");
            }
        }
    }

    // Code Smell: Métodos con demasiados parámetros
    private static void methodWithTooManyParams(String param1, String param2, String param3, String param4, String param5) {
        System.out.println(param1 + param2 + param3 + param4 + param5);
    }

    // Code Smell: Variables no inicializadas
    private static String uninitializedVariable;

    // Code Smell: Excepciones no manejadas correctamente
    private static void riskyMethod() {
        try {
            int result = 10 / 0; // División por cero
        } catch (ArithmeticException e) {
            // Error no tratado correctamente
            System.out.println("Division error occurred, but no recovery.");
        }
    }

    // Code Smell: Método con lógica compleja (Doble responsabilidad)
    private static void complexMethod() {
        System.out.println("Complex logic begins");

        for (int i = 0; i < 10; i++) {
            System.out.println("Processing number: " + i);
        }

        System.out.println("Reporting results...");
        // Report generation logic
        String report = "Report data";
        System.out.println(report);
    }

    // Clase de ejemplo con Abuso de Instanciación Directa
    static class ReportGenerator {
        void createReport() {
            System.out.println("Report created.");
        }
    }

    // Code Smell: Clase de recursos innecesaria
    static class ResourceManager {
        void initialize() {
            System.out.println("Resources initialized.");
        }

        void cleanup() {
            System.out.println("Resources cleaned up.");
        }
    }

    // Code Smell: Código frágil y dependencias globales
    private static String globalState() {
        return "invalid";
    }

    // Code Smell: Método de entrada largo y complejo
    private static void complexInputProcessing() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Empty input");
        } else {
            if (input.equals("1")) {
                System.out.println("Option 1 selected");
            } else if (input.equals("2")) {
                System.out.println("Option 2 selected");
            } else {
                System.out.println("Unknown option");
            }
        }
    }
}
