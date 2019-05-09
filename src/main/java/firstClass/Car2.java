package firstClass;

public class Car2 {

    int speed;

    public void showSpeed() {                   //  5 -> heap: [speed = 1]; frame stack: frame1 [args, car2], frame2 [this]                 //  13 -> heap: [speed = 12]; frame stack: frame1 [args, car2], frame2 [this]
        System.out.println(this.speed);         //  6 -> heap: [speed = 1]; frame stack: frame1 [args, car2], frame2 [this] console: "1"    //  14 -> heap: [speed = 12]; frame stack: frame1 [args, car2], frame2 [this] console: "12"
    }                                           //  7 -> heap: [speed = 1]; frame stack: frame1 [args, car2]                                //  15 -> heap: [speed = 12]; frame stack: frame1 [args, car2]

    public void setSpeed(int newSpeed) {        //  9 -> heap: [speed = 1]; frame stack: frame1 [args, car2], frame2 [this, newSpeed = 12]
        this.speed = newSpeed;                  //  10 -> heap: [speed = 12]; frame stack: frame1 [args, car2], frame2 [this, newSpeed = 12]
    }                                           //  11 -> heap: [speed = 12]; frame stack: frame1 [args, car2]

    public static void main(String... args) {   //  1 -> heap: []; frame stack: frame1 [args]
        Car2 car2 = new Car2();                 //  2 -> heap: [speed = 0]; frame stack: frame1 [args, car2]
        car2.speed = 1;                         //  3 -> heap: [speed = 1]; frame stack: frame1 [args, car2]
        car2.showSpeed();                       //  4 -> heap: [speed = 1]; frame stack: frame1 [args, car2]
        car2.setSpeed(12);                      //  8 -> heap: [speed = 1]; frame stack: frame1 [args, car2]
        car2.showSpeed();                       //  12 -> heap: [speed = 12]; frame stack: frame1 [args, car2]
    }                                           //  16 -> heap: [speed = 12]; frame stack: []
}