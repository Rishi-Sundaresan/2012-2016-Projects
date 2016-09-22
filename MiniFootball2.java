import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JOptionPane;


import java.util.*;


@SuppressWarnings("serial")
public class MiniFootball2 extends JPanel implements KeyListener{
  ArrayList<Ellipse2D.Double> offense = new ArrayList<>();
  ArrayList<Ellipse2D.Double> defense = new ArrayList<>();
  
  int interceptioncount = 0;
  double an = 5.0;
  boolean win;
  //Setting Up indicators and all variables
  int intcount;
  int score;
  int moving;
  int count;
  int count1;
  int reversecount;
  boolean catc;
  boolean interception;
  boolean tackle;
  int whichwr;
  int catchw;
  int interwh;
  double xdpos;
  double ydpos;
  boolean start;
  int play;
  double level = 0;
  double moveVel;
  double w_moveVel;
  double _a2;
  int intlevel = 0;
  double _b2;
  double velup;
  double velleft;
  double reversecounter;
  boolean touchdown;
  int count2;
  ArrayList<Double> xpos_def = new ArrayList<>();
  ArrayList<Double> ypos_def = new ArrayList<>();
  ArrayList<Double> min_distance = new ArrayList<>();
  ArrayList<Double> wr_xpos = new ArrayList<>();
  ArrayList<Double> wr_ypos = new ArrayList<>();
  double a_dis;
  double q;
  double p;
  boolean bad;
  //position of ball
  double x;
  double y;
  
  
  //initial position of quarterback
double xpo;
double ypo;
  
  //initial positions of wide recievers
  double w1;
  double z1;
  double w2;
  double z2;
  double w3;
  double z3;
  double w4;
  double z4;
  
  
  //initial positions of defenders
  
  double d1;
  double e1;
  
  double d2;
  double e2;
  
  double d3;
  double e3;
  
  double d4;
  double e4;
  
  double d5;
  double e5;
  
  double d6;
  double e6;;
  

  //initial velocities of wide recievers
  double a1;
  double b1;
  double a2;
  double b2;
  double a3;
  double b3;
  double a4;
  double b4;
 
  
  //defensive play
  Random r = new Random();
  
  double x1;
  double y1;//z1 - 300;
  
  double x2;//450.0;
  double y2;//500.0;
  
  double x3;//w3;
  double y3;//300.0;
  
  double x4;//w4+100;
  double y4;//100.0;
  
  double x5;//240.0;
  double y5;//100.0;
  
  double x6;//550.0;
  double y6;//300.0;
  
  
  
  private void setup()
    
  {
  //Giving values to indicators
  

    moving = 0;
   count = 0;
   count1 = 0;
   reversecount = 0;
   catc = false;
   interception = false;
   tackle = false;
   whichwr = 1;
   catchw = 0;
   interwh = 0;
   xdpos = 0.0;
   ydpos = 0.0;
   start = false;
   play = 0;
   //level = 0.0;
   moveVel = 0.0;
   w_moveVel = 0.0;
   _a2 = -4;
   _b2 = 2;
   velup = 0.0;
   velleft = 0.0;
   reversecounter = -1;
   touchdown = false;
   count2 = 0;
   bad = false;
   win = false;

  
  
  
//STOP
  
  


  //initial position of football
   x = 550.0;
   y = 700.0;
  
  //initial position of quarterback
    
   xpo = x;
   ypo = y;
  
  //initial positions of wide recievers
   w1 = 900.0;
   z1 = 700.0;
   w2 = 350.0;
   z2 = 700.0;
   w3 = 100.0;
   z3 = 700.0;
   w4 = 700.0;
   z4 = 700.0;
  
  
  //initial positions of defenders
  
   d1 = w1;
   e1 = z1 - 40;
  
   d2 = w2;
   e2 = z2-40;
  
   d3 = w3;
   e3 = z3-40;
  
   d4 = w4;
   e4 = z4 - 40;
  
   d5 = 275.0;
   e5 = 300.0;
  
   d6 = 725.0;
   e6 = 300.0;
  

  //initial velocities of wide recievers
   a1 = 1.0;
   b1 = 3.2;
   a2 = 1.0;
   b2 = 4.0;
   a3 = 0.1;
   b3 = 3.0;
   a4 = 0.0;
   b4 = 4.0;
 
  
  //defensive play
  
  
   x1 = r.nextInt(500) + 550;
   y1 = r.nextInt(300) + 250;//z1 - 300;
  
   x2 = r.nextInt(250) + 300;//450.0;
   y2 = r.nextInt(300) + 250;//500.0;
  
   x3 = r.nextInt(100)+ 450;//w3;
   y3 = r.nextInt(300) + 400;//300.0;
  
   x4 = r.nextInt(250) + 550;//w4+100;
   y4 = r.nextInt(100) + 100;//100.0;
  
   x5 = r.nextInt(250)+100;//240.0;
   y5 = r.nextInt(250) + 100;//100.0;
  
   x6 = r.nextInt(300)+650;//550.0;
   y6 = r.nextInt(250)+100;//300.0;
  
}
            

