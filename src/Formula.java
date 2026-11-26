package bsu.rfe.java.group7.lab2.Zarubski.varA;

public class Formula {
    // Внутренняя переменная для накопления суммы (кнопки MC / M+)
    private Double sum = 0.0;

    // Формула №1
    public Double calculate1(Double x, Double y, Double z) {
        double a = Math.cos(Math.exp(x));
        double b = Math.pow(Math.log(1 + y), 2);
        double c = Math.sqrt(Math.exp(Math.cos(x)) + Math.pow(Math.sin(Math.PI * z), 2));
        double d = Math.sqrt(1 / x);
        double e = Math.cos(y * y);
        return Math.pow(a + b + c + d + e, Math.sin(z));
    }

    // Формула №2
    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(1 + x * x, 1 / y) / Math.exp(Math.sin(z) + x);
    }

    // MC: очистить сумму
    public void clearSum() {
        sum = 0.0;
    }

    // M+: прибавить результат к сумме и вернуть новую сумму
    public Double addToSum(Double result) {
        sum += result;
        return sum;
    }

    public Double getSum() {
        return sum;
    }
}