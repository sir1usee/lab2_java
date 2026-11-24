public class Formula {
    private Double sum = 0.0;

    public Double calculate1(Double x, Double y, Double z) {
        double a = Math.cos(Math.exp(x));
        double b = Math.pow(Math.log(1 + y), 2);
        double c = Math.sqrt(Math.exp(Math.cos(x)) + Math.pow(Math.sin(Math.PI * z), 2));
        double d = Math.sqrt(1 / x);
        double e = Math.cos(y * y);
        return Math.pow(a + b + c + d + e, Math.sin(z));
    }

    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(1 + x * x, 1 / y) / Math.exp(Math.sin(z) + x);
    }

    public void clearSum() {
        sum = 0.0;
    }

    public Double addToSum(Double result) {
        sum += result;
        return sum;
    }

    public Double getSum() {
        return sum;
    }
}