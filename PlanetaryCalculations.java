import javax.swing.*;
import java.awt.*;
import java.util.*;
//default albedo is -0.5, dont worry about it


/*Summary of how it works
 * When user inputs something into JTextField, it parses it into a double. the variable that the Jtextfield is assigned to
 * points at the double value. Next, using the variable, the program does the calculations and spitss out the final variable
 * the jtextifeld sets its text to the string representation of the variable value, and its done
 * 
 * */
public class Calculations extends JFrame implements Runnable
{
  JPanel jp;
  
  double starmass = 0;
  JTextField _starmass;
  double starluminosity = 0;
  JTextField _starluminosity;
  double starradius = 0;
  JTextField _starradius;
  double startemp = 0;
  JTextField _startemp;
  double starvel = 0;
  JTextField _starvel;
  
  double planetmass = 0;
  JTextField _planetmass;
  double planetluminosity = 0;
  JTextField _planetluminosity;
  double planetradius = 0;
  JTextField _planetradius;
  double planettemp = 0;
  JTextField _planettemp;
  double planetvel = 0;
  JTextField _planetvel;
  double period;
  JTextField _period;
  double distance;
  JTextField _distance;
  double albedo = -0.5;
  JTextField _albedo;
  
  double masssig;
  boolean ismasssig = false;
  

  

  //initializes textfields and adds action listeners to them that pretty much turn the text into a double
  public void listeners()
  {
  _starmass = new JTextField("");
  _starmass.addActionListener( e-> {
    starmass = Double.parseDouble(_starmass.getText());
    //display();

  });
  
  
  _starluminosity = new JTextField("");
  _starluminosity.addActionListener( e-> {
    starluminosity = Double.parseDouble(_starluminosity.getText());  
    //display();
 
  });
  
  _starradius = new JTextField("");
  _starradius.addActionListener( e-> {
    starradius = Double.parseDouble(_starradius.getText());
    //display();

  });
  
  _startemp = new JTextField("");
  _startemp.addActionListener( e-> {
    startemp = Double.parseDouble(_startemp.getText());
    //display();

  });
  
  _starvel = new JTextField("");
    _starvel.addActionListener( e-> {
    starvel = Double.parseDouble(_starvel.getText());
    //display();

    });
    
  _planetmass = new JTextField("");
    _planetmass.addActionListener( e-> {
      planetmass = Double.parseDouble(_planetmass.getText());

      //display();
    });
  _planetluminosity = new JTextField("");
    _planetluminosity.addActionListener( e-> {
      planetluminosity = Double.parseDouble(_planetluminosity.getText());
      //display();
    });
  _planetradius = new JTextField("");
    _planetradius.addActionListener( e-> {
      planetradius = Double.parseDouble(_planetradius.getText());
      //display();
    });
  _planettemp = new JTextField("");
    _planettemp.addActionListener( e-> {
      planettemp = Double.parseDouble(_planettemp.getText());
      //display();
    });
  _planetvel = new JTextField("");
    _planetvel.addActionListener( e-> {
      planetvel = Double.parseDouble(_planetvel.getText());
      //display();
    });
  _period = new JTextField("");
    _period.addActionListener( e-> {
      period = Double.parseDouble(_period.getText());
      //display();
    });
    
  _distance = new JTextField("");
    _distance.addActionListener( e-> {
      distance = Double.parseDouble(_distance.getText());
      //display();
    });
  _albedo = new JTextField("");
    _albedo.addActionListener( e-> {
      albedo = Double.parseDouble(_albedo.getText());
      //display();
    });
    
  }
  


  //does the calculations and seting up calculating numbers numerous times to ensure chain reaction has completeed.
  //the method calc must be done multiple times, since variables that are initally 0.0 (not inputted) are calculated and become numbers
  //new calculations can be done with the variables, so calc() must be run a lot of times to make sure all calculations are done
  public void display()
  {
      if(ismasssig)
      {
      masssig = planetmass;
      }
      else
      {
        masssig = 0.0;
      }
    for(int k = 0; k < 13; k++)
    {
        calc();
  starset();
    }
    sigfigs();
  }
  
