package matrix.lib;

import java.util.List;
import java.util.Objects;

public abstract class AMatrix implements IMatrix {
    protected List array;
    protected final int size;
    protected final int dimension;

    public AMatrix(int size) {
        this.size = size;
        this.dimension = size * size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AMatrix matrix = (AMatrix) o;
        return array.equals(matrix.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    @Override
    public String toString() {
        int i, j;
        StringBuilder message = new StringBuilder();

        if (this.array.size() == 0) {
            return "Matrix empty.";
        }

        for (i = 0; i < this.size; i++) {
            for (j = 0; j < this.size; j++)
                message.append(this.array.get(i * this.size + j)).append("\t");
            message.append("\n");
        }

        return message.toString();
    }
}
