package quiz5;

import java.util.List;

public interface CommunicationManager {

    String sendMessage(String message, List<String> chatHistory);
}
