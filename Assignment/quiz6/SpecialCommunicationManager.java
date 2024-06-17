package quiz6;

import java.util.List;

import quiz5.CommunicationManager;

public class SpecialCommunicationManager implements CommunicationManager {

    private String commonServiceUrl;
    private String specialServiceUrl;

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
    }

    @Override
    public String sendMessage(String message, List<String> chatHistory) {
        boolean useSpecialService = containsHelpMessage(message) || containsHelpMessageInHistory(chatHistory);

        String serviceUrl = useSpecialService ? specialServiceUrl : commonServiceUrl;

        String response = sendRequestToService(serviceUrl, message, chatHistory);

        return response;
    }

    private boolean containsHelpMessage(String message) {
        return message.toLowerCase().contains("help");
    }

    private boolean containsHelpMessageInHistory(List<String> chatHistory) {
        for (String pastMessage : chatHistory) {
            if (containsHelpMessage(pastMessage)) {
                return true;
            }
        }
        return false;
    }

    private String sendRequestToService(String serviceUrl, String message, List<String> chatHistory) {
        String response = "Response from " + serviceUrl + " for message: " + message;
        return response;
    }
}
