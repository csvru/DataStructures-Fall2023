package polynomial;

import javax.naming.SizeLimitExceededException;
import java.util.Arrays;
import java.util.Comparator;

public class Polynomial {
    private final Term[] terms;
    private int nextEmptyIndex = 0;
    public Polynomial(int length) {
        this.terms = new Term[length];
    }

    @SuppressWarnings("UnusedReturnValue")
    public Polynomial addTerm(Term term) throws SizeLimitExceededException  {
        if (nextEmptyIndex >= this.terms.length) {
            throw new SizeLimitExceededException("terms capacity is full");
        }
        this.terms[nextEmptyIndex++] = term;
        return this;
    }

    public Term[] getTerms() {
        return this.terms;
    }

    public Polynomial sortPowersAscending() {
        Arrays.sort(this.terms, Comparator.comparingInt(Term::power));
        return this;
    }
    @SuppressWarnings("UnusedReturnValue")
    public Polynomial sortPowersDescending() {
        Arrays.sort(this.terms, (s1, s2) -> s2.power() - s1.power());
        return this;
    }

    public Integer maxPower() {
        var maxPower = -1;
        for(var term: this.terms){
            if(term.power() > maxPower) {
                maxPower = term.power();
            }
        }
        return maxPower != -1 ? maxPower : null;
    }

    @Override
    public String toString() {
        if (this.nextEmptyIndex == 0) {
            return "";
        }
        var stringBuilder = new StringBuilder();
        this.sortPowersDescending();
        for (var sentence : terms) {
            var operator = sentence.coefficient().floatValue() < 0 ? "" : "+";
            stringBuilder.append(operator);
            stringBuilder.append(sentence);
        }
        return stringBuilder.delete(0, 1).toString();
    }
}
