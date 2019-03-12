package shein.grisha.mail.ru.model;

/**
 * Created by Shein G.A. (@reeeray) on 12.03.2019
 **/
public class Game {

    private final Player [] players;

    private final Field fields;

    private final String name;

    public Game(final Player[] players, final Field fields, final String name) {
        this.players = players;
        this.fields = fields;
        this.name = name;
    }
}
