package quiz5;

import java.util.List;

public class DummyCommunicationManager implements CommunicationManager {

    @Override
    public String sendMessage(String message, List<String> chatHistory) {
        String response = "Dummy response for: " + message;
        return response;
    }
}
