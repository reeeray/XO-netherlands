package shein.grisha.mail.ru.model;

import org.junit.Test;
import shein.grisha.mail.ru.model.exceptions.AlreadyOccupiedException;
import shein.grisha.mail.ru.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception{
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }

//    @Test
//    public void testSetFigureWhenAlreadyOccupied() throws Exception{
//        final Field field = new Field();
//        final Point inputPoint = new Point(0, 0);
//        final Figure inputFigure = Figure.O;
//
//        field.setFigure(inputPoint, inputFigure);
//        try {
//            field.setFigure(inputPoint, inputFigure);
//            fail(); //Will fail test if become to this point
//        }catch (AlreadyOccupiedException e) {}
//    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail(); //Will fail test if become to this point
        }catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(3, 0);

        try {
            field.getFigure(inputPoint);
            fail(); //Will fail test if become to this point
        }catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail(); //Will fail test if become to this point
        }catch (InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 3);

        try {
            field.getFigure(inputPoint);
            fail(); //Will fail test if become to this point
        }catch (InvalidPointException e) {}
    }
}