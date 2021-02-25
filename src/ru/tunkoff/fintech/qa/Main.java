package ru.tunkoff.fintech.qa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double fistValue;
        double secondValue;
        String operator;

        Scanner input = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            while (true) {
                System.out.print("Введите первое число:\t");

                if (input.hasNextDouble()) {
                    fistValue = input.nextDouble();
                    break;
                } else {
                    System.out.println("Неверный формат числа! Повторите ввод.");
                    input.next();
                }
            }

            input.nextLine();
            while (true) {
                System.out.print("Введите оператор:\t\t");
                if (input.hasNextLine()) {
                    operator = input.nextLine();
                    if (checkOperator(operator)) {
                        break;
                    } else {
                        System.out.println("Неизвестный оператор! Повторите ввод.");
                    }
                } else {
                    System.out.println("Неизвестный оператор! Повторите ввод.");
                }
            }

            while (true) {
                System.out.print("Введите второе число:\t");

                if (input.hasNextDouble()) {
                    secondValue = input.nextDouble();
                    break;
                } else {
                    System.out.println("Неверный формат числа! Повторите ввод.");
                    input.next();
                }
            }

            calculate(fistValue, operator, secondValue);

            System.out.print("Выйти из программы? (Для выхода введите \"да\" / \"yes\"):\t");
            input.nextLine();
            if (checkExit(input)) {
                input.close();
                return;
            } else {
                System.out.println("");
                input.nextLine();
            }
        }
    }

    private static boolean checkOperator(String operator) {
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    private static void calculate(double fistValue, String operator, double secondValue) {
        double result;
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();

        operator = operator.replace(" ", "");
        switch (operator) {
            case "+":
                result = addition.execute(fistValue, secondValue);
                break;
            case "-":
                result = subtraction.execute(fistValue, secondValue);
                break;
            case "*":
                result = multiplication.execute(fistValue, secondValue);
                break;
            case "/":
                result = division.execute(fistValue, secondValue);
                break;
            default:
                result = 0;
                break;
        }
        if (Double.isInfinite(result)) {
            System.out.println("Результат лежит вне диапазона возможных значений или стремится в бесконечность.\n");
        } else {
            System.out.println(fistValue + " " + operator + " " + secondValue + " = " + result + "\n");
        }
    }

    private static boolean checkExit(Scanner scanner) {
        return scanner.hasNext("Yes")
                || scanner.hasNext("yes")
                || scanner.hasNext("YES")
                || scanner.hasNext("Да")
                || scanner.hasNext("да")
                || scanner.hasNext("ДА");
    }
}
