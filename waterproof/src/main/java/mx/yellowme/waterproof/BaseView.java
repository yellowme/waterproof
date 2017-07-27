package mx.yellowme.waterproof;

public interface BaseView {
    void setProgressIndicator(boolean active);

    void display(String message);

    void display(String message, MessageAction action);

    interface MessageAction {
        void execute();
        String getTitle();
    }
}
