package thrones.factories;

import java.util.Random;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;
import thrones.characters.plastic.PlasticDragon;
import thrones.characters.plastic.PlasticKing;
import thrones.characters.plastic.PlasticKnight;
import thrones.characters.plastic.PlasticQueen;

public class PlasticFactory implements CharacterFactory {

    private Random r = new Random();
    
    @Override
    public King createKing() {
        return new PlasticKing(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Queen createQueen() {
        return new PlasticQueen(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Knight createKnight() {
        return new PlasticKnight(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Dragon createDragon() {
        return new PlasticDragon(r.nextInt(0, 10), 0);
    }
    
}
