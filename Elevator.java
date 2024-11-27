package ElevatorDesign;

public class Elevator {
    private int currentFloor;
    private Direction direction;

    public Elevator(int currentFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    public Elevator() {
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
