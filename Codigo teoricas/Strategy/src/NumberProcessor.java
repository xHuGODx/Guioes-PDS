public class NumberProcessor {
    private OperationStrategy operation;

    public NumberProcessor(OperationStrategy operation) {
        this.operation = operation;
    }

    public void setOperation(OperationStrategy operation) {
        this.operation = operation;
    }

    public int performOperation(int num1, int num2) {
        return operation.perform(num1, num2);
    }
}