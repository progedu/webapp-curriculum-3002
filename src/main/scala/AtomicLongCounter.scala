import java.util.concurrent.atomic.AtomicLong
import java.util.function.{LongUnaryOperator, UnaryOperator}

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }
}

object AtomicLongCounter {
  private[this] val lastNumber = new AtomicLong(0L)

  def next: Long = {
    val currentNumber = lastNumber.updateAndGet(new LongUnaryOperator {
      override def applyAsLong(operand: Long): Long = operand + 1
    })
    currentNumber
  }
}
