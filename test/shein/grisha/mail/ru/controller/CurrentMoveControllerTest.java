package shein.grisha.mail.ru.controller;

import org.junit.Test;
import shein.grisha.mail.ru.model.Field;
import shein.grisha.mail.ru.model.Figure;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Shein G.A. (@reeeray) on 25.03.2019
 **/
public class CurrentMoveControllerTest {

    @Test
    public void testcurrentMoveWhenNextMoveIsY() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testcurrentMoveWhenNextMoveIsX() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void testcurrentMoveWhenNoNextMove() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(1, 2), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        assertNull(currentMoveController.currentMove(field));
    }
}