  private void ending()
  {
    moving = 2;        
    System.exit(0);
  }
  private void joption()
  {
    try

    {
      
    /*JSlider jo = new JSlider(0,10);
    JButton jb = new JButton("Next Level");
    jo.setMajorTickSpacing(1);
    jo.setValue(0);
    jo.setSnapToTicks(true);
    jo.setPaintTicks(true);
    jo.setPaintTrack(true);
    jo.setPaintLabels(true);
    jo.addChangeListener( e ->
                         {
       level = jo.getValue();
       intlevel = (int) (level);
      
    });
    jb.addActionListener ( e-> 
                          {
      level++;
      
    });
    
    setVisible(true);*/
   
    JOptionPane jy = new JOptionPane();
    JOptionPane jz = new JOptionPane();
    jy.showMessageDialog(null, Integer.toString(score),"Your Score so Far" , 1);
    
    
    
    jz.showMessageDialog(null, "Level " + Integer.toString(intlevel), "Next Level", 1);
    
    /*if( win == true)
    {
      level = Integer.parseInt(jy.showInputDialog(jb));
    } 
    else
    {
      level = Integer.parseInt(jy.showInputDialog(jo));
    }*/
    
    
    
    }
   
    catch(NumberFormatException ex)
    {
    JOptionPane jo = null;
    }
    setVisible(true);
    
  }
  
  private void defensiveplay()
  {
    count1++;
    
    if (count < 108)
    {
    double xpoint = x1-d1;
    double ypoint = y1-e1;
    double ang1 = Math.atan2(ypoint, xpoint);
    d1 = d1 + 2*level*Math.cos(ang1);
    e1 = e1 + level*Math.sin(ang1);
    
    
    xpoint = x2-d2;
    ypoint = y2-e2;
    ang1 = Math.atan2(ypoint, xpoint);
    d2 = d2 + 2*level*Math.cos(ang1);
    e2 = e2 + 2*level*Math.sin(ang1);
   
    xpoint = x3-d3;
    ypoint = y3-e3;
    ang1 = Math.atan2(ypoint, xpoint);
    d3 = d3 + 2*level*Math.cos(ang1);
    e3 = e3 + 2*level*Math.sin(ang1);
    
    xpoint = x4-d4;
    ypoint = y4-e4;
    ang1 = Math.atan2(ypoint, xpoint);
    d4 = d4 + 2*level*Math.cos(ang1);
    e4 = e4 + 2*level*Math.sin(ang1);
    
    xpoint = x5-d5;
    ypoint = y5-e5;
    ang1 = Math.atan2(ypoint, xpoint);
    d5 = d5 + 2*level*Math.cos(ang1);
    e5 = e5 + 2*level*Math.sin(ang1);
    
    xpoint = x6-d6;
    ypoint = y6-e6;
    ang1 = Math.atan2(ypoint, xpoint);
    d6 = d6 + 2*level*Math.cos(ang1);
    e6 = e6 + 2*level*Math.sin(ang1);
    }
    

  }
  
  //after cut velocity of w1

     

  
  
  //initializing variables in throwfootball calculations
    double slopex;
    double slopey;
    double velocity = 10;
    double almostangle;



    double alpha;
    double theta;
    double finalangle;
    double xvelocity;
    double yvelocity;
    
    double yv;
    double xv;
    double a;
    double b;
    double w;
    double z;
  
   
   //Constructor 
   public MiniFootball2()
   {
   addKeyListener(this);
   setFocusable(true);
   }
  
   
  //method for catch
  private void catching()
  {
    if(catchw == 1)
    {
      a = a1;
      b = b1;
    }
    if(catchw == 2)
    {
      a = a2;
      b = b2;
    }
    if(catchw == 3)
    {
      a = a3;
      b = b3;
    }
    if(catchw == 4)
    {
      a = a4;
      b = b4;
    }
    
    xv = -a;
    yv = b;
    moving = 1;
    catc = true;

    

 
  }
  
