package ElevatorDesign;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {
    PriorityQueue<Request> requests;
    private Elevator elevator;
    public ElevatorController(Elevator elevator) {
        requests = new PriorityQueue<>(comparator);
        this.elevator = elevator;
    }

    Comparator<Request> comparator = new Comparator<Request>() {
        @Override
        public int compare(Request o1, Request o2) {
            if(elevator.getDirection().equals(Direction.UP)){
                if(o1.getTargetFloor() > elevator.getCurrentFloor() && o2.getTargetFloor() > elevator.getCurrentFloor()){
                    return Integer.compare(o1.getTargetFloor(), o2.getTargetFloor());
                }
                else if(o1.getTargetFloor() > elevator.getCurrentFloor()){
                    return -1;
                }
                else if(o2.getTargetFloor() > elevator.getCurrentFloor()){
                    return 1;
                }
                else {
                    return Integer.compare(o1.getTargetFloor(), o2.getTargetFloor());
                }

            }
            else if(elevator.getDirection().equals(Direction.DOWN)){
                if(o1.getTargetFloor() < elevator.getCurrentFloor() && o2.getTargetFloor() < elevator.getCurrentFloor()){
                    return Integer.compare(o2.getTargetFloor(), o1.getTargetFloor());
                }
                else if(o1.getTargetFloor() < elevator.getCurrentFloor()){
                    return -1;
                }
                else if(o2.getTargetFloor() < elevator.getCurrentFloor()){
                    return 1;
                }
                else {
                    return Integer.compare(o2.getTargetFloor(), o1.getTargetFloor());
                }
            }
            return 0;
        }
    };
    void moveElevator(){
        updateRequests(requests);
        Request currentRequest = requests.peek();
        requests.poll();
        System.out.println("Moved from "+elevator.getCurrentFloor()+" and direction of "+elevator.getDirection());
        if(currentRequest.getTargetFloor()>elevator.getCurrentFloor()){
            elevator.setDirection(Direction.UP);
        }
        else if(currentRequest.getTargetFloor() < elevator.getCurrentFloor()){
            elevator.setDirection(Direction.DOWN);
        }
        else {
            elevator.setDirection(Direction.IDLE);
        }
        elevator.setCurrentFloor(currentRequest.getTargetFloor());
        System.out.println("Moved to "+elevator.getCurrentFloor()+" in direction "+elevator.getDirection());
    }

    private void updateRequests(PriorityQueue<Request> requests) {
        PriorityQueue<Request> current = new PriorityQueue<>(comparator);
        current.addAll(requests);
        requests.clear();
        requests.addAll(current);
    }

    public Boolean addRequest(Request request){
        this.requests.add(request);
        return true;
    }
}
