package shein.grisha.mail.ru.controller;

import shein.grisha.mail.ru.model.Field;
import shein.grisha.mail.ru.model.Figure;
import shein.grisha.mail.ru.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Shein G.A. (@reeeray) on 25.03.2019
 **/
public class CurrentMoveController {

    public Figure currentMove(final Field field) {
//        int countX = 0;
//        int countO = 0;
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            countFigure += countFiguresInTheRow(field, x);
//            for (int y=0; y<field.getSize(); y++) {
//                try {
//                    if(field.getFigure(new Point(x, y)) != null) countFigure++;
////                    switch (field.getFigure(new Point(x, y))) {
////                        case X:
////                            countX++;
////                            break;
////                        case O:
////                            countO++;
////                            break;
////                    }
//                } catch (final InvalidPointException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        if (countFigure == field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int countFigure = 0;
        for (int y = 0; y < field.getSize(); y++) {
            try {
                if (field.getFigure(new Point(row, y)) != null) countFigure++;
            } catch (final InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}
