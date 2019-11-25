package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;


public class BishopBlackTest {
    @Test
    public void isoscelesTriangleCheck(){
        BishopBlack figure = new BishopBlack(Cell.A1);
        boolean diagonalResult = figure.isDiagonal(Cell.A1, Cell.D4);
        assertThat(diagonalResult, is(true));
    }
    @Test
    public void scaleneTriangleCheck(){
        BishopBlack figure = new BishopBlack(Cell.A1);
        boolean diagonalResult = figure.isDiagonal(Cell.A1, Cell.D3);
        assertThat(diagonalResult, is(false));
    }
    @Test
    public void rightWayCheck(){
        BishopBlack figure = new BishopBlack(Cell.A1);
        Cell[] steps = figure.way(Cell.A1, Cell.D4);
        Cell[] reference = { Cell.B2, Cell.C3, Cell.D4 };
        assertArrayEquals(steps, reference);
    }
    @Test(expected = IllegalStateException.class)
    public void wrongWayCheck(){
        BishopBlack figure = new BishopBlack(Cell.A1);
        Cell[] steps = figure.way(Cell.A1, Cell.D5);
    }
}
