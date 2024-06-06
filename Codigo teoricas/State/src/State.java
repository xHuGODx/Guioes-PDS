public interface State {
    String getStateName();
    void turnOff();
    void pull();
    State nextState();
}
