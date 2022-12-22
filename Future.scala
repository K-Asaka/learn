// エラー
import scala.concurrent.Future
// val fut = Future { Thread.sleep(10000); 21 + 21 }

import scala.concurrent.ExecutionContext.Implicits.global
val fut = Future { Thread.sleep(10000); 21 + 21 }

fut.isCompleted
fut.value
// 10秒経ってから実行する
fut.isCompleted
fut.value

val fut_try = Future { Thread.sleep(10000); 21 / 0 }
fut_try.value
// 10秒経ってから実行する
fut_try.value

val result = fut.map(x => x + 1)
result.value
// 10秒経ってから実行する
result.value


val fut1 = Future { Thread.sleep(10000); 21 + 21 }
val fut2 = Future { Thread.sleep(10000); 23 + 23 }
val fut_result = for {
    x <- fut1
    y <- fut2
} yield x + y
fut_result.value
// 10秒後に終了
fut_result.value

// 並列化されない例
val fut_result2 = for {
    x <- Future { Thread.sleep(10000); 21 + 21 }
    y <- Future { Thread.sleep(10000); 23 + 23 }
} yield x + y
fut_result2.value
// 20秒後に終了する

Future.successful { 21 + 21 }
Future.failed(new Exception("bummer!"))

import scala.util.{Success, Failure}
Future.fromTry(Success { 21 + 21 })
Future.fromTry(Failure(new Exception("bummer!")))

import scala.concurrent.Promise
val pro = Promise[Int]()
val pfut = pro.future
pfut.value

pro.success(42)
pfut.value


val fut3 = Future { 42 }
val valid = fut3.filter(res => res > 0)
valid.value

val invalid = fut.filter(res => res < 0)
invalid.value

val valid2 = for (res <- fut3 if res > 0) yield res
valid2.value

val invalid2 = for (res <- fut3 if res < 0) yield res
invalid2.value

val valid3 = fut3 collect { case res if res > 0 => res + 46 }
valid3.value

val invalid3 = fut3 collect { case res if res < 0 => res + 46 }
invalid3.value

val failure = Future { 42 / 0 }
failure.value
val expectedFailure = failure.failed
expectedFailure.value

val success = Future { 42 / 1 }
success.value
val unexpectedSuccess = success.failed
unexpectedSuccess.value

val fallback = failure.fallbackTo(success)
fallback.value

val failedFallback = failure.fallbackTo(
    Future { val res = 42; require(res < 0); res }
)
failedFallback.value

val recovered = failedFallback recover {
    case ex: ArithmeticException => -1
}
recovered.value

val unrecovered = fallback recover {
    case ex: ArithmeticException => -1
}
unrecovered.value

val alsoUnrecovered = failedFallback recover {
    case ex: IllegalArgumentException => -2
}
alsoUnrecovered.value

val alsoRecovered = failedFallback recoverWith {
    case ex: ArithmeticException => Future { 42 + 46 }
}
alsoRecovered.value

val first = success.transform (
    res => res * -1,
    ex => new Exception("see cause", ex)
)
first.value

val second = failure.transform (
    res => res * -1,
    ex => new Exception("see cause", ex)
)
second.value

val firstCase = success.transform {     // Scala 2.12以降
    case Success(res) => Success(res * -1)
    case Failure(ex) => 
        Failure(new Exception("see cause", ex))
}
firstCase.value

val secondCase = failure.transform {
    case Success(res) => Success(res * -1)
    case Failure(ex) => 
        Failure(new Exception("see cause", ex))
}
secondCase.value

val nonNegative = failure.transform {   // Scala2.12
    case Success(res) => Success(res.abs + 1)
    case Failure(_) => Success(0)
}
nonNegative.value

val zippedSuccess = success zip recovered
zippedSuccess.value

val zippedFailure = success zip failure
zippedFailure.value

val fortyTwo = Future { 21 + 21 }
val fortySix = Future { 23 + 23 }
val futureNums = List(fortyTwo, fortySix)
val folded = Future.foldLeft(futureNums)(0) { (acc, num) => acc + num }
folded.value

val reduced = Future.reduceLeft(futureNums) { (acc, num) => acc + num }
reduced.value

val futureList = Future.sequence(futureNums)
futureList.value

val traversed = Future.traverse(List(1, 2, 3)) { i => Future(i) }
traversed.value