  //method for interception
  private void interception()
  {

    if (catc == false)
    {
    xv = 0;
    yv = 0;
    moving = 1;
    interception = true;
    moving = 15;
    interceptioncount++;
     
    }
    else
    {
      tackle = true;
      

        moving = 15;
      
    }
    
    

  }
  
  private int yardsgained()
  {
    if (touchdown == false)
    {


      return (int) (45-y/16);
    }
    else
    {
      return 0;
    }

    
    
  }
  

  //method for moving defenders after ball is thrown
  private void movedefenders1()
  {
    double xdv = x-d1;
    double ydv = y-e1;
    double ang = Math.atan2(ydv, xdv);
    d1 = d1 + 2*level*Math.cos(ang);
    e1 = e1 + level*Math.sin(ang);
    
  }
  private void movedefenders2()
  {
    double xdv = x-d2;
    double ydv = y-e2;
    double ang = Math.atan2(ydv, xdv);
    d2 = d2 + 2*level*Math.cos(ang);
    e2 = e2 + 2*level*Math.sin(ang);
    
  }
  private void movedefenders3()
  {
    double xdv = x-d3;
    double ydv = y-e3;
    double ang = Math.atan2(ydv, xdv);
    d3 = d3 + 2*level*Math.cos(ang);
    e3 = e3 + 2*level*Math.sin(ang);
    
  }
    private void movedefenders4()
  {
    double xdv = x-d4;
    double ydv = y-e4;
    double ang = Math.atan2(ydv, xdv);
    d4 = d4 + 2*level*Math.cos(ang);
    e4 = e4 + 2*level*Math.sin(ang);
    
  }
  private void movedefenders5()
  {
    double xdv = x-d5;
    double ydv = y-e5;
    double ang = Math.atan2(ydv, xdv);
    d5 = d5 + 2*level*Math.cos(ang);
    e5 = e5 + 2*level*Math.sin(ang);
    
  }
  private void movedefenders6()
  {
    double xdv = x-d6;
    double ydv = y-e6;
    double ang = Math.atan2(ydv, xdv);
    d6 = d6 + 2*level*Math.cos(ang);
    e6 = e6 + 2*level*Math.sin(ang);
    
  }
  
  //calculating throw angle of throwing football
  private void makeNumbers()
  {
 
    if(whichwr == 1)
    {
       w = w1;
       z = z1;
       a = a1;
       b = b1;
    }
     if(whichwr == 2)
    {
       w = w2;
       z = z2;
       a = a2;
       b = b2;
    }
      if(whichwr == 3)
    {
       w = w3;
       z = z3;
       a = a3;
       b = b3;
    }
       if(whichwr == 4)
    {
       w = w4;
       z = z4;
       a = a4;
       b = b4;
    }
      
     
     if (Math.pow(a,2) + Math.pow(b,2) == 0)
     {
    double xdv = x-w;
    double ydv = y-z;
    double ang = Math.atan2(ydv, xdv);
    xv = -velocity*Math.cos(ang);
    yv = velocity*Math.sin(ang);

     }
     else
     {
       
     double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
     double d = Math.atan(a/b);
  

     slopex = w-x;
     slopey = y - z;
     velocity = 10;
     almostangle = Math.atan2(slopex, slopey);



     alpha = 2*Math.PI-almostangle-d;
     theta = Math.asin((c*Math.sin(alpha))/velocity);
     finalangle = almostangle + theta;
     xvelocity = velocity*Math.sin(finalangle);
     yvelocity = velocity*Math.cos(finalangle);
    
     yv = yvelocity;
     xv = xvelocity;
     }
   
    
     
  }
  private double reversemove(double _moveVel, double _xpos)
  {
    if (_xpos < 0 && reversecount == 0)
    {
      reversecount++;
      return -1*_moveVel;
      
      
    }
    else
    {
      return _moveVel;
    }
    
  }
  


  //motion of the first wide reciever
  private void moveWidereciever1() 
  {
   if (w1 < 0 || w1 > 1100)
   {
     an = -an;
   }
   if (z1 < 0 || z1 > 800)
   {
     b = -b;
   }
    
   if ( count < 150)
   {
    w1 = w1 - a1;
    z1 = z1 - b1;
    count++;
   }

   else
   {
    a1 = an;
   b1 = b;
   w1 = w1 - a1;
    z1 = z1 - b1;
   }
   

  }

  
  //motion of the second wide reciever
   private void moveWidereciever2()
   {   
   if (w2 < 0 || w2 > 1050)
   {
     _a2 = 0;
   }
   if (z2 < 0 || z2 > 800)
   {
     _b2 = 0;
   }
    
   if( count < 150)
   {
    w2 = w2 - a2;
    z2 = z2 - b2;
    count++;
     
   }
   
   else
   {
     a2 = _a2;
     b2 = _b2;
     w2 = w2 - a2;
     z2 = z2 - b2;
   }
  

   
   }
   
