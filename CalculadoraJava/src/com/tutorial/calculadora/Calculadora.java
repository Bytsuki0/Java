package com.tutorial.calculadora;

import java.util.Scanner;

/**
 * Classe Calculadora - Exemplo para tutorial de GitHub
 * Implementa operações básicas de uma calculadora
 */
public class Calculadora {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Calculadora Java ===");
        System.out.println("Escolha uma operação:");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.print("Opção: ");
        
        int opcao = scanner.nextInt();
        
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        
        double resultado = 0;
        
        switch (opcao) {
            case 1:
                resultado = adicionar(num1, num2);
                System.out.println("Resultado da adição: " + resultado);
                break;
            case 2:
                resultado = subtrair(num1, num2);
                System.out.println("Resultado da subtração: " + resultado);
                break;
            case 3:
                resultado = multiplicar(num1, num2);
                System.out.println("Resultado da multiplicação: " + resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = dividir(num1, num2);
                    System.out.println("Resultado da divisão: " + resultado);
                } else {
                    System.out.println("Erro: Divisão por zero!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
        
        scanner.close();
    }
    
    /**
     * Realiza a adição de dois números
     */
    public static double adicionar(double a, double b) {
        return a + b;
    }
    
    /**
     * Realiza a subtração de dois números
     */
    public static double subtrair(double a, double b) {
        return a - b;
    }
    
    /**
     * Realiza a multiplicação de dois números
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    
    /**
     * Realiza a divisão de dois números
     */
    public static double dividir(double a, double b) {
        return a / b;
    }
}