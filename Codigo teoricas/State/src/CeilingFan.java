class CeilingFan {
    private State currentState;

    public CeilingFan() {
        currentState = new Off();
    }

    public void pull() {
        currentState.pull();
        currentState = currentState.nextState();
    }

    public String getState() {
        return currentState.getStateName();
    }
}
