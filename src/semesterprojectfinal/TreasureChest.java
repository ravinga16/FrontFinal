package semesterprojectfinal;
import java.util.ArrayList;

 class TreasureChest {
    private boolean warriorFound;   //state of the treasure chest
    private GridLocation tresureChestPosition;
    public  ArrayList<Warrior> warriorObservers;
    private DataStorage d;
 
    
    public TreasureChest(){
        tresureChestPosition=GridLocation.getlocationobject(5, 5);
        warriorObservers=new ArrayList<>();
        this.d=new DataStorage();
    }
    
    // method to change the state of the chest
    public void setWarriorFound(Warrior w){
        warriorFound=true;
        notifyWarriors();    
        long timetaken=w.getEndTime()-w.getStartTime();
        d.WriteToFile(("------GAME OVER "+w.getName()+" won within "+timetaken+" ms-------"), "WarriorInfo.txt");
        //System.out.println("------GAME OVER "+w.getName()+" won within "+timetaken+" ms-------");
               
    }    
    
    // treasure chest check whether a warrior has come to the chest
    public void checkWarriorFound(Warrior w){
        if(GridLocation.getlocationobject(w.getX(), w.getY())==tresureChestPosition){
            w.setEndTime(System.currentTimeMillis());
            Warrior.setFound();
            setWarriorFound(w);
        }
    }
    
    public void addWarriorObservers(Warrior w){
        warriorObservers.add(w);
    }
    
    public void removeWarriorObserver(Warrior w){
        int i=warriorObservers.indexOf(w);
        warriorObservers.remove(i);
    }
    public void notifyWarriors(){
        for(Warrior w:warriorObservers){
            w.getNotifyFromChest();
        } 
        
    }      
}
