public class Arrangements {
    public static Matrix cur;

    public static void rotationRight() {
        cur = cur.transpose();
        cur = cur.Rotate();
    }

    public double[][] getData() {
        return cur.getData();
    }

    public Matrix getMatrix() {
        return cur;
    }

    public void rotationLeft() {
        cur = cur.times(new Matrix(new double[][]{{0, -1}, {1, 0}}));
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
