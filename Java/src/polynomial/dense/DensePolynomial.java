package polynomial.dense;

import polynomial.Polynomial;

import java.util.Arrays;


public class DensePolynomial {
    private final float[] denseArray;
    public DensePolynomial(Polynomial polynomial) {
        var maxPower = polynomial.maxPower();
        this.denseArray = new float[maxPower + 1];
        for (var sentence : polynomial.getTerms()){
            var power = sentence.power();
            this.denseArray[power] += sentence.coefficient().floatValue();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.denseArray);
    }
}
