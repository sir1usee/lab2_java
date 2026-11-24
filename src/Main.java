import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private final Formula formula = new Formula();

    private final JTextField xField = new JTextField("1", 8);
    private final JTextField yField = new JTextField("1", 8);
    private final JTextField zField = new JTextField("1", 8);
    private final JTextField resultField = new JTextField(15);
    private final JRadioButton f1 = new JRadioButton("Формула №1", true);
    private final JRadioButton f2 = new JRadioButton("Формула №2");

    public Main() {
        super("Лабораторная: формулы");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        ButtonGroup group = new ButtonGroup();
        group.add(f1);
        group.add(f2);

        JPanel top = new JPanel();
        top.add(f1);
        top.add(f2);

        JPanel inputs = new JPanel();
        inputs.add(new JLabel("x:"));
        inputs.add(xField);
        inputs.add(new JLabel("y:"));
        inputs.add(yField);
        inputs.add(new JLabel("z:"));
        inputs.add(zField);

        JPanel north = new JPanel(new GridLayout(2, 1));
        north.add(top);
        north.add(inputs);

        resultField.setEditable(false);
        JPanel center = new JPanel();
        center.add(new JLabel("Результат:"));
        center.add(resultField);

        JButton calc = new JButton("Вычислить");
        JButton mc = new JButton("MC");
        JButton mPlus = new JButton("M+");
        JPanel buttons = new JPanel();
        buttons.add(calc);
        buttons.add(mc);
        buttons.add(mPlus);

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        calc.addActionListener(e -> {
            Double r = compute();
            if (r != null) resultField.setText(String.valueOf(r));
        });

        mc.addActionListener(e -> {
            formula.clearSum();
            resultField.setText(String.valueOf(formula.getSum()));
        });

        mPlus.addActionListener(e -> {
            Double r = compute();
            if (r != null) {
                resultField.setText(String.valueOf(formula.addToSum(r)));
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    // Считывает x, y, z и считает выбранную формулу. При ошибке ввода возвращает null.
    private Double compute() {
        try {
            Double x = Double.parseDouble(xField.getText().trim().replace(',', '.'));
            Double y = Double.parseDouble(yField.getText().trim().replace(',', '.'));
            Double z = Double.parseDouble(zField.getText().trim().replace(',', '.'));
            return f1.isSelected() ? formula.calculate1(x, y, z) : formula.calculate2(x, y, z);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введите корректные числа в x, y, z",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}