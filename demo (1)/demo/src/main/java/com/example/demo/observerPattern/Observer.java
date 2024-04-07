package com.example.demo.observerPattern;
/**
 * The Observer interface is part of the Observer design pattern.
 * It defines the method that observers must implement to receive updates from the subject they are observing.
 * This pattern is used to achieve a low-coupling, maintainable code structure where objects can interact
 * without being tightly bound to each other.
 */
public interface Observer {
    /**
     * Updates the observer with information from the subject it is observing.
     * This method is called by the subject on all its observers when there is a state change.
     */
    void update();
}
