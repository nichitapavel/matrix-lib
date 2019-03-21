package matrix.lib;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class MatrixFloat extends AMatrix {

    public MatrixFloat(int size) {
        super(size);
        this.array = new ArrayList<Float>(this.dimension);
    }

    public void set(float[] array_data) throws Exception {
        if (array_data.length != this.dimension)
            throw new Exception("Matrix dimension and array length does not match.");
        for (float item : array_data)
            if (this.array != null) {
                this.array.add(item);
            }
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
                float result = 0.0f;
                for (k = 0; k < this.size; k++) {
                    result += (float) this.array.get(i*this.size+k) * (float) matrix.array.get(k*this.size+j);
                }
                matrix_computed.array.add(result);
            }
        }

        return matrix_computed;
    }

    // TODO this is float specific implementation, but AMatrix.equals() still can be used, this means that two similar
    // equals() methods can produce different results, this is counter intuitive, should make it more clear somehow
    public boolean equals(Object o, int decimals) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AMatrix matrix = (AMatrix) o;

        float floatFirstArray, floatSecondArray;
        for (int i = 0; i < this.dimension; i++) {
            floatFirstArray = BigDecimal.
                    valueOf( ((Float) (this.array.get(i))).floatValue() ).
                    setScale(decimals, BigDecimal.ROUND_HALF_UP).
                    floatValue();
            floatSecondArray = BigDecimal.
                    valueOf( ((Float) (matrix.array.get(i))).floatValue() ).
                    setScale(decimals, BigDecimal.ROUND_HALF_UP).
                    floatValue();
            if (floatFirstArray != floatSecondArray) {
                return false;
            }
        }
        return true;
    }
}
