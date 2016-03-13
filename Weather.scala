/* Kristina Spring
 * Myanna Harris
 * 
 * Weather class
 * 3-11-16
 */

 class Weather
 {
   var temp: String = "unk"
   var humidity: String = "unk"
   var warning: String = "N/A"
   
   def setWarning(w: String): Unit = {
     warning = w
   }
   def getWarning(): String = {warning}
   
   def setTemp(t: String): Unit = {temp = t}
   def getTemp(): String = {temp}
   
   def setHumidity(h: String): Unit = {humidity = h}
   def getHumidity(): String = {humidity}
   
   override def toString(): String= {
     "Temp: "+temp+"\nHumidity: "+humidity+"\nWarnings: \n"+warning
   }
 }