   //motion of 3rd wide reciever
   private void moveWidereciever3()
   {
   if (w3 < 0 || w3 > 1050)
   {
     a3 = 0;
   }
   if (z3 < 0 || z3 > 800)
   {
     b3 = 0;
   }

    w3 = w3 - a3;
    z3 = z3 - b3;
   }
   
   private void moveWidereciever4()
   {
     
   //if the reciever goes out of screen, he stops
   if (w4 < 0 || w4 > 1050)
   {
     a4 = 0;
   }
   if (z4 < 0 || z4 > 800)
   {
     b4 = 0;
   }

    w4 = w4 - a4;
    z4 = z4 - b4;
   }
   //throwing the football
  private void throwfootball()
  {

    x = x+xv;
    y = y-yv;  
  }
  
  
  private void whichwrtocontrol()
  {
    x = x - velleft;
    y = y - velup;
    if(catchw == 1)
    {
      w1 = w1 - velleft;
      z1 = z1 - velup;
    }
    if(catchw == 2)
    {
      w2 = w2 - velleft;
      z2 = z2 - velup;
    }
    if(catchw == 3)
    {
      w3 = w3 - velleft;
      z3 = z3 - velup;
    }
    if(catchw == 4)
    {
      w4 = w4 - velleft;
      z4 = z4 - velup;
    }
    repaint();
  }
    //START
 


    
    public void keyPressed(KeyEvent e)
    {
      if(e.getKeyCode() == KeyEvent.VK_Y)
      {
       whichwr = 1;
        moving = 1;
       
      }
      if(e.getKeyCode() == KeyEvent.VK_R)
      {
       whichwr = 2;
        moving = 1;
       
      }
       if(e.getKeyCode() == KeyEvent.VK_E)
      {
       whichwr = 3;
        moving = 1;
       
      }
       if(e.getKeyCode() == KeyEvent.VK_T)
      {
       whichwr = 4;
        moving = 1;
       
      }
       if(e.getKeyCode() == KeyEvent.VK_S)
       {
         start = true;
       }
      if(e.getKeyCode() == KeyEvent.VK_UP)
      {
       
       velup = 0;
       velleft = 0;
       whichwrtocontrol();
       
      }
      if(e.getKeyCode() == KeyEvent.VK_DOWN)
      {
       velup = -10;
       velleft = 0;
       whichwrtocontrol();
      }
             if(e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
       velup = 0;
       velleft = -10;
       whichwrtocontrol();
             }
             if(e.getKeyCode() == KeyEvent.VK_LEFT)
      {
       velup = 0;
       velleft = 10;
       whichwrtocontrol();
       
       
      }
    
      }
    
    public void keyReleased(KeyEvent e)
    {
      
    }
    
    public void keyTyped(KeyEvent e)
    {
      
    }
    
    
  
  
   @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
  g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
  
  for(int k = 0; k < 11; k++)
  {
  g2d.draw(new Line2D.Float(0,k*80,getWidth(),k*80));
  }
  g2d.setColor(Color.GREEN);
  g2d.fillRect(0,0, getWidth(), 80);

    
  


    //yellow
    g2d.setColor(Color.YELLOW);
    Ellipse2D.Double widereciever1 = new Ellipse2D.Double(w1, z1, 30, 30);
    
    g2d.fill(widereciever1);

 
  


    g2d.setColor(Color.RED);//red
    Ellipse2D.Double widereciever2 = new Ellipse2D.Double(w2, z2, 30, 30);
    g2d.fill(widereciever2);
    
    
    g2d.setColor(new Color(0x5b,0x9C,0x64));//emerald
    Ellipse2D.Double widereciever3 = new Ellipse2D.Double(w3, z3, 30, 30);
    g2d.fill(widereciever3);
    
   //teal
    g2d.setColor(new Color(0x0F, 0xDD, 0xAF));
    Ellipse2D.Double widereciever4 = new Ellipse2D.Double(w4, z4, 30, 30);
    g2d.fill(widereciever4);

