package observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();

    String getAction();

    void setAction(String action);
}
