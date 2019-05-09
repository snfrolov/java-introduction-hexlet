package firstClass;

public class Car1 {

    int maxSpeed;

    public void startEngine() {                 //  6 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13], frame2 [this]
        System.out.println("Engine started!");  //  7 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13], frame2 [this] console: "Engine started!"
    }                                           //  8 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]

    public void setSpeed(int newSpeed) {        //  10 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13], frame2 [this, newSpeed = 12]                 //  14 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13], frame2 [this, newSpeed = 13]
        System.out.println(newSpeed);           //  11 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13], frame2 [this, newSpeed = 12] console: "12"   //  15 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13], frame2 [this, newSpeed = 13] console: "13"
    }                                           //  12 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]                                               //  16 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]

    public static void main(String... args) {   //  1 -> heap: []; frame stack: frame1 [args]
        Car1 car1 = new Car1();                 //  2 -> heap: [maxSpeed = 0]; frame stack: [args, car1]
        int speed = 13;                         //  3 -> heap: [maxSpeed = 0]; frame stack: frame1 [args, car1, speed = 13]
        car1.maxSpeed = 12;                     //  4 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]
        car1.startEngine();                     //  5 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]
        car1.setSpeed(12);                      //  9 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]
        car1.setSpeed(speed);                   //  13 -> heap: [maxSpeed = 12]; frame stack: frame1 [args, car1, speed = 13]
    }                                           //  17 -> heap: [maxSpeed = 12]; frame stack: []
}