import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.util.*;
import java.awt.Component; 

public class SciBowl extends JFrame implements Runnable
{
  JPanel jp;
  JPanel other;
  JPanel stats;
  JPanel bottom;
  JTextArea st1 = new JTextArea();
  JTextArea st2 = new JTextArea();
  JTextArea st3 = new JTextArea();
  JTextArea st4 = new JTextArea();
  JTextArea st5 = new JTextArea();
  
  //new game
  JButton newgame = new JButton("New Game");
  JButton undoit = new JButton("Undo");
  JButton statistics = new JButton("Statistics");
  int statcl = -1;


  Container c;
  int undo = 1;

  Player one;
  Player two;
  Player three;
  Player four;
  Player five;
  
  //start
  
  JButton start = new JButton("Start");
  
  //isplaying
  int is1playing = 1;
  int is2playing = 1;
  int is3playing = 1;
  int is4playing = 1;
  int is5playing = 1;
  
  //names
  JButton Rishi = new JButton("Rishi");
  JButton Dylan = new JButton("Dylan");
  JButton Angela = new JButton("Angela");
  JButton Vinit = new JButton("Vinit");
  JButton Raymond = new JButton("Raymond");
  
  //Interrupt Correct
  JButton int1 = new JButton("Interrupt Correct");
  JButton int2 = new JButton("Interrupt Correct");
  JButton int3 = new JButton("Interrupt Correct");
  JButton int4 = new JButton("Interrupt Correct");
  JButton int5 = new JButton("Interrupt Correct");
  //Correct
  JButton cor1 = new JButton("Correct");
  JButton cor2 = new JButton("Correct");
  JButton cor3 = new JButton("Correct");
  JButton cor4 = new JButton("Correct");
  JButton cor5 = new JButton("Correct");
  
  //Incorrect
  JButton incor1 = new JButton("Incorrect");
  JButton incor2 = new JButton("Incorrect");
  JButton incor3 = new JButton("Incorrect");
  JButton incor4 = new JButton("Incorrect");
  JButton incor5 = new JButton("Incorrect");
  
  //Interrupt Incorrect
  JButton neg1 = new JButton("Interrupt Incorrect");
  JButton neg2 = new JButton("Interrupt Incorrect");
  JButton neg3 = new JButton("Interrupt Incorrect");
  JButton neg4 = new JButton("Interrupt Incorrect");
  JButton neg5 = new JButton("Interrupt Incorrect");
  
  //Will Play
  JButton play1 = new JButton("Playing");
  JButton play2 = new JButton("Playing");
  JButton play3 = new JButton("Playing");
  JButton play4 = new JButton("Playing");
  JButton play5 = new JButton("Playing");
  
  
  
  public void run()
  {
    setSize(1200,500);
    Container c = getContentPane();
    jp = new JPanel(new GridLayout(6,5));
    other = new JPanel(new GridLayout(3,1));
    stats = new JPanel(new GridLayout(3,1));
    bottom = new JPanel(new GridLayout(5,1));
    c.add(BorderLayout.NORTH, jp);
    c.add(BorderLayout.WEST, other);
    c.add(BorderLayout.EAST, stats);
    c.add(BorderLayout.SOUTH, bottom);
   
    makePlayers();
    makeframe();
    actionListeners();
    able(0);

    

    setVisible(true);
  }
  
  private void textArea()
  {

   st1.insert("     Rishi----- Current (Average) - Score:" + one.score +" (" + one.getScorePerGame() + ")" 
               + "   InterruptCorrect:"+ one.intcor + " (" + one.intcor/one.games + ")" + 
                                                        "   Correct:" + one.cor + " (" + one.cor/one.games + ")"+ 
                                                        "   Incorrect:" + one.in + " (" + one.in/one.games + ")"+ 
                                                        "   Neg:" + one.neg + " (" + one.neg/one.games + ")", 1);
   
   st2.insert("     Dylan----- Current (Average) - Score:" + two.score +" (" + two.getScorePerGame() + ")" 
               + "   InterruptCorrect:"+ two.intcor + " (" + two.intcor/two.games + ")" + 
                                                        "   Correct:" + two.cor + " (" + two.cor/two.games + ")"+ 
                                                        "   Incorrect:" + two.in + " (" + two.in/two.games + ")"+ 
                                                        "   Neg:" + two.neg + " (" + two.neg/two.games + "))" , 1);
   
   st3.insert("     Angela----- Current (Average) - Score:" + three.score +" (" + three.getScorePerGame() + ")" 
               + "   InterruptCorrect:"+ three.intcor + " (" + three.intcor/three.games + ")" + 
                                                        "   Correct:" + three.cor + " (" + three.cor/three.games + ")"+ 
                                                        "   Incorrect:" + three.in + " (" + three.in/three.games + ")"+ 
                                                        "   Neg:" + three.neg + " (" + three.neg/three.games + "))" , 1);
   
   st4.insert("     Vinit----- Current (Average) - Score:" + four.score +" (" + four.getScorePerGame() + ")" 
               + "   InterruptCorrect:"+ four.intcor + " (" + four.intcor/four.games + ")" + 
                                                        "   Correct:" + four.cor + " (" + four.cor/four.games + ")"+ 
                                                        "   Incorrect:" + four.in + " (" + four.in/four.games + ")"+ 
                                                        "   Neg:" + four.neg + " (" + four.neg/four.games + "))"  , 1);
   
   st5.insert("     Raymond----- Current (Average) - Score:" + five.score +" (" + five.getScorePerGame() + ")" 
               + "   InterruptCorrect:"+ five.intcor + " (" + five.intcor/five.games + ")" + 
                                                        "   Correct:" + five.cor + " (" + five.cor/five.games + ")"+ 
                                                        "   Incorrect:" + five.in + " (" + five.in/five.games + ")"+ 
                                                        "   Neg:" + five.neg + " (" + five.neg/five.games + "))" , 1);
     
  }
  private void makePlayers()
  {
    one = new Player("Rishi");
    two = new Player("Dylan");
    three = new Player("Angela");
    four = new Player("Vinit");
    five = new Player("Raymond");
  }
  