  //run method
  public void run()
  {
    setSize(1600,400);
    jp = new JPanel(new GridLayout(4, 9));
    makelabels();
    listeners();
    addStarTextFields();
    addPlanetTextFields();
    

    add(jp);
    
    for(int k = 0; k < 4; k++)
    {
      jp.add(new JLabel(""));
    }
    JButton store = new JButton("Store");
    jp.add(store);
    for(int k = 0; k < 4; k++)
    {
      jp.add(new JLabel(""));
    }
    setVisible(true);
  }
  
  
  
  //adding star JTextFields to JPanel
  public void addStarTextFields()
  {
    jp.add(_starmass);
    jp.add(_starluminosity);
    jp.add(_starradius);
    jp.add(_startemp);
    jp.add(_starvel);
    jp.add(new JLabel("---"));
    jp.add(new JLabel("---"));
    jp.add(new JLabel("---"));
  }
  
  public void addPlanetTextFields()
  {
    jp.add(new JLabel("Planet"));
    jp.add(_planetmass);
    jp.add(_planetluminosity);
    jp.add(_planetradius);
    jp.add(_planettemp);
    jp.add(_planetvel);
    jp.add(_distance);
    jp.add(_period);
    jp.add(_albedo);
  }
  
  //sets all JTextifield text to the variable they refer to
  public void starset()
  {
    
    
    
    _starmass.setText(Double.toString(starmass));
    _starluminosity.setText(Double.toString(starluminosity));
    _starradius.setText(Double.toString(starradius));
    _startemp.setText(Double.toString(startemp));
    _starvel.setText(Double.toString(starvel));
    _planetmass.setText(Double.toString(planetmass));
    _planetluminosity.setText(Double.toString(planetluminosity));
    _planetradius.setText(Double.toString(planetradius));
    _planettemp.setText(Double.toString(planettemp));
    _planetvel.setText(Double.toString(planetvel));
    _period.setText(Double.toString(period));
    _distance.setText(Double.toString(distance));
    _albedo.setText(Double.toString(albedo));
    

  }
  
  
  
  
  
