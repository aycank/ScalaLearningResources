
package breaktesting.logtest

import com.typesafe.scalalogging.LazyLogging

object HelloWorldWithLog extends App with LazyLogging{
  logger.error("Hello World")
}

