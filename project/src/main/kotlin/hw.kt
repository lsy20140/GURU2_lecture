fun main() {
    var count : Int = 85

    // if-else
    if(count >= 90){
        println("if문: A학점")
    }
    else if(count >= 80){
        println("if문: B학점")
    }
    else if(count >= 70){
        println("if문: C학점")
    }
    else if(count >= 60){
        println("if문: D학점")
    }
    else{
        println("if문: F학점")
    }

    // when -> if-else 보다 가독성 good
    when(count){
        in 90 .. 100 -> println("when문: A학점")
        in 80 .. 89 -> println("when문: B학점")
        in 70 .. 79 -> println("when문: C학점")
        in 60 .. 69 -> println("when문: D학점")
        else -> println("when문: F학점")
    }
}