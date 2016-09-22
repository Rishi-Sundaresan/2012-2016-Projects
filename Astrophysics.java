import javax.swing.*;
import java.awt.GridLayout;

public class Astrophysics extends JFrame implements Runnable
{
  JTextField jt1;
  JTextField jt2;
  JTextField jt3;
  JTextField ans = new JTextField("");
  JPanel jp;

  
  public void run()
  {
    setSize(1200,50);
    jp = new JPanel(new GridLayout(2,13));
    exoplanetTemperature();
    add(jp);
    setVisible(true);
  }
  
  public void exoplanetTemperature()
  {
    
    jp.add(new JLabel("Stellar Luminosity"));
    jt1 = new JTextField("1");
    jt1.setEditable(true);
    jt1.addActionListener( e-> {
      getPlanetTemp();
    });
    jp.add(jt1);
    jp.add(new JLabel("solar luminosities"));
    jp.add(new JLabel(""));
    jp.add(new JLabel("Planet Distance"));
    jt2 = new JTextField("1");
    jt2.setEditable(true);
    jp.add(jt2);
    jt2.addActionListener( e-> {
      getPlanetTemp();
    });
    jp.add(new JLabel("AU"));
    jp.add(new JLabel(""));
    jp.add(new JLabel("Planet Albedo"));
    jt3 = new JTextField("0");
    jt3.setEditable(true);
    jt3.addActionListener( e-> {
      getPlanetTemp();
    });
    jp.add(jt3);
    jp.add(new JLabel(""));
    jp.add(new JLabel("Planet Temp"));
    getPlanetTemp();
    ans.setEditable(true);


    jp.add(ans);
    jp.add(new JLabel("K"));

    for( int k = 0; k<13; k++)
    {
      jp.add(new JLabel("I"));
    }
    
    
    
    

  }
  
  public void getPlanetTemp()
  {

    Double l = Double.parseDouble(jt1.getText());
    Double d = Double.parseDouble(jt2.getText());
    Double a = Double.parseDouble(jt3.getText());
    Double e = (278.529*Math.pow(l*(1-a)/Math.pow(d,2),0.25));
    int er = e.intValue();
    System.out.println(er);
    ans.setText(String.valueOf(er));
    
  }
  public static void main(String[] args)
  {
    Astrophysics a = new Astrophysics();
    javax.swing.SwingUtilities.invokeLater(a);
  }
}