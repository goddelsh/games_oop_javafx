package ru.job4j.chess.firuges;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void freeRoadTest(){
        Logic logic = new Logic();
        BishopBlack blackBishop = new BishopBlack(Cell.A1);
        logic.add(blackBishop);
        Cell[] steps = blackBishop.way(Cell.A1, Cell.D4);
        boolean result = logic.roadIsFree(steps);
        assertThat(result, is(true));
    }

    @Test
    public void busyRoadTest(){
        Logic logic = new Logic();
        BishopBlack blackBishop = new BishopBlack(Cell.A1);
        logic.add(blackBishop);
        logic.add(new BishopBlack(Cell.C3));
        Cell[] steps = blackBishop.way(Cell.A1, Cell.D4);
        boolean result = logic.roadIsFree(steps);
        assertThat(result, is(false));
    }
}
