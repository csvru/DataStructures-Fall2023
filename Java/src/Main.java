import polynomial.dense.DensePolynomial;
import polynomial.extractor.PolynomialExtractor;
import polynomial.sparse.SparsePolynomial;

public class Main {
    public static void main(String[] args) {
        try {
            var polynomial = PolynomialExtractor.extract("22X^3 - 0.64x^1");
            System.out.println(new SparsePolynomial(polynomial));
            System.out.println(new DensePolynomial(polynomial));
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}