  //calculates new values based on inputted ones: if something is not inputted, it is 0, so any calculation that uses it is skipped.
  public void calc()
  {

    
    //New Stellar Luminosity
    if(starradius != 0.0 && startemp !=0.0)
    {
      try
      {
        starluminosity = Math.pow(starradius, 2)*Math.pow(startemp/5778.0, 4);
      }
      catch(ArithmeticException ex)
      {
        starluminosity = 0;
      }

    }
    
    //New Stellar Radius
    if(startemp != 0.0 && starluminosity != 0.0)
    {
      try
      {
        starradius = Math.sqrt(starluminosity/Math.pow(startemp/5778.0, 4));
        
      }
      catch(ArithmeticException ex)
      {
        starradius = 0;
        System.out.println("saved");
      }
    }
    
    //New Stellar Temperature
    
    if(starluminosity !=0 && starradius !=0)
    {
      startemp = Math.pow(starluminosity/Math.pow(starradius,2), 0.25)*5778.0;
    }
    
    //New Stellar Mass
    
    if (planetvel != 0.0 && planetmass !=0.0 && starvel !=0)
    {
      starmass = planetvel*planetmass/starvel;
    }
    if (period !=0.0 && distance != 0.0)
    {
      starmass = Math.pow(distance, 3)/(Math.pow(period/365, 2));
    }
    
    //New Stellar Velocity
    System.out.println("StarVelocity" + starvel);
   if (planetvel != 0.0 && planetmass !=0.0 && starmass !=0)
    {
      starvel = planetvel*planetmass/starmass;
   }
   
   //New Planet Mass
   if (planetvel != 0.0 && starvel !=0.0 && starmass !=0)
    {
      planetmass = starvel*starmass/planetvel;
   }
   
   //New Planet Luminosity
   if (planettemp !=0 && planetradius !=0)
   {
     planetluminosity = Math.pow(planettemp/5778, 4) * Math.pow(planetradius, 2);
   }
   
   //New Planet Radius
   if (planetluminosity !=0 && planettemp != 0)
   {
     planetradius = Math.sqrt(planetluminosity/(Math.pow(planettemp/5778.0, 4)));
   }
   
   //New Planet Temp
   if (planetluminosity !=0 && planetradius !=0)
   {
     planettemp = Math.pow(planetluminosity/Math.pow(planetradius,2), 0.25)*5778.0;
   }
  

   if (starluminosity !=0 && distance !=0 && albedo > -0.01)
   {
   planettemp = (278.529*Math.pow(starluminosity*(1-albedo)/Math.pow(distance,2),0.25));
   
   }
   
   //New Planet Velocity
   System.out.println("PlanetVelocity" + planetvel);
   if( starvel !=0 && planetmass !=0 && starmass!=0)
   {
     planetvel = starvel*starmass/planetmass;
   }
   if(period !=0 && distance !=0)
   {
     planetvel = (2*Math.PI*distance*1731456/(period));//Look at
   }

   
   //New Planet Period
   if(planetvel !=0 && distance !=0)
   {
     period = 2*Math.PI*distance*1731456/planetvel;;
   }
   
   if(distance !=0 && starmass !=0)
   {
     period = Math.sqrt(Math.pow(distance,3)/starmass)*365;
   }
   
   
   //New Planet Distance
   if(period !=0 && starmass !=0)
   {

     distance = Math.pow(starmass*Math.pow(period/365, 2), 0.33333333333333);
   }
   if(period !=0 && planetvel !=0)
   {
     distance = period*planetvel/2/Math.PI/1731456;
   }
   
   //New Planet albedo
   if(starluminosity !=0 && planettemp !=0 && distance !=0)
   {

     albedo = 1.0 - Math.pow(planettemp/278.529, 4)*Math.pow(distance,2)/starluminosity;
     if(albedo < 2.23*Math.pow(10, -16))
     {
       albedo = 0.0;
     }
   }
   System.out.println(starmass);
   System.out.println(distance);

  }
  
  //makes headers and labels for table
  public void makelabels()
  {
    JButton butt = new JButton("Calculate");
    jp.add(butt);
    butt.addActionListener( e-> {
      
      display();
    });
    jp.add(new JLabel("Mass (Solar Masses)"));
    jp.add(new JLabel("Luminosity (Solar Lum)"));
    jp.add(new JLabel("Radius (Solar Radii)"));
    jp.add(new JLabel("Temperature (Kelvin)"));
    jp.add(new JLabel("Velocity (m/s)"));
    jp.add(new JLabel("Distance b/w (AU)"));
    jp.add(new JLabel("Period of Orbit (Days)"));
    jp.add(new JLabel("            Albedo"));
    jp.add(new JLabel("Star"));
  }
  
  public void sigfigs()
  {
    ArrayList<JTextField> al = new ArrayList<>();
    ArrayList<JTextField> sci = new ArrayList<>();
    ArrayList<JTextField> nor = new ArrayList<>();
    al.add(_starmass);
    al.add(_starluminosity);
    al.add(_starradius);
    al.add(_startemp);
    al.add(_starvel);
    al.add(_planetmass);
    al.add(_planetluminosity);
    al.add(_planetradius);
    al.add(_planettemp);
    al.add(_planetvel);
    al.add(_distance);
    al.add(_period);
    al.add(_albedo);
    for(JTextField j: al)
    {
      if( j.getText().length() > 8)
      {
        if (j.getText().contains("E"))
        {
          j.setText(j.getText().substring(0,8) + j.getText().substring(j.getText().length()-4));
        }
        else
        {
          j.setText(j.getText().substring(0,9));
        }
       
      }
      
    }
  }
  

  public static void main(String[] args)
  {
    Calculations c = new Calculations();
    javax.swing.SwingUtilities.invokeLater(c);
  }
}