  // sumFunc
//fun sum(a: Int, b:Int): Int{
//    var sum = a + b
//    return sum
//}
//
//fun main() {
//    val result1: Int
//    val result2: Int
//
//    result1 = sum(3,2)
//    result2 = sum(6,7)
//
//    println(result1)
//    println(result2)
//}

  // maxFunc
  fun main() {
      val num1 = 10
      val num2 = 3
      val result: Int

      result = max(num1, num2)
      println(result)
  }

  fun max(a: Int, b:Int) = if(a>b) a else b
