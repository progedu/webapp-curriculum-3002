import java.util.concurrent.atomic.AtomicLong

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }

}

object AtomicLongCounter {

  private val lastNumber = new AtomicLong()

  def next: Long = {
    val nextNumber = lastNumber.updateAndGet(new LongUnaryOperator {
      override def applyAsLong(operand: Long): Long = operand + 1
    })
    nextNumber
  }

}
