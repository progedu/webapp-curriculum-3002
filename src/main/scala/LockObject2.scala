import java.security.MessageDigest

object LockObjectMain2 extends App {

  for (i <- 1 to 100) {
    new Thread(() => println(HashDigestProvider1.digest("Hello!"))).start()
  }

}

object HashDigestProvider2 {

  def digest(str: String): List[Byte] = {
    lazy val md = MessageDigest.getInstance("SHA-1")
    md.update(str.getBytes)
    md.digest().toList
  }

}
