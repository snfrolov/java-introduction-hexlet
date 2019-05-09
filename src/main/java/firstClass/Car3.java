package firstClass;

public class Car3 {

    int speed;

    public void showSpeed() {                   //  7 -> heap: [speed = 12]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 12], frame3 [this]
        System.out.println(this.speed);         //  8 -> heap: [speed = 12]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 12], frame3 [this]  console: "12"
    }                                           //  9 -> heap: [speed = 12]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 12]

    public void setSpeed(int newSpeed) {        //  4 -> heap: [speed = 0]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 12]
        this.speed = newSpeed;                  //  5 -> heap: [speed = 12]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 12]
        showSpeed();                            //  6 -> heap: [speed = 12]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 12]
        newSpeed = 8;                           //  10 -> heap: [speed = 12]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8]
        speed = 3;                              //  11 -> heap: [speed = 3]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8]
        setSetSpeed(newSpeed);                  //  12 -> heap: [speed = 3]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8]
    }                                           //  17 -> heap: [speed = 8]; frame stack: frame1 [args, car3]

    public void setSetSpeed(int speed) {        //  13 -> heap: [speed = 3]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
        speed = speed;                          //  14 -> heap: [speed = 3]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
        this.speed = speed;                     //  15 -> heap: [speed = 8]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8], frame3 [this, speed = 8]
    }                                           //  16 -> heap: [speed = 8]; frame stack: frame1 [args, car3], frame2 [this, newSpeed = 8]

    public static void main(String... args) {   //  1 -> heap: []; frame stack: frame1 [args]
        Car3 car3 = new Car3();                 //  2 -> heap: [speed = 0]; frame stack: frame1 [args, car3]
        car3.setSpeed(12);                      //  3 -> heap: [speed = 0]; frame stack: frame1 [args, car3]
    }                                           //  18 -> heap: [speed = 8]; frame stack: []
}