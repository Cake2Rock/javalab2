public class TextProcessor {
    public static void main(String[] args) {
        try {
            String inputText = "Hello world! This is a test sentence. How are you today?";
            System.out.println("Original Text:");
            System.out.println(inputText);
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }
}
