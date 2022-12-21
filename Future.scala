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

val fut2 = Future { Thread.sleep(10000); 21 / 0 }
fut2.value
// 10秒経ってから実行する
fut2.value
