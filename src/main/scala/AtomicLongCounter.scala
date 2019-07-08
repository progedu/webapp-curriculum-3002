import java.util.concurrent.atomic.AtomicLong

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }

}

object AtomicLongCounter {
  private [this] val lastNum = new AtomicLong(0L)

  def next: Long = {
    val nextNum = lastNum.updateAndGet((t:Long) => t +1)
    nextNum
  }

}
