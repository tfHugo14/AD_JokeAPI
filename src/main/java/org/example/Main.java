package org.example;

import org.example.App.JokeDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JokeDAO jk = new JokeDAO();

        System.out.println("Que tipo de broma quieres ( Programming | Miscellaneous | Dark | Pun | Spooky | Christmas ): ");
        String category = sc.nextLine();
        System.out.println(jk.getJokeByCategory(category));
    }
}