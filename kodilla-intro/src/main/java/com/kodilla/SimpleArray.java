public class SimpleArray {
    public static void main(String[] args) {

        String[] knowledgeSources = {"Books", "Internet", "Podcasts", "Experience", "Other people"};

        int numberOfElements = knowledgeSources.length;

        System.out.println("Moja tablica zawiera " + numberOfElements + " elementów");

        String selectedKnowledgeSource = knowledgeSources[3];

        System.out.println(selectedKnowledgeSource);
    }
}