    g2d.setColor(Color.BLACK);
    Ellipse2D.Double defender1 = new Ellipse2D.Double(d1, e1, 30, 30);
    g2d.fill(defender1);
    
   
    Ellipse2D.Double defender2 = new Ellipse2D.Double(d2, e2, 30, 30);
    g2d.fill(defender2);
    
    
    Ellipse2D.Double defender3 = new Ellipse2D.Double(d3, e3, 30, 30);
    g2d.fill(defender3);
    
    
    Ellipse2D.Double defender4 = new Ellipse2D.Double(d4, e4, 30, 30);
    g2d.fill(defender4);
    
    Ellipse2D.Double defender5 = new Ellipse2D.Double(d5, e5, 30, 30);
    g2d.fill(defender5);
    
    Ellipse2D.Double defender6 = new Ellipse2D.Double(d6, e6, 30, 30);
    g2d.fill(defender6);
    
    g2d.setColor(Color.BLACK);
    Ellipse2D.Double football = new Ellipse2D.Double(x, y, 15, 10);
    g2d.fill(football);


    g2d.setColor(Color.GREEN);
    Ellipse2D.Double quarterback = new Ellipse2D.Double(xpo,ypo , 30, 30);
    g2d.fill(quarterback);
    

    
  }
  
  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Mini Football");
    MiniFootball game = new MiniFootball();



    
    frame.add(game);
    frame.setSize(1100, 800);


    frame.setVisible(true);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JOptionPane start = new JOptionPane();
    JOptionPane start1 = new JOptionPane();
    JOptionPane start2 = new JOptionPane();
    JOptionPane start3 = new JOptionPane();
    JOptionPane start4 = new JOptionPane();
    start.showMessageDialog(null, "Welcome to MiniFootball! You are the quarterback, and you have four wide recievers with their respective Keys: Emerald(E), Red(R), Turquoise(T), and Yellow (Y)" , "Instructions" , 1);
    start1.showMessageDialog(null, "When you score a touchdown(Place in green), you move on to the next Level. However, if you throw more than 3 interceptions total, the game ends.", "Instructions", 1);
    start2.showMessageDialog(null, "There are 10 total Levels, and you have predetermined plays. However, the defense (in black) does not. Use Arroy Keys to guide wide recievers left or right after the catch", "Instructions", 1);
    start3.showMessageDialog(null, "The Touchdown is 40 yards away. You get points based on how many yards you gained as well as if you scored a touchdown.", "Instructions", 1);
    start4.showMessageDialog(null, "After an Option Pane Pops up indicating which level you are in, press ok and then, when you are ready, press s and start! Good Luck!", "Instructions", 1);
    while(true)
    {
    frame.setTitle("Play!");
    game.setup();
    game.repaint();
    game.joption();

    while (game.start == false)
    {
      
      Thread.sleep(15);
    }
    

    while(game.moving == 0)
    {
    game.moveWidereciever1();
    game.moveWidereciever2();
    game.moveWidereciever3();
    game.moveWidereciever4();
    game.defensiveplay();


      game.repaint();
      Thread.sleep(15);
    }
    game.makeNumbers();
   
     while (game.moving == 1)
      {
        game.throwfootball();
        game.moveWidereciever1();
        game.moveWidereciever2();
        game.moveWidereciever3();
        game.moveWidereciever4();
        if (game.interception == false)
        {
        game.movedefenders1();
        game.movedefenders2();
        game.movedefenders3();
        game.movedefenders4();
        game.movedefenders5();
        game.movedefenders6();
        }
        game.repaint();
        Thread.sleep(15);
        
        //if player 1 catches the ball
        if(Math.pow((game.w1-game.x),2) + Math.pow((game.y-game.z1),2) < 200)
        {
         game.catchw = 1;
         game.catching();
         game.an = game.xv = 0;
         game.b = game.yv =  4;
         game.catc = true;

         
        }
        //if player 2 catches the ball
        if(Math.pow((game.w2-game.x),2) + Math.pow((game.y-game.z2),2) < 200)
        {
         game.catchw = 2;
         game.catching();
         game._a2 = game.xv = 0;
         game._b2 = game.yv =  4;
         game.catc = true;

       
        }
        
        //if player 3 catches the ball 
        if(Math.pow((game.w3-game.x),2) + Math.pow((game.y-game.z3),2) < 200)
        {
         
         game.catchw = 3;
         game.catching();
         game.a3 = game.xv = 0;
         game.b3 = game.yv =  4;
         game.catc = true;
       

        }
        //if player 4 catches the ball 
        if(Math.pow((game.w4-game.x),2) + Math.pow((game.y-game.z4),2) < 200)
        {
         
         game.catchw = 4;
         game.catching();
         game.a4 = game.xv = 0;
         game.b4 = game.yv =  4;
         game.catc = true;


        }
        
        //if the ball is intercepted by defender 1
         if(Math.pow((game.d1-game.x),2) + Math.pow((game.y-game.e1),2) < 200)
        {


          

           game.interception();


           

           if (game.interception == true)
           {
             frame.setTitle("Interception!");
           }
                           try{Thread.sleep(1303);} catch(InterruptedException ex){}

           

        }
         
         //if the ball is intercepted by defender 2
         if(Math.pow((game.d2-game.x),2) + Math.pow((game.y-game.e2),2) < 200)
        {



         game.interception();
        
           if (game.interception == true)
           {
             frame.setTitle("Interception!");
           }
                           try{Thread.sleep(1303);} catch(InterruptedException ex){}
          

        }
         
         //if the ball is intercepted by defender 3
         if(Math.pow((game.d3-game.x),2) + Math.pow((game.y-game.e3),2) < 200)
        {


           game.interception();
          
           if (game.interception == true)
           {
             frame.setTitle("Interception!");
           }
                           try{Thread.sleep(1303);} catch(InterruptedException ex){}
           

        }
        
         //if the ball is intercepted by defender 4
         if(Math.pow((game.d4-game.x),2) + Math.pow((game.y-game.e4),2) < 200)
        {



           game.interception();
           
           
           if (game.interception == true)
           {
             frame.setTitle("Interception!");
             
           }
                           try{Thread.sleep(1303);} catch(InterruptedException ex){}

           
        } 
         //if the ball is intercepted by defender 5
         if(Math.pow((game.d5-game.x),2) + Math.pow((game.y-game.e5),2) < 200)
        {


           game.interception();
   
           if (game.interception == true)
           {
             frame.setTitle("Interception!");
           }
                           try{Thread.sleep(1303);} catch(InterruptedException ex){}

          

        } 
         //if the ball is intercepted by defender 6
         if(Math.pow((game.d6-game.x),2) + Math.pow((game.y-game.e6),2) < 200)
        {


                    
           game.interception();
          
           if (game.interception == true)
           {
             frame.setTitle("Interception!");
           }
                           try{Thread.sleep(703);} catch(InterruptedException ex){}
          
           

        }
        //if the ball goes out of bounds
        if(game.x > 1250)
        {
          frame.setTitle("Out of Bounds!");
          game.moving = 15;



        }
        if(game.x < 0 && game.touchdown == false)
        {
          frame.setTitle("Out of Bounds!");
          game.moving = 15;



        }
        if(game.y > 800 && game.touchdown == false)
        {
          frame.setTitle("Out of Bounds!");
          game.moving = 15;


        }
        
         if(game.y < 0 && game.touchdown == false)
        {
           frame.setTitle("Out of Bounds!");
           
           game.moving = 15;


        }

         if (game.y < 80 && game.catc == true)
         {
           frame.setTitle("Touchdown!!"); 
           game.touchdown = true;
           game.win = true;
           game.count2++;
           if( game.count2 < 2)
           {           game.moving = 15;
           }
           try{Thread.sleep(1303);} catch(InterruptedException ex){}

         }
         
         
         if (game.catc == false && game.tackle == true)
         {
           game.catc = true;
         }

         if (game.touchdown == false && game.tackle == true && game.catc == true)
           
         {
           
          

           frame.setTitle(Integer.toString(game.yardsgained()) + " Yards Gained");
         

         }
         
         


        }
                try{Thread.sleep(903);} catch(InterruptedException ex){}
       if (game.touchdown == true)
       {
         game.score = game.score + (int) (game.level*7.0);
         
       }
       else if (game.catc == true)
       {
         game.score = game.score + (int) (game.level*(45.0-game.y/16.0)/10.0);
       }
       
     if(game.win == true && game.interception == false)
    {
      game.intlevel++;
      game.level++;
    }
     if(game.interceptioncount > 2)
     {
       frame.setTitle("Final Score: " + Integer.toString(game.score));
       try{Thread.sleep(1003);} catch(InterruptedException ex){}
       System.exit(0);
     }
       



    

       
    }
     
     
   
    
    
    }

    


  }
   
    
 

    

  
    


