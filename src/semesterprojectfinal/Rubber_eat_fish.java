/*

 */
package semesterprojectfinal;


 class Rubber_eat_fish extends Fish implements Actionable,Observer{

    public Rubber_eat_fish(int x, int y, String name, int id) {
        super(x, y, name, id);
    }

    @Override
    public void action_toward_warrior(Warrior w) {
        System.out.println(w.getName()+"  LOSE HIS FINS STARTS GAME FROM 0,0");
        w.setSwimfins(false);
        
    }

    @Override
    public void update(Inhabitant inhabitant) {
        action_toward_warrior((Warrior) inhabitant);
    }
    
    

    
}
