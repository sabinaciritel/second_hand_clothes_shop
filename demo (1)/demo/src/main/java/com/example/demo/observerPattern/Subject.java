package com.example.demo.observerPattern;
/**
 * The Subject interface is a key component of the Observer design pattern.
 * It outlines the methods necessary for attaching, detaching, and notifying observers.
 * Implementations of this interface maintain a list of observers and notify them of state changes
 * or other significant events by calling their {@code update()} method.
 */
public interface Subject {
    /**
     * Attaches an observer to the subject. This method adds the given observer to the subject's
     * list of observers, allowing it to receive updates.
     *
     * @param o The observer to be added to the list of observers. Must not be {@code null}.
     */
    void addObserver(Observer o);
    /**
     * Detaches an observer from the subject. This method removes the given observer from the subject's
     * list of observers, stopping it from receiving further updates.
     *
     * @param o The observer to be removed from the list of observers. Must not be {@code null}.
     */
    void removeObserver(Observer o);
    /**
     * Notifies all attached observers of a state change or event. This method calls the {@code update()}
     * method on all observers in the list, allowing them to react to changes in the subject.
     */
    void notifyObservers();
}
