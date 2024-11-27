package ElevatorDesign;
public class Request{
    private final int targetFloor;
    private final Direction direction;
    private final Boolean isExternal;


    public Request(int targetFloor, Direction direction, Boolean isExternal) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.isExternal = isExternal;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public Boolean getExternal() {
        return isExternal;
    }
}