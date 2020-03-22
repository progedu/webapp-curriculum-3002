import java.util.concurrent.atomic.AtomicLong

object AtomicLongCounterMain extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(AtomicLongCounter.next)).start()
  }

}

object AtomicLongCounter {

  var counter = new AtomicLong(0L)
  def next: Long = counter.getAndIncrement()
}
