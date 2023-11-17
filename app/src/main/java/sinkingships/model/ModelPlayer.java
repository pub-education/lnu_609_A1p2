package sinkingships.model;

/**
 * Abstract class for a player.
 */
public abstract class ModelPlayer {

  private String name;
  
  public ModelPlayer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
