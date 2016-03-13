/* Kristina Spring
 * Myanna Harris
 * 
 * Water class
 * 3-11-16
 */

 class Water(val np: String, val ap: String, val dp: String) extends Resource(np, ap, dp) with Price
 {
   var price = "0"
   
   def setPrice(p: String): Unit = {price = p}
   
   override def toString(): String= {
   name + "    --    " + address + "    --    " + desc + "    --    " + price}
   
   def toStringHelp(v: Water): String= 
   {v.name + "    --    " + v.address + "    --    " + v.desc + "    --    " + v.price}
   
   def toString1(v: scala.collection.mutable.ArrayBuffer[Water]): 
   scala.collection.mutable.ListBuffer[String]=
   {
     toListOf(toStringHelp, v)
   }
   
   def toListOf(f: Water => String, v: scala.collection.mutable.ArrayBuffer[Water]): 
   scala.collection.mutable.ListBuffer[String] = 
   {
     var list = scala.collection.mutable.ListBuffer.empty[String]
     var a = 0
     for(a <- 0 to (v.length - 1))
     {
       list.append(f(v(a)))
     }
     list
   }
 }