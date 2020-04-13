import java.util.concurrent.atomic.AtomicLong

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }

}

/* 解答 */
object AtomicLongCounter {
  private[this] val lastNumber = new AtomicLong(0L)

  def next: Long = {
    val nextNumber = lastNumber.incrementAndGet()
    nextNumber
  }
}

object AtomicLongCounterSampleAnswer {
  val count = new AtomicLong(0L)
  def next: Long = count.incrementAndGet()
}