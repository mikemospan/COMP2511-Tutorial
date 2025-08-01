package thrones.decorators;

import java.util.List;

import thrones.Character;
import thrones.MoveResult;

public class CharacterDecorator implements Character {
    private Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }

    @Override
    public int getHealthPoints() {
        return character.getHealthPoints();
    }

    @Override
    public int getX() {
        return character.getX();
    }

    @Override
    public int getY() {
        return character.getY();
    }

    @Override
    public void damage(int points) {
        character.damage(points);
    }

    @Override
    public boolean canMove(int dx, int dy) {
        return character.canMove(dx, dy);
    }

    @Override
    public void attack(Character victim) {
        character.attack(victim);
    }

    @Override
    public MoveResult makeMove(int x, int y, List<Character> characters) {
        return character.makeMove(x, y, characters);
    }

    @Override
    public String toString() {
        return character.toString();
    }

    @Override
    public void setX(int x) {
        character.setX(x);
    }

    @Override
    public void setY(int y) {
        character.setY(y);
    }
}
