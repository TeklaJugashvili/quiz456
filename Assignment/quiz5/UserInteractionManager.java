package quiz5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInteractionManager {

    private CommunicationManager communicationManager;
    private List<String> chatHistory;

    public UserInteractionManager() {
        this.communicationManager = new DummyCommunicationManager(); // For testing with dummy data
        this.chatHistory = new ArrayList<>();
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chatbot: Hello! How can I assist you today?");
        while (true) {
            System.out.print("User: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            String response = communicationManager.sendMessage(userInput, chatHistory);
            
            System.out.println("Chatbot: " + response);

            chatHistory.add(userInput);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        UserInteractionManager interactionManager = new UserInteractionManager();
        interactionManager.startChat();
    }
}
