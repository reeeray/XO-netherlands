package shein.grisha.mail.ru.controller;

import shein.grisha.mail.ru.model.Field;
import shein.grisha.mail.ru.model.Figure;
import shein.grisha.mail.ru.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Shein G.A. (@reeeray) on 12.03.2019
 **/
public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i, 0));
            }
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), new IPointGenerator() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1, point.y);
                    }
                }))
                    return field.getFigure(new Point(0, i));
            }
            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(1, 1));
            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1, 1));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(Point point);
    }
}
