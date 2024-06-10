import scala.io.Source
import java.nio.file.{Paths, Files}

@main
def main(): Unit = {
  val testFilePath: String = "src/main/resources/txt_sample.txt"
  val fileContent = readFileContent(filePath = testFilePath)

  fileContent match {
    case None => println("File does not exist")
    case Some(text) => println(s"Content of TXT: $text")
  }
}

def readFileContent(filePath: String): Option[String] = {
  if (filePath.isEmpty || !Files.exists(Paths.get(filePath))) {
    None
  } else {
    Some(Source.fromFile(filePath).mkString)
  }
}