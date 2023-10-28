package polynomial.extractor;

import polynomial.Polynomial;

import javax.naming.SizeLimitExceededException;
import java.text.ParseException;

public class PolynomialExtractor {
    public static Polynomial extract(String polynomialText) throws IllegalArgumentException, ParseException, SizeLimitExceededException {
        if (polynomialText.isEmpty()){
            throw new IllegalArgumentException("polynomial text is empty");
        }
        var terms = polynomialText.replace(" ", "").toLowerCase().split("(?=[+-])");
        var polynomial = new Polynomial(terms.length);
        for (var term : terms) {
            polynomial.addTerm(TermExtractor.extract(term));
        }
        return polynomial;
    }
}
