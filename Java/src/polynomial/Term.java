package polynomial;

public record Term(Number coefficient, int power) {
    @Override
    public String toString() {
        if (coefficient.equals(0)) {
            return "";
        }
        if (power == 0) {
            return coefficient.toString();
        }
        var prefix = coefficient.equals(1) ? "x" : String.format("%sx", coefficient);
        var suffix = power == 1 ? "" : String.format("^%d", power);
        return prefix + suffix;
    }
}
