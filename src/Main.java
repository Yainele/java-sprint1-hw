import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int month;
        int dayOfMonth;
        int steps;

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

                 if(userInput == 1){
                     System.out.println("Введите номер месяца (от 0 до 11): ");
                     month = scanner.nextInt();
                     System.out.println("Введите номер дня (от 1 до 30): ");
                     dayOfMonth = scanner.nextInt();
                     System.out.println("Введите количество шагов: ");
                     steps = scanner.nextInt();
                     stepTracker.enterSteps(month,dayOfMonth,steps);
            }
            else if(userInput == 2){
                System.out.println("Введите номер месяца (от 0 до 11): ");
                 month = scanner.nextInt();
                 stepTracker.printStatistic(month);
            }
            else if(userInput == 3){
                System.out.println("Введите новую цель по количеству шагов в день:");
                int newStepGoal = scanner.nextInt();
                stepTracker.changeStepGoal(newStepGoal);
            }
            else if(userInput == 4){
                break;
            }
            else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

        System.out.println("Программа завершена");
    }

    private static void printMenu() {
            System.out.println("1. Ввести количество шагов за определённый день;" +
                    "\n2. Напечатать статистику за определённый месяц;" +
                    "\n3. Изменить цель по количеству шагов в день;" +
                    "\n4. Выйти из приложения.");
    }
}