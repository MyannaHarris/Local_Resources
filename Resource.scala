/* Kristina Spring
 * Myanna Harris
 * 
 * Resource class for similar
 * resources to inhert from
 * 3-11-16
 */

 abstract class Resource(val namep: String, val addressp: String, val descp: String)
 {
   var name: String = namep
   var address: String = addressp
   var desc: String = descp
   
   override def toString(): String
 }
 
 trait Price
 {
   var price: String
 }