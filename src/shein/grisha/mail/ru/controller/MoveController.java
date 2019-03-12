package shein.grisha.mail.ru.controller;

import shein.grisha.mail.ru.model.Field;
import shein.grisha.mail.ru.model.Figure;
import shein.grisha.mail.ru.model.exceptions.AlreadyOccupiedException;
import shein.grisha.mail.ru.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Shein G.A. (@reeeray) on 12.03.2019
 **/
public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupiedException, InvalidPointException {

        if(field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }
}
