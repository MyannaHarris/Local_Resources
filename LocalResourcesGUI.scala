/* Kristina Spring
 * Myanna Harris
 * 
 * Local Resources
 * GUI to help homeless and low income people
 * find resources
 * 3-11-16
 */

import scala.swing._
import scala.swing.event._

class UI extends MainFrame
{
  title = "Local Resources"
  preferredSize = new Dimension(700, 700)
  
  //Objects
  val weather: Weather = new Weather()
  var shelter = scala.collection.mutable.ArrayBuffer.empty[Shelter]
  var soupK = scala.collection.mutable.ArrayBuffer.empty[SoupKitchen]
  var food = scala.collection.mutable.ArrayBuffer.empty[Food]
  var water = scala.collection.mutable.ArrayBuffer.empty[Water]
  
  val label = new Label {font = new Font("Arial", 0, 36); text = "Local Resources"}
  val weatherB = new Button("Weather")
  val shelterB = new Button("Shelter")
  val soupKB = new Button("Soup Kitchen")
  val foodB = new Button("Food")
  val waterB = new Button("Water")
  val adminB = new Button("Admin")
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
  
    contents += Swing.VStrut(10)
	contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(weatherB, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(shelterB, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(soupKB, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(foodB, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(waterB, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(adminB, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)
  listenTo(weatherB)
  listenTo(shelterB)
  listenTo(soupKB)
  listenTo(foodB)
  listenTo(waterB)
  listenTo(adminB)

  reactions += {
    case ButtonClicked(`weatherB`) =>
	  val ui2 = new WeatherUI(weather)
	  ui2.visible = true
    case ButtonClicked(`shelterB`) =>
	  val ui2 = new ShelterUI(shelter)
	  ui2.visible = true
    case ButtonClicked(`soupKB`) =>
	  val ui2 = new SoupKitchenUI(soupK)
	  ui2.visible = true
    case ButtonClicked(`foodB`) =>
	  val ui2 = new FoodUI(food)
	  ui2.visible = true
    case ButtonClicked(`waterB`) =>
	  val ui2 = new WaterUI(water)
	  ui2.visible = true
    case ButtonClicked(`adminB`) =>
	  val ui2 = new LoginUI(weather, shelter, soupK, food, water)
	  ui2.visible = true
    case ButtonClicked(`close1`) => 
	  this.dispose()
	  
  }
}

object LocalResourcesGUI
{
  def main(args: Array[String])
  {
    val ui = new UI
    ui.visible = true
    println("End of main function")
  }
}

class LoginUI(
val weather: Weather, 
val shelter: scala.collection.mutable.ArrayBuffer[Shelter], 
val soupK: scala.collection.mutable.ArrayBuffer[SoupKitchen], 
val food: scala.collection.mutable.ArrayBuffer[Food],
val water: scala.collection.mutable.ArrayBuffer[Water]) 
extends MainFrame
{
  title = "Login Resources Admin"
  preferredSize = new Dimension(700, 700)
  
  val label = new Label {font = new Font("Arial", 0, 36); text = "Local Resources Admin"}
  val passLabel = new Label {font = new Font("Arial", 0, 15); text = "Password:"}
  val passText = new TextArea {font = new Font("Arial", 0, 15)}
  var password = ""
  val login = new Button("Login")
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
  
    contents += Swing.VStrut(10)
	contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += passLabel
      border = Swing.EmptyBorder(0, 30, 0, 30)
    }
  
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += passText
      border = Swing.EmptyBorder(0, 30, 10, 30)
    }
	
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(login, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)
  listenTo(login)

  reactions += {
    case ButtonClicked(`login`) =>
      if ((passText.text).equals("PassW49"))
      {
	    val ui2 = new AdminUI(weather, shelter, soupK, food, water)
	    ui2.visible = true
	    this.dispose()
	  }
	  else
	  {
	    Dialog.showMessage(contents.head, "Wrong Password", title="Wrong Password")
	  }
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}

class AdminUI(
val weather: Weather, 
val shelter: scala.collection.mutable.ArrayBuffer[Shelter], 
val soupK: scala.collection.mutable.ArrayBuffer[SoupKitchen], 
val food: scala.collection.mutable.ArrayBuffer[Food],
val water: scala.collection.mutable.ArrayBuffer[Water]) 
extends MainFrame
{
  title = "Login Resources Admin"
  preferredSize = new Dimension(700, 700)
  
  val label = new Label {
  font = new Font("Arial", 0, 36); text = "Local Resources Admin"}
  
  val resourceLabel = new Label {
  font = new Font("Arial", 0, 15); text = "Resource:"}
  
  val resourceBox = new ComboBox(List
  ("Shelter", "Soup Kitchen", "Food", "Water", "Weather"))
  
  val nameLabel = new Label {
  font = new Font("Arial", 0, 15); text = "Name: "}
  
  val nameText = new TextArea {
  font = new Font("Arial", 0, 15)}
  
  val addressLabel = new Label {
  font = new Font("Arial", 0, 15); text = "Address: "}
  
  val addressText = new TextArea {
  font = new Font("Arial", 0, 15)}
  
  val descLabel = new Label {
  font = new Font("Arial", 0, 15); text = "Description: "}
  
  val descText = new TextArea {
  font = new Font("Arial", 0, 15)}
  
  val priceLabel = new Label {
  font = new Font("Arial", 0, 15); text = "Price: "}
  
  val priceText = new TextArea {
  font = new Font("Arial", 0, 15)}
  
  val submit = new Button("Submit")
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
  
    contents += Swing.VStrut(10)
	contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(submit, BorderPanel.Position.Center)
    }
  
	contents += Swing.VStrut(10)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += resourceLabel
      border = Swing.EmptyBorder(0, 30, 0, 30)
    }
  
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += resourceBox
      border = Swing.EmptyBorder(0, 30, 10, 30)
    }
  
    contents += Swing.VStrut(10)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += nameLabel
      border = Swing.EmptyBorder(0, 30, 0, 30)
    }
  
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += nameText
      border = Swing.EmptyBorder(0, 30, 10, 30)
    }
	
	contents += Swing.VStrut(10)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += addressLabel
      border = Swing.EmptyBorder(0, 30, 0, 30)
    }
  
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += addressText
      border = Swing.EmptyBorder(0, 30, 10, 30)
    }
    
    contents += Swing.VStrut(10)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += descLabel
      border = Swing.EmptyBorder(0, 30, 0, 30)
    }
  
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += descText
      border = Swing.EmptyBorder(0, 30, 10, 30)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(resourceBox.selection)
  listenTo(close1)
  listenTo(submit)

  reactions += {
    case SelectionChanged(`resourceBox`) =>
    {
      val choice = resourceBox.selection.item
      if (choice == "Weather")
      {
        nameLabel.text = "Temp: "
        addressLabel.text = "Humidity: "
        descLabel.text = "Warning: "
        contents = new BoxPanel(Orientation.Vertical) {
  
            contents += Swing.VStrut(10)
			contents += new BorderPanel {
			  add(label, BorderPanel.Position.Center)
			}
			
		    contents += Swing.VStrut(10)
		    contents += new BorderPanel {
		      add(close1, BorderPanel.Position.Center)
		    }
		    
		    contents += Swing.VStrut(10)
		    contents += new BorderPanel {
		      add(submit, BorderPanel.Position.Center)
		    }
			
			contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += resourceLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += resourceBox
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		  
		    contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += nameLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += nameText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
			
			contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += addressLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += addressText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		    
		    contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += descLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += descText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		    
		    for (e <- contents)
		      e.xLayoutAlignment = 0.0
		    border = Swing.EmptyBorder(0, 30, 10, 30)
		  }
      }
      else if (choice == "Food" || choice == "Water")
      {
      contents = new BoxPanel(Orientation.Vertical) {
  
  		    contents += Swing.VStrut(10)
			contents += new BorderPanel {
			  add(label, BorderPanel.Position.Center)
			}
			
		    contents += Swing.VStrut(10)
		    contents += new BorderPanel {
		      add(close1, BorderPanel.Position.Center)
		    }
		    
		    contents += Swing.VStrut(10)
		    contents += new BorderPanel {
		      add(submit, BorderPanel.Position.Center)
		    }
			
			contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += resourceLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += resourceBox
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		  
		    contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += nameLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += nameText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
			
			contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += addressLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += addressText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		    
		    contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += descLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += descText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		    
		    contents += Swing.VStrut(10)
			    contents += new BoxPanel(Orientation.Vertical) {
			      contents += priceLabel
			      border = Swing.EmptyBorder(0, 30, 0, 30)
			    }
			  
			    contents += Swing.VStrut(5)
			    contents += new BoxPanel(Orientation.Vertical) {
			      contents += priceText
			      border = Swing.EmptyBorder(0, 30, 10, 30)
			    }
		    
		    for (e <- contents)
		      e.xLayoutAlignment = 0.0
		    border = Swing.EmptyBorder(0, 30, 10, 30)
		  }
      }
      else
      {
        nameLabel.text = "Name: "
        addressLabel.text = "Address: "
        descLabel.text = "Description: "
        contents = new BoxPanel(Orientation.Vertical) {
  
  		    contents += Swing.VStrut(10)
			contents += new BorderPanel {
			  add(label, BorderPanel.Position.Center)
			}
			
		    contents += Swing.VStrut(10)
		    contents += new BorderPanel {
		      add(close1, BorderPanel.Position.Center)
		    }
		    
		    contents += Swing.VStrut(10)
		    contents += new BorderPanel {
		      add(submit, BorderPanel.Position.Center)
		    }
			
			contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += resourceLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += resourceBox
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		  
		    contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += nameLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += nameText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
			
			contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += addressLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += addressText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		    
		    contents += Swing.VStrut(10)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += descLabel
		      border = Swing.EmptyBorder(0, 30, 0, 30)
		    }
		  
		    contents += Swing.VStrut(5)
		    contents += new BoxPanel(Orientation.Vertical) {
		      contents += descText
		      border = Swing.EmptyBorder(0, 30, 10, 30)
		    }
		    
		    for (e <- contents)
		      e.xLayoutAlignment = 0.0
		    border = Swing.EmptyBorder(0, 30, 10, 30)
		  }
      }
    }
    case ButtonClicked(`submit`) =>
    {
      val choice = resourceBox.selection.item
      if (choice == "Weather")
      {
        weather.setTemp(nameText.text)
        weather.setHumidity(addressText.text)
        weather.setWarning(descText.text)
      }
      else if (choice == "Shelter")
      {
        shelter += new Shelter(nameText.text,addressText.text,descText.text)
      }
      else if (choice == "Soup Kitchen")
      {
        soupK += new SoupKitchen(nameText.text,addressText.text,descText.text)
      }
      else if (choice == "Food")
      {
        val temp: Food = new Food(nameText.text,addressText.text,descText.text)
        temp.setPrice(priceText.text)
        food += temp
      }
      else if (choice == "Water")
      {
        val temp: Water = new Water(nameText.text,addressText.text,descText.text)
        temp.setPrice(priceText.text)
        water += temp
      }
      Dialog.showMessage(contents.head,"New resource Added!",title="New resource")
      
      nameText.text = ""
      addressText.text = ""
      descText.text = ""
      priceText.text = ""
    }
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}

