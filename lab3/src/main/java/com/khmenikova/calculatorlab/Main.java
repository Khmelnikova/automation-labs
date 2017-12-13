package com.khmelnikova.calculatorlab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String string = scanner.nextLine();
        
        
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(string));
    }
}