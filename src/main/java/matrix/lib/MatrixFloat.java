package matrix.lib;

import java.util.ArrayList;
import java.util.Random;

public class MatrixFloat extends AMatrix {

    public MatrixFloat(int size) {
        super(size);
        this.array = new ArrayList<Float>(this.dimension);
    }

    @Override
    public void fill(int module) {
        int i;
        Float fl;
        Integer in;
        for (i = 0; i < this.dimension; i++) {
            // FIXED TODO this does not work in Android v4.4.4, API level 19
            fl = new Random().nextFloat();
            in = new Random().nextInt(module);
            this.array.add(
                    fl * in
            );
        }
    }

    @Override
    public AMatrix multiply(AMatrix matrix) {
        int i, j, k;
        AMatrix matrix_computed = new MatrixFloat(this.size);

        for (i = 0; i < this.size; i++) {
            for (j = 0; j < this.size; j++) {
                int result = 0;
                for (k = 0; k < this.size; k++) {
                    result += (float) this.array.get(i*this.size+k) * (float) matrix.array.get(k*this.size+j);
                }
                matrix_computed.array.add(result);
            }
        }

        return matrix_computed;
    }
}
