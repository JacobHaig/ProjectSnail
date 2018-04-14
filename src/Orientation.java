import java.util.Random;

public class Orientation {
    public static Matrix cur;

    public static void rotationRight() {
        cur = cur.transpose();
        cur = cur.Rotate();
    }

    public void randomMatrix() {
        int ran = new Random().nextInt(7);

        if (ran == 0) T();
        if (ran == 1) I();
        if (ran == 2) J();
        if (ran == 3) L();
        if (ran == 4) O();
        if (ran == 5) S();
        if (ran == 6) Z();
    }


    public double[][] getData() {
        return cur.getData();
    }

    public Matrix getMatrix() {
        return cur;
    }

    public void T() {
        cur = new Matrix(new double[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}});
    }

    public void I() {
        cur = new Matrix(new double[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}});
    }

    public void J() {
        cur = new Matrix(new double[][]{{0, 1, 0}, {0, 1, 0}, {1, 1, 0}});
    }

    public void L() {
        cur = new Matrix(new double[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 1}});
    }

    public void O() {
        cur = new Matrix(new double[][]{{1, 1}, {1, 1}});
    }

    public void S() {
        cur = new Matrix(new double[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}});
    }

    public void Z() {
        cur = new Matrix(new double[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}});
    }


}
