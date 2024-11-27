package ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    Elevator elevator = new Elevator(1,Direction.IDLE);
    ElevatorController elevatorController = new ElevatorController(elevator);
    public void run(){
        List<Request> requestList = new ArrayList<>();
        Request request = new Request(3,Direction.UP, false);
        Request request2 = new Request(9, Direction.UP, false);
        Request request3 = new Request(5, Direction.DOWN, false);
        Request request4 = new Request(3, Direction.UP, false);
        Request request5 = new Request(6, Direction.DOWN, false);
        requestList.add(request);
        requestList.add(request2);
        requestList.add(request3);
        requestList.add(request4);
        requestList.add(request5);
        for(Request r: requestList){
            elevatorController.addRequest(r);
            elevatorController.moveElevator();
        }
    }
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.run();

        System.out.println("Hello, World!");
    }
}
