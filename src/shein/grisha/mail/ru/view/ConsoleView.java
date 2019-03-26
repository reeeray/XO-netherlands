package shein.grisha.mail.ru.view;

import shein.grisha.mail.ru.controller.CurrentMoveController;
import shein.grisha.mail.ru.controller.MoveController;
import shein.grisha.mail.ru.controller.WinnerController;
import shein.grisha.mail.ru.model.Field;
import shein.grisha.mail.ru.model.Figure;
import shein.grisha.mail.ru.model.Game;
import shein.grisha.mail.ru.model.exceptions.AlreadyOccupiedException;
import shein.grisha.mail.ru.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Shein G.A. (@reeeray) on 26.03.2019
 **/
public class ConsoleView {

    final private CurrentMoveController currentMoveController = new CurrentMoveController();

    final private WinnerController winnerController = new WinnerController();

    final private MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
        printSeparator();
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currenFigure = currentMoveController.currentMove(field);
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        if (currenFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currenFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currenFigure);
        } catch (AlreadyOccupiedException e) {
            e.printStackTrace();
        } catch (InvalidPointException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Incorrect format!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }
}
