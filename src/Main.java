import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            System.out.println("------------------------------------------");
            printMenu();
            System.out.println("------------------------------------------");
            System.out.println("Ваш выбор:");
            int userInput;
            try {
                userInput = scanner.nextInt();
                if (userInput == 1) {
                    System.out.println("Введите номер месяца (1-12):");
                    int monthInput = scanner.nextInt();
                    while (monthInput < 1 || monthInput > 12) {
                        System.out.println("Введено неверное значение! Повторите ввод:");
                        monthInput = scanner.nextInt();
                    }
                    System.out.println("Введите день (1-30):");
                    int dayInput = scanner.nextInt();
                    while (dayInput < 1 || dayInput > 30) {
                        System.out.println("Введено неверное значение! Повторите ввод:");
                        dayInput = scanner.nextInt();
                    }
                    System.out.println("Введите количество шагов:");
                    int stepsInput = scanner.nextInt();
                    while (stepsInput < 0) {
                        System.out.println("Введено неверное значение! Повторите ввод:");
                        stepsInput = scanner.nextInt();
                    }
                    stepTracker.daysAndSteps(monthInput, dayInput, stepsInput);
                } else if (userInput == 2) {
                    System.out.println("За какой месяц напечатать статистику?");
                    int monthInput = scanner.nextInt();
                    while (monthInput < 1 || monthInput > 12) {
                        System.out.println("Введено неверное значение! Повторите ввод:");
                        monthInput = scanner.nextInt();
                    }
                    stepTracker.monthStatistic(monthInput);
                } else if (userInput == 3) {
                    System.out.println("Текущая цель: " + stepTracker.yourGoal);
                    System.out.println("Введите новую цель:");
                    int newGoalInput = scanner.nextInt();
                    while (newGoalInput < 0) {
                        System.out.println("Введено неверное значение! Повторите ввод:");
                        newGoalInput = scanner.nextInt();
                    }
                    stepTracker.yourGoal=newGoalInput;
                    System.out.println("Новая цель: " + stepTracker.yourGoal);
                } else if (userInput == 0) {
                    System.out.println("Завершение работы.");
                    break;
                } else {
                    System.out.println("Введена неверная команда. Повторите выбор!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введено недопустимое значение! Завершение работы.");
                return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите необходимое действие:");
        System.out.println("1-Ввести количество шагов за определенный день;");
        System.out.println("2-Напечатать статистику за определенный месяц;");
        System.out.println("3-Изменить цель по количеству шагов в день;");
        System.out.println("0-Выйти из приложения.");
    }
}