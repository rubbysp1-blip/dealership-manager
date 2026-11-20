package com.pluralsight.dealershipmanager;

import com.pluralsight.dealershipmanager.ui.UserInterface;

public class App {
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();

        userInterface.display();

        userInterface.closeScanner();
    }
}
