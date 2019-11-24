package ru.job4j.chess.firuges.black;

import javafx.css.Match;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest));
       }
        int size = Math.abs(source.x - dest.x);//(int)Math.sqrt(Math.pow(source.x - dest.x, 2) +  Math.pow(dest.y - source.y, 2));
        Cell[] steps = new Cell[size];
        int deltaX = source.x > dest.x ? -1 : 1;
        int deltaY = source.y > dest.y ? -1 : 1;
        int cellsEnumLength = Cell.values().length;
        for (int index = 0; index < size; index++) {
            for (int j = 0; j < cellsEnumLength; j++) {
                int x = source.x + deltaX + index * deltaX;
                int y = source.y + deltaY + index * deltaY;
                if ((Cell.values()[j].x == x) && (Cell.values()[j].y == y)){
                    steps[index] = Cell.values()[j];
                    break;
                }
            }

        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(source.x - dest.x) == Math.abs(dest.y - source.y)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
