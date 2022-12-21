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
