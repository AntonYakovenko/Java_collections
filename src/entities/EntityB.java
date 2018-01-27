package entities;

import java.util.Arrays;

public class EntityB {
    private final String[][] stringArr;
    private final double[] doubleArr;

    EntityB(String[][] stringArr, double[] doubleArr) {
        this.stringArr = stringArr;
        this.doubleArr = doubleArr;
    }

    public String[][] getStringArr() {
        return stringArr;
    }

    public double[] getDoubleArr() {
        return doubleArr;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        EntityB that = (EntityB) obj;
        if(!Arrays.deepEquals(this.stringArr, that.stringArr)) {
            return false;
        }
        return Arrays.equals(this.doubleArr, that.doubleArr);
    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(stringArr);
        result = 31 * result + Arrays.hashCode(doubleArr);
        return result;
    }

    @Override
    public String toString() {
        return "EntityB{stringArr=" + Arrays.deepToString(stringArr) +
                ", doubleArr=" + Arrays.toString(doubleArr) + '}';
    }
}
