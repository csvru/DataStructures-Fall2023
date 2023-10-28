package polynomial.extractor;

import polynomial.Term;

import java.text.NumberFormat;
import java.text.ParseException;

public class TermExtractor {
    public static Term extract(String termString) throws ParseException {
        termString = termString.replace("+", "");

        var endCoefficientIndex = termString.contains("x") ? termString.indexOf("x") : null;
        if (endCoefficientIndex == null) {
            var coefficient = NumberFormat.getInstance().parse(termString);
            return new Term(coefficient, 0);
        }

        var coefficientString = termString.substring(0, endCoefficientIndex);
        var coefficient = NumberFormat.getInstance().parse(coefficientString);

        var startPowerPosition = termString.contains("x^") ? termString.indexOf("x^") + 2 : null;
        if (startPowerPosition == null) {
            return new Term(coefficient, 1);
        }

        var powerString = termString.substring(startPowerPosition);
        var power = NumberFormat.getInstance().parse(powerString).intValue();

        return new Term(coefficient, power);
    }
}