  private void makeframe()
  {
    jp.add(Rishi);
    jp.add(Dylan);
    jp.add(Angela);
    jp.add(Vinit);
    jp.add(Raymond);
    
    jp.add(int1);
    jp.add(int2);
    jp.add(int3);
    jp.add(int4);
    jp.add(int5);
    
    jp.add(cor1);
    jp.add(cor2);
    jp.add(cor3);
    jp.add(cor4);
    jp.add(cor5);
    
    jp.add(incor1);
    jp.add(incor2);
    jp.add(incor3);
    jp.add(incor4);
    jp.add(incor5);
    
    jp.add(neg1);
    jp.add(neg2);
    jp.add(neg3);
    jp.add(neg4);
    jp.add(neg5);
    
    jp.add(play1);
    jp.add(play2);
    jp.add(play3);
    jp.add(play4);
    jp.add(play5);
    
    other.add(undoit);
    other.add(newgame);
    other.add(start);
    stats.add(statistics);
    bottom.add(st1);
    bottom.add(st2);
    bottom.add(st3);
    bottom.add(st4);
    bottom.add(st5);
    
  
  }
  private void resetundo()
  {
    if(undo == -1)
    {
      undo = 1;
      undoit.setOpaque(false);
      undoit.setBackground(Color.white);
    }
    
    System.out.println("Rishi Score/Game:" + one.getScorePerGame() + " Score:" + one.getScore() + " InterruptCorrect:" + one.intcor + " Correct:" + one.cor + " Incorrect:" + one.in + " Neg:" + one.neg);
    System.out.println("Dylan Score/Game:" + two.getScorePerGame() + " Score:" + two.getScore() + " InterruptCorrect:" + two.intcor + " Correct:" + two.cor + " Incorrect:" + two.in + " Neg:" + two.neg);
    System.out.println("Angela Score/Game:" + three.getScorePerGame() + " Score:" + three.getScore() + " InterruptCorrect:" + three.intcor + " Correct:" + three.cor + " Incorrect:" + three.in + " Neg:" + three.neg);
    System.out.println("Vinit Score/Game:" + four.getScorePerGame() + " Score:" + four.getScore() + " InterruptCorrect:" + four.intcor + " Correct:" + four.cor + " Incorrect:" + four.in + " Neg:" + four.neg);
    System.out.println("Raymond Score/Game:" + five.getScorePerGame() + " Score:" + five.getScore() + " InterruptCorrect:" + five.intcor + " Correct:" + five.cor + " Incorrect:" + five.in + " Neg:" + five.neg);
    System.out.println("___________________________________________________________");
    System.out.println("");

  }
  
  
  private void setPlaying(int thing, JButton but)
  {
    if( thing == -1)
    {
      but.setText("Not Playing");
    }
    if( thing == 1)
    {
      but.setText("Playing");
    }
  }
  private void actionListeners()
  {
    //Statistics
    statistics.addActionListener( e->{
     statcl = -statcl;  
     if(statcl == -1)
     {
       st1.setText("");
       st2.setText("");
       st3.setText("");
       st4.setText("");
       st5.setText("");
     }
     if(statcl == 1)
     {
       textArea();
     }
    });

    
    undoit.addActionListener( e-> {
       undo = -undo;
       undoit.setBackground(Color.red);
       undoit.setOpaque(true);
    });
    
    newgame.addActionListener(e-> {
      play1.setEnabled(true);
      play2.setEnabled(true);
      play3.setEnabled(true);
      play4.setEnabled(true);
      play5.setEnabled(true);


 

      
      JOptionPane jo = new JOptionPane();
      jo.showConfirmDialog(null, "Set Players and Press Start", "New Game", 1);
    });
    
    start.addActionListener(e-> {
   
      //
      int reply = JOptionPane.showConfirmDialog(null, "Are all Players Set and Are you sure you want to start?", "Start", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          if(is1playing == 1)
          {
            one.games++;
          }
          if(is2playing == 1)
          {
            two.games++;
          }
          if(is3playing == 1)
          {
            three.games++;
          }
          if(is4playing == 1)
          {
            four.games++;
          }
          if(is5playing == 1)
          {
            five.games++;
          }
          play1.setEnabled(false);
          play2.setEnabled(false);
          play3.setEnabled(false);
          play4.setEnabled(false);
          play5.setEnabled(false);

        }
        else {

           
        }
      //
            able(1);
      
      
      
    });
    
    
    //playing buttons
    play1.addActionListener( e-> {
      is1playing = -is1playing;
      setPlaying(is1playing, play1);
    });
    play2.addActionListener( e-> {
      is2playing = -is2playing;
      setPlaying(is2playing, play2);
    });
    play3.addActionListener( e-> {
      is3playing = -is3playing;
      setPlaying(is3playing, play3);
    });
    play4.addActionListener( e-> {
      is4playing = -is4playing;
      setPlaying(is4playing, play4);
    });
    play5.addActionListener( e-> {
      is5playing = -is5playing;
      setPlaying(is5playing, play5);
    });
    
    //interrupt correct answers
    int1.addActionListener( e-> {
      one.intcor = one.intcor + undo*1;
      resetundo();

    });
    
    int2.addActionListener( e-> {
      two.intcor = two.intcor + undo*1;
      resetundo();

    });
    
    int3.addActionListener( e-> {
      three.intcor = three.intcor + undo*1;
      resetundo();

    });
    
    int4.addActionListener( e-> {
      four.intcor = four.intcor + undo*1;
      resetundo();

    });
    
    int5.addActionListener( e-> {
      five.intcor = five.intcor + undo*1;
      resetundo();

    });
    
     // correct answers
    cor1.addActionListener( e-> {
      one.cor = one.cor + undo*1;
      resetundo();

    });
    cor2.addActionListener( e-> {
      two.cor = two.cor + undo*1;
      resetundo();

    });
    cor3.addActionListener( e-> {
      three.cor = three.cor + undo*1;
      resetundo();

    });
    cor4.addActionListener( e-> {
      four.cor = four.cor + undo*1;
      resetundo();

    });
    cor5.addActionListener( e-> {
      five.cor = five.cor + undo*1;
      resetundo();

    });
    
    
    //incorrect
    incor1.addActionListener( e-> {
      one.in = one.in + undo*1;
      resetundo();

    });
    incor2.addActionListener( e-> {
      two.in = two.in + undo*1;
      resetundo();

    });
    incor3.addActionListener( e-> {
      three.in = three.in + undo*1;
      resetundo();

    });
    incor4.addActionListener( e-> {
      four.in = four.in + undo*1;
      resetundo();

    });
    incor5.addActionListener( e-> {
      five.in = five.in + undo*1;
      resetundo();

    });
    
    //negs
    neg1.addActionListener( e-> {
      one.neg = one.neg + undo*1;
      resetundo();

    });
    neg2.addActionListener( e-> {
      two.neg = two.neg + undo*1;
      resetundo();

    });
    neg3.addActionListener( e-> {
      three.neg = three.neg + undo*1;
      resetundo();

    });
    neg4.addActionListener( e-> {
      four.neg = four.neg + undo*1;
      resetundo();

    });
    neg5.addActionListener( e-> {
      five.neg = five.neg + undo*1;
      resetundo();

    }); 
    
  }
  
