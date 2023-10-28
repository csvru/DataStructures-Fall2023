package polynomial.sparse;

import array.Array;
import array.sorted.SortedArray;
import polynomial.Polynomial;

public class SparsePolynomial {
    private final SortedArray<Integer> powers;
    private final Array<Double> coefficients;

    private final Double coefficientDefaultValue;

    public SparsePolynomial(Polynomial polynomial) {
        this(polynomial, 0.0);
    }

    public SparsePolynomial(Polynomial polynomial, Double coefficientDefaultValue) {
        this.coefficientDefaultValue = coefficientDefaultValue;
        var terms = polynomial.sortPowersAscending().getTerms();
        var length = terms.length;
        this.powers = new SortedArray<>(length, 0);
        this.coefficients = new Array<>(length, coefficientDefaultValue);
        for(var counter = 0; counter < length; counter++){
            powers.set(counter, terms[counter].power());
            coefficients.set(counter, terms[counter].coefficient().doubleValue());
        }
    }

    public Double findByPower(int power) throws IndexOutOfBoundsException {
        var index = this.powers.indexOf(power);
        if(index == null) {
            return this.coefficientDefaultValue;
        }
        return this.coefficients.get(index);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", powers, coefficients);
    }
}
