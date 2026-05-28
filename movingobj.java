package org.example;
public class movingobj {
    private int x;
    private int y;

    public movingobj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y++;
    }

    public void moveDown() {
        y--;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // ✅ Added main method so you can run this in IntelliJ
    public static void main(String[] args) {
        movingobj obj = new movingobj(0, 0);

        System.out.println("Initial Position: (" + obj.getX() + ", " + obj.getY() + ")");

        obj.moveUp();
        obj.moveRight();
        obj.moveRight();
        obj.moveDown();

        System.out.println("Final Position: (" + obj.getX() + ", " + obj.getY() + ")");
    }
}