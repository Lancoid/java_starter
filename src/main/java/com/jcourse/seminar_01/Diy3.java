package com.jcourse.seminar_01;

import java.util.*;

/**
 * Реализовать игру "УГАДАЙ ЧИСЛО"
 *
 * Программа загадывает случайное число в пределах [1:100].
 * Задача игрока: отгадать число не более чем за восемь попыток.
 * После каждой поптки программа подсказываает (больше и меньше загаданного числа).
 * При проигрыше программа показывает заданное число.
 * Разделить реализацию пользовательского интерфейса и логику игры (при помощи классов)
 */
public class Diy3 {
    private static GameBox game;
    private static UserPlayer userPlayer;
    static {
        game = new GameBox();
        userPlayer = new UserPlayer();
    }
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("Желаете сыграть в игру \"Угадать число (от 0 до 100)\" (введите \"да\" для продолжения)?: ");
        Scanner scanner = new Scanner(System.in);
        String startAnswer = scanner.next();
        if ("да".equals(startAnswer.toLowerCase())) {
            boolean result;
            do {
                result = Go();
            } while (result);

            System.out.print(
                "Спасибо за игру! Ваш счёт - " +
                    userPlayer.getWinnings() + " побед и " +
                    userPlayer.getLosses() + " поражений"
            );
        } else {
            System.out.print("Жаль...");
        }
    }

    private static boolean Go() {
        Scanner scanner = new Scanner(System.in);
        boolean result = game.letsPlay(scanner);
        if (result) {
            /* зачисляем победу пользователю */
            userPlayer.setWinningsPlusOne();
            System.out.print("Поздравляю с победой!");
        } else {
            /* забираем поражение пользователю */
            userPlayer.setLossesPlusOne();
            System.out.print("Не растраивайтесь...");
        }

        System.out.println("Сыграете ещё раз (введите \"да\" для продолжения)?:");
        String goAnswer = scanner.next();

        return "да".equals(goAnswer);
    }
}

/**
 * The type Game box.
 */
class GameBox {
    /**
     * Lets play.
     *
     * @param scanner the scanner
     *
     * @return the boolean
     */
    boolean letsPlay(Scanner scanner) {
        int inputedNumber;    /* число вводимое пользователем */
        int attemptsNow = 0;  /* число совершённых  попыток   */
        int attemptsMax = 8;  /* число максимальных попыток   */

        /* генерируем загаданное число */
        int hiddenNumber = (int) Math.floor(Math.random() * 100);

        do {
            attemptsNow++;
            System.out.println("Введите ваше число: ");
            try {
                inputedNumber = scanner.nextInt();
                if (inputedNumber > hiddenNumber) {
                    System.out.println("Моё число меньше.");
                } else if (inputedNumber < hiddenNumber) {
                    System.out.println("Моё число больше.");
                } else {
                    System.out.println("Вы угадали!");
                    return true;
                }
            } catch (InputMismatchException error) {
                scanner.next();   /* забираем введённый текст их сканера */
                System.out.println("Вы ввели НЕ число. Минус одна попытка.");
            }
        } while (attemptsNow < attemptsMax);

        System.out.println("Вы проиграли! Загаданное число было: \"" + hiddenNumber + "\"");
        return false;
    }
}

/**
 * The type User player.
 */
class UserPlayer {
    /* число побед пользователя */
    private int winnings = 0;

    /* число проигрышей пользователя */
    private int losses = 0;

    /**
     * Get-method winnings.
     *
     * @return the winnings
     */
    int getWinnings() {
        return winnings;
    }

    /**
     * Get-method losses.
     *
     * @return the losses
     */
    int getLosses() {
        return losses;
    }

    /**
     * Set-method winnings (plus one).
     */
    void setWinningsPlusOne() {
        this.winnings += 1;
    }

    /**
     * Set-method losses (plus one).
     */
    void setLossesPlusOne() {
        this.losses += 1;
    }
}
