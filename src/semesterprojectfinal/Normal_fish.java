/*

 */
package semesterprojectfinal;

/**
 *
 * @author HP
 */
 class Normal_fish extends Fish implements Actionable,Observer{

    public Normal_fish(int x, int y, String name, int id) {
        super(x, y, name, id);
    }

    @Override
    public void action_toward_warrior(Warrior w) {
        System.out.println("NOTHING HAPPENS");
        w.setAlive(true);
    }

    @Override
    public void update(Inhabitant inhabitant) {
        action_toward_warrior((Warrior) inhabitant);
    }
    
    
    

    
}
