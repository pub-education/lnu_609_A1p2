package sinkingships.model;

/**
 * Abstract class for a player.
 */
public abstract class ModelPlayer {

  private String name;
  private final int minNameLength = 1;

  /**
   * Constructor for a player.
   *
   * @param name The name of the player.
   */
  public ModelPlayer(String name) {
    try {
      checkString(name);
      this.name = name;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public String getName() {
    return name;
  }

  private void checkString(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name must not be null!");
    }

    if (name.length() < minNameLength) {
      throw new IllegalArgumentException("Name must be at least 1 character long!");
    }
  }
}
