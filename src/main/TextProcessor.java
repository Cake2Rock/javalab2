public class TextProcessor {
    public static void main(String[] args) {
        try {
            String inputText = "Hello world! This is a test sentence. How are you today?";
            StringBuilder processedText = processText(new StringBuilder(inputText));
            System.out.println("Original Text:");
            System.out.println(inputText);
            System.out.println("Processed Text:");
            System.out.println(processedText.toString());
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }

    private static StringBuilder processText(StringBuilder text) {
        String[] sentences = text.toString().split("(?<=[.!?])\\s*");
        StringBuilder result = new StringBuilder();
        for (String sentence : sentences) {
            result.append(swapFirstAndLastWord(sentence)).append(" ");
        }
        return result;
    }

    private static StringBuilder swapFirstAndLastWord(String sentence) {
        StringBuilder sentenceBuilder = new StringBuilder(sentence.trim());
        String[] words = sentenceBuilder.toString().split("\\s+");

        if (words.length > 1) {
            String firstWord = words[0].replaceAll("[.!?]", "");
            String lastWord = words[words.length - 1].replaceAll("[.!?]", "");

            words[0] = lastWord;
            words[words.length - 1] = firstWord;
        }

        StringBuilder modifiedSentence = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            modifiedSentence.append(words[i]);
            if (i < words.length - 1) {
                modifiedSentence.append(" ");
            }
        }

        if (sentence.endsWith(".") || sentence.endsWith("!") || sentence.endsWith("?")) {
            modifiedSentence.append(sentence.charAt(sentence.length() - 1));
        }

        return new StringBuilder(modifiedSentence.toString().trim());
    }
}
