package thrones.factories;

import java.util.Random;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;
import thrones.characters.metal.MetalDragon;
import thrones.characters.metal.MetalKing;
import thrones.characters.metal.MetalKnight;
import thrones.characters.metal.MetalQueen;

public class MetalFactory implements CharacterFactory {

    private Random r = new Random();

    @Override
    public King createKing() {
        return new MetalKing(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Queen createQueen() {
        return new MetalQueen(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Knight createKnight() {
        return new MetalKnight(r.nextInt(0, 10), 0);
    }
    
    @Override
    public Dragon createDragon() {
        return new MetalDragon(r.nextInt(0, 10), 0);
    }
}
