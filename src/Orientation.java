import java.util.Random;

public class Orientation {
    public static Matrix cur;

    public Matrix T = new Matrix(new double[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}});
    public Matrix I = new Matrix(new double[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}});
    public Matrix J = new Matrix(new double[][]{{0, 1, 0}, {0, 1, 0}, {1, 1, 0}});
    public Matrix L = new Matrix(new double[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 1}});
    public Matrix O = new Matrix(new double[][]{{1, 1}, {1, 1}});
    public Matrix S = new Matrix(new double[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}});
    public Matrix Z = new Matrix(new double[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}});


    public static void rotationRight() {
        cur = cur.transpose();
        cur = cur.Rotate();
    }

    public void randomMatrix() {
        int ran = new Random().nextInt(7);

        if (ran == 0) cur = T;
        if (ran == 1) cur = I;
        if (ran == 2) cur = J;
        if (ran == 3) cur = L;
        if (ran == 4) cur = O;
        if (ran == 5) cur = S;
        if (ran == 6) cur = Z;
    }


    public double[][] getData() {
        return cur.getData();
    }

    public Matrix getMatrix() {
        return cur;
    }

}
