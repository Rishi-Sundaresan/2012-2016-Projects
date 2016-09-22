public class PlanetarySystem
{
  private String name;
  private Double starmass;
  private Double starluminosity;
  private Double starradius;
  private Double startemp;
  private Double starvelocity;
  private Double planetmass;
  private Double planetluminosity;
  private Double planetradius;
  private Double planettemp;
  private Double planetvelocity;
  private Double distance;
  private Double period;
  private Double albedo;

  
  public PlanetarySystem(String _name, Double _starmass, Double _starluminosity, Double _starradius, Double _startemp, Double _starvelocity,
                         Double _planetmass, Double _planetluminosity, Double _planetradius, Double _planettemp, Double _planetvelocity,
                         Double _distance, Double _period, Double _albedo)
  {
    name = _name;
    starmass = _starmass;
    starluminosity = _starluminosity;
    starradius = _starradius;
    startemp = _startemp;
    starvelocity = _starvelocity;
    planetmass = _planetmass;
    planetluminosity = _planetluminosity;
    planetradius = _planetradius;
    planettemp = _planettemp;
    planetvelocity = _planetvelocity;
    distance = _distance;
    period = _period;
    albedo = _albedo;
  }
  
  public String getName()
  {
    return name;
  }
  public Double getStarMass()
  {
    return starmass;
  }
  public Double getStarLuminosity()
  {
    return starluminosity;
  }
  public Double getStarRadius()
  {
    return starradius;
  }
  public Double getStarTemp()
  {
    return startemp;
  }
  public Double getStarVelocity()
  {
    return starvelocity;
  }
  public Double getPlanetMass()
  {
    return planetmass;
  }
  public Double getPlanetLuminosity()
  {
    return planetluminosity;
  }
  public Double getPlanetRadius()
  {
    return planetradius;
  }
  public Double getPlanetTemp()
  {
    return planettemp;
  }
  public Double getPlanetVelocity()
  {
    return planetvelocity;
  }
  public Double getDistance()
  {
    return distance;
  }
  public Double getPeriod()
  {
    return period;
  }
  public Double getAlbedo()
  {
    return albedo;
  }
  public boolean isHabitable()
  {
    return (getPlanetTemp() >= 255 && getPlanetTemp() <= 355);
  }
  
  @Override
  public String toString()
  {
    return "" + name + " Planet Mass: "+ getPlanetMass() + " Planet Equilibrium Temperature: " + getPlanetTemp();
  }
                    
                         
}