class WeatherUI(val weather: Weather) 
extends MainFrame
{
  title = "Login Resources - Weather"
  preferredSize = new Dimension(700, 700)
  
  val label = new Label {
  font = new Font("Arial", 0, 36); text = "Weather"}
  val warning = new Label {
  font = new Font("Arial", 0, 15); text = "Warning: "+weather.getWarning()+"\n"}
  val temp = new Label {
  font = new Font("Arial", 0, 15); text = "Temperature: "+weather.getTemp()+"\n"}
  val humidity = new Label {
  font = new Font("Arial", 0, 15); text = "Humidity: "+weather.getHumidity()+"\n"}
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
    contents += Swing.VStrut(10)
	contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
    contents += new BoxPanel(Orientation.Vertical) {
	  contents += Swing.VStrut(10)
	  contents += new BorderPanel {
	    add(warning, BorderPanel.Position.Center)
      }
	  contents += Swing.VStrut(10)
	  contents += new BorderPanel {
	    add(temp, BorderPanel.Position.Center)
      }
	  contents += Swing.VStrut(10)
	  contents += new BorderPanel {
	    add(humidity, BorderPanel.Position.Center)
      }
	  border = Swing.EmptyBorder(100,100,100,100)
	}
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)

  reactions += {
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}

class ShelterUI(val shelter: scala.collection.mutable.ArrayBuffer[Shelter]) 
extends MainFrame
{
  title = "Login Resources - Shelters"
  preferredSize = new Dimension(700, 700)
  
  val label = new Label {
  font = new Font("Arial", 0, 36); text = "Shelters"}
  val headLabel = new Label {
  font = new Font("Arial", 0, 28); text = "Name  --  Address  --  Description"}
  val close1 = new Button("Close")
  
  contents = new BoxPanel(Orientation.Vertical) {
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(headLabel, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
	var list = new scala.collection.mutable.ListBuffer[String] ()
    if (shelter.length > 0)
    {
      list = shelter(0).toString1(shelter)
    }
	val listView = new ListView(list)
    contents += new ScrollPane(listView)
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)

  reactions += {
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}

class SoupKitchenUI(val soupK: scala.collection.mutable.ArrayBuffer[SoupKitchen]) 
extends MainFrame
{
  title = "Login Resources - Soup Kitchens"
  preferredSize = new Dimension(700, 700)
  
  val label = new Label {
  font = new Font("Arial", 0, 36); text = "Soup Kitchens"}
  val headLabel = new Label {
  font = new Font("Arial", 0, 28); text = "Name  --  Address  --  Description"}
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(headLabel, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
	var list = new scala.collection.mutable.ListBuffer[String] ()
    if (soupK.length > 0)
    {
      list = soupK(0).toString1(soupK)
    }
	val listView = new ListView(list)
    contents += new ScrollPane(listView)
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)

  reactions += {
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}

class FoodUI(val food: scala.collection.mutable.ArrayBuffer[Food]) 
extends MainFrame
{
  title = "Login Resources - Food"
  preferredSize = new Dimension(700, 700)

  val label = new Label {
  font = new Font("Arial", 0, 36); text = "Food"}
  val headLabel = new Label {
  font = new Font("Arial", 0, 28); text = "Name  --  Address  --  Description  --  Price"}
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(headLabel, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
	var list = new scala.collection.mutable.ListBuffer[String] ()
    if (food.length > 0)
    {
      list = food(0).toString1(food)
    }
	val listView = new ListView(list)
    contents += new ScrollPane(listView)
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)

  reactions += {
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}

class WaterUI(val water: scala.collection.mutable.ArrayBuffer[Water]) 
extends MainFrame
{
  title = "Login Resources - Water"
  preferredSize = new Dimension(700, 700)
  
  val label = new Label {
  font = new Font("Arial", 0, 36); text = "Water"}
  val headLabel = new Label {
  font = new Font("Arial", 0, 28); text = "Name  --  Address  --  Description  --  Price"}
  val close1 = new Button("Close")

  contents = new BoxPanel(Orientation.Vertical) {
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(label, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
    contents += new BorderPanel {
	  add(headLabel, BorderPanel.Position.Center)
	}
	
	contents += Swing.VStrut(10)
    var list = new scala.collection.mutable.ListBuffer[String] ()
    if (water.length > 0)
    {
      list = water(0).toString1(water)
    }
	val listView = new ListView(list)
    contents += new ScrollPane(listView)
    
    contents += Swing.VStrut(10)
    contents += new BorderPanel {
      add(close1, BorderPanel.Position.Center)
    }
    
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(0, 30, 10, 30)
  }
  
  listenTo(close1)

  reactions += {
    case ButtonClicked(`close1`) => 
      this.dispose()
  }
}