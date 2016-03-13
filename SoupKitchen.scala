/* Kristina Spring
 * Myanna Harris
 * 
 * Soup Kitchen class
 * 3-11-16
 */

 class SoupKitchen(val np: String, val ap: String, val dp: String) extends Resource(np, ap, dp)
 {
   override def toString(): String= {name + "    --    " + address + "    --    " + desc}
   
   def toStringHelp(v: SoupKitchen): String= 
   {v.name + "    --    " + v.address + "    --    " + v.desc}
   
   def toString1(v: scala.collection.mutable.ArrayBuffer[SoupKitchen]): 
   scala.collection.mutable.ListBuffer[String]=
   {
     toListOf(toStringHelp, v)
   }
   
   def toListOf(f: SoupKitchen => String, v: scala.collection.mutable.ArrayBuffer[SoupKitchen]): 
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