package ElevatorDesign;
public class Request{
    private final int targetFloor;
    private final String direction;
    private final Boolean isExternal;


    public Request(int targetFloor, String direction, Boolean isExternal) {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.isExternal = isExternal;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public String getDirection() {
        return direction;
    }

    public Boolean getExternal() {
        return isExternal;
    }
}