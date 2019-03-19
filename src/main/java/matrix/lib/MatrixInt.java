package matrix.lib;

import java.util.ArrayList;
import java.util.Random;

public class MatrixInt extends AMatrix {

    public MatrixInt(int size) {
        super(size);
        this.array = new ArrayList<Integer>(this.dimension);
    }

    @Override
    public void fill(int module) {
        int i;
        for (i = 0; i < this.dimension; i++) {
            // FIXED TODO this does not work in Android v4.4.4, API level 19
            this.array.add(
                    new Random().nextInt(module)
            );
        }
    }

    @Override
    public AMatrix multiply(AMatrix matrix) {
        int i, j, k;
        AMatrix matrix_computed = new MatrixInt(this.size);

        for (i = 0; i < this.size; i++) {
            for (j = 0; j < this.size; j++) {
                int result = 0;
                for (k = 0; k < this.size; k++) {
                    result += (int) this.array.get(i*this.size+k) * (int) matrix.array.get(k*this.size+j);
                }
                matrix_computed.array.add(result);
            }
        }

        return matrix_computed;
    }
}
