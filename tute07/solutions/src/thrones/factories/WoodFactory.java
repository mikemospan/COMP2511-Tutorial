package thrones.factories;

import java.util.Random;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;
import thrones.characters.wood.WoodDragon;
import thrones.characters.wood.WoodKing;
import thrones.characters.wood.WoodKnight;
import thrones.characters.wood.WoodQueen;

public class WoodFactory implements CharacterFactory {

    private Random r = new Random();

    @Override
    public King createKing() {
        return new WoodKing(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Queen createQueen() {
        return new WoodQueen(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Knight createKnight() {
        return new WoodKnight(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Dragon createDragon() {
        return new WoodDragon(r.nextInt(0, 10), 0);
    }
}