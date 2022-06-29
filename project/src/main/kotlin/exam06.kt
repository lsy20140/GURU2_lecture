class Car{
    var color : String = ""
    var speed : Int = 0

    fun upSpeed(value: Int){
        if(speed+value >= 200)
            speed = 200
        else
            speed = speed + value
    }

    fun downSpeed(value: Int){
        if(speed-value <= 0)
            speed = 0
        else
            speed = speed - value
    }
}

fun main() {
    var myCar1 : Car = Car()
    myCar1.color = "빨강"
    myCar1.speed = 0

    var myCar2 : Car = Car()
    myCar1.color = "파랑"
    myCar1.speed = 0

    var myCar3 : Car = Car()
    myCar1.color = "초록"
    myCar1.speed = 0

    myCar1.upSpeed(50)
    println("자동차1의 색상은 " + myCar1.color + "이며, 속도는 " + myCar1.speed + "km 입니다.")

    myCar2.upSpeed(20)
    println("자동차2의 색상은 " + myCar2.color + "이며, 속도는 " + myCar2.speed + "km 입니다.")

    myCar3.upSpeed(250)
    println("자동차3의 색상은 " + myCar3.color + "이며, 속도는 " + myCar3.speed + "km 입니다.")



}