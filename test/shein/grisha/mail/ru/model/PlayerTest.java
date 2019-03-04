package shein.grisha.mail.ru.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String inputValue = "Grisha";
        final String expectedValue = inputValue;
        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;
        final Player player = new Player(null, Figure.X);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }
}