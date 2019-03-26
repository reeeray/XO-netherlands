package shein.grisha.mail.ru;

import shein.grisha.mail.ru.model.Field;
import shein.grisha.mail.ru.model.Figure;
import shein.grisha.mail.ru.model.Game;
import shein.grisha.mail.ru.model.Player;
import shein.grisha.mail.ru.view.ConsoleView;

/**
 * Created by Shein G.A. (@reeeray) on 27.03.2019
 **/
public class XOCLI {

    public static void main(String[] args) {
        final String name1 = "Grisha";
        final String name2 = "Nikolai";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}
