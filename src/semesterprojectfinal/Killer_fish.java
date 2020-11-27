/*
 *IMPPLEMENT THE KILLERFISH SUBCLASS
 */
package semesterprojectfinal;


 class Killer_fish extends Fish implements Actionable,Observer{

    public Killer_fish(int x, int y, String name, int id) {
        super(x, y, name, id);
    }       
    
    @Override
    public void action_toward_warrior(Warrior w) {
        
        /*handle the condition when the warrior is immortal*/
        if(w.isImmortal()==true){
            System.out.println(w.getName()+" IS IMMORTAL.CANNOT KILL");            
        /*handle the condition when the warrior is not immortal*/
        }else{
            System.out.println(w.getName()+"  KILLED");
            w.setAlive(false);
            SemesterProjectFinal.totalNumberofInhabitant-=1;
            
          
        }
       
            
    }

    @Override
    public void update(Inhabitant inhabitant) {
        action_toward_warrior((Warrior) inhabitant);
    }
    
    
}
