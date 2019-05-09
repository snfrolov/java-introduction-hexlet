package firstClass;

public class Car4 {

    int speed;

    public void showSpeed() {                   //  7 -> heap: [speed = 12]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 12], frame3 [this]                  //  15 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8], frame4 [this]                 //  21 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8], frame4 [this]                 //  26 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this]
        System.out.println(this.speed);         //  8 -> heap: [speed = 12]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 12], frame3 [this]  console: "12"   //  16 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8], frame4 [this]   console: "3"  //  22 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8], frame4 [this]   console: "8"  //  27 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this]   console: "8"
    }                                           //  9 -> heap: [speed = 12]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 12]                                 //  17 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]                                //  23 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]                                //  28 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8]

    public void setSpeed(int newSpeed) {        //  4 -> heap: [speed = 0]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 12]
        this.speed = newSpeed;                  //  5 -> heap: [speed = 12]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 12]
        showSpeed();                            //  6 -> heap: [speed = 12]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 12]
        newSpeed = 8;                           //  10 -> heap: [speed = 12]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8]
        speed = 3;                              //  11 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8]
        setSetSpeed(newSpeed);                  //  12 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8]
        showSpeed();                            //  25 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8]
    }                                           //  29 -> heap: [speed = 8]; frame stack: frame1 [args, car4]

    public void setSetSpeed(int speed) {        //  13 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
        showSpeed();                            //  14 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
        speed = speed;                          //  18 -> heap: [speed = 3]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
        this.speed = speed;                     //  19 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
        showSpeed();                            //  20 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
    }                                           //  24 -> heap: [speed = 8]; frame stack: frame1 [args, car4], frame2 [this, newSpeed = 8]

    public static void main(String... args) {   //  1 -> heap: []; frame stack: frame1 [args]
        Car4 car4 = new Car4();                 //  2 -> heap: [speed = 0]; frame stack: frame1 [args, car4]
        car4.setSpeed(12);                      //  3 -> heap: [speed = 0]; frame stack: frame1 [args, car4]
    }                                           //  30 -> heap: [speed = 8]; frame stack: []
}