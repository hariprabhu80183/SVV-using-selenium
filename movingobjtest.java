package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class movingobjtest {

    @Test
    void testMoveUp() {
        movingobj obj = new movingobj(0, 0);
        obj.moveUp();
        assertEquals(1, obj.getY(), "Object should move up by 1");
    }

    @Test
    void testMoveDown() {
        movingobj obj = new movingobj(0, 0);
        obj.moveDown();
        assertEquals(-1, obj.getY(), "Object should move down by 1");
    }

    @Test
    void testMoveLeft() {
        movingobj obj = new movingobj(0, 0);
        obj.moveLeft();
        assertEquals(-1, obj.getX(), "Object should move left by 1");
    }

    @Test
    void testMoveRight() {
        movingobj obj = new movingobj(0, 0);
        obj.moveRight();
        assertEquals(1, obj.getX(), "Object should move right by 1");
    }
}