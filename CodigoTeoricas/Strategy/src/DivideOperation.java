public class DivideOperation implements OperationStrategy {
    @Override
    public int perform(int num1, int num2) {
        if (num2 == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return num1 / num2;
    }
}