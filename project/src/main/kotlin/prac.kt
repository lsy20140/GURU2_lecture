

fun main() {
    // hw02-04
    for(i in 5..8 ){
        for(j in 1..9)
            println("$i X $j = ${i*j}")
        println("-----------")
    }

    // hw02-05
    var sum = 0
    var x = 0

    while(x <= 100){
        if(x%2==1){
            sum+=x
        }
        x++
    }
    println("$sum")


    sum = 0
    x = 0

    for(x in 1..100){
        if (x%2==1)
            sum+=x
    }
    println("$sum")

    
    sum = 0
    x = 0

    for(x in 1..100 step 2){
        sum += x
    }
    println("$sum")
}



