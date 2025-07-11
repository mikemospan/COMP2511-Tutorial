package thrones.factories;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;

public interface CharacterFactory {
    public King createKing();
    public Queen createQueen();
    public Knight createKnight();
    public Dragon createDragon();
}