  //disable stuff until game starts
  private void able(int k)
  {
    int1.setEnabled((k!=0));
    int2.setEnabled((k!=0));
    int3.setEnabled((k!=0));
    int4.setEnabled((k!=0));
    int5.setEnabled((k!=0));
    
    cor1.setEnabled((k!=0));
    cor2.setEnabled((k!=0));
    cor3.setEnabled((k!=0));
    cor4.setEnabled((k!=0));
    cor5.setEnabled((k!=0));
    
    incor1.setEnabled((k!=0));
    incor2.setEnabled((k!=0));
    incor3.setEnabled((k!=0));
    incor4.setEnabled((k!=0));
    incor5.setEnabled((k!=0));
    
    neg1.setEnabled((k!=0));
    neg2.setEnabled((k!=0));
    neg3.setEnabled((k!=0));
    neg4.setEnabled((k!=0));
    neg5.setEnabled((k!=0));
    
    play1.setEnabled((k !=0));
    play2.setEnabled((k !=0));
    play3.setEnabled((k !=0));
    play4.setEnabled((k !=0));
    play5.setEnabled((k !=0));
  }
  
  public static void main(String[] args)
  {
    SciBowl s = new SciBowl();
    javax.swing.SwingUtilities.invokeLater(s);  
    
  }
}