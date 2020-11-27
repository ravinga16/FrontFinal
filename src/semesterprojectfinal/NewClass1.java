/*


package semesterprojectfinal;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;


public  abstract class Warrior extends Inhabitant implements Runnable{

    
    private boolean alive=true;
    private boolean immortal=false;
    private boolean swimfins=true;
    private boolean binocular;
    protected int energyBar=50; //max=100
    private static boolean found=false;
    protected ArrayList<GridLocation> vicinity;
    protected TreasureChest t;

    public Warrior(int x, int y, String name, int id) {
        super(x, y, name, id);
        vicinity=new ArrayList<>();
        t=new TreasureChest();
        t.addWarriorObservers(this);
        
    }

    
    @Override
    public void run(){
        while(getFound()==false && GridLocation.getlocationobject(5, 5).getInhabitantlist().size()==0){
            try {
                swim();
                Thread.sleep(200);
            } catch (InterruptedException ex) {
              
            }
        }     
              
                
    }        
      
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        if(alive==false){
            GridLocation.getlocationobject(this.getX(), this.getY()).removeInhabitant();
        }
    }

    public boolean isImmortal() {
        return immortal;
    }

    public void setImmortal(boolean immortal) {
        this.immortal = immortal;
    }

    
    public boolean isSwimfins() {
        return swimfins;
    }

   
    public void setSwimfins(boolean swimfins) {
        this.swimfins = swimfins;
        if(swimfins==false){
            GridLocation.getlocationobject(this.getX(), this.getY()).removeInhabitant();
            this.setX(0);
            this.setY(0);
            this.setSwimfins(true);
        }
        
    }

    public boolean isBinocular() {
        return binocular;
    }

    public void setBinocular(boolean binocular) {
        this.binocular = binocular;
    }
    
    public void swim() throws InterruptedException{
        if( this.isAlive()==true && getFound()==false ){
        int x=getX();
        int y=getY();
        GridLocation nextlocation;
        
        GridLocation currentLocation=GridLocation.getlocationobject(x, y);
            if(x<5 && y<5){ //      x+1
                nextlocation=GridLocation.getlocationobject(x+1, y);
                synchronized(nextlocation){
                    if(nextlocation.checkAbilityToSwim()==true){
                    synchronized(nextlocation){
                        currentLocation.removeInhabitant();
                        setX(x+1);
                        System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                        nextlocation.setInhabitant(this);  
                        //Thread.sleep(1000);
                        checkTreasure();
                        Thread.sleep(10);
                       
                    }
                    
                    
                }else{
                    
                    System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                    Thread.sleep(1000);
                   
                }
                    
                }
                
           
          
           
        }else if(x>5 && y<5){ // x-1
            nextlocation=GridLocation.getlocationobject(x-1, y);
            if(nextlocation.checkAbilityToSwim()==true){
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setX(x-1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    //Thread.sleep(1000);
                           
                    checkTreasure();
                    Thread.sleep(10);
                }
                
            }else{
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
            }
           
           
        }else if(x<5 && y>5){ //x+1
            nextlocation=GridLocation.getlocationobject(x+1, y);
            if(nextlocation.checkAbilityToSwim()==true){
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setX(x+1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    //Thread.sleep(1000);
                    
                    checkTreasure();
                    Thread.sleep(10);
                   
                }
                
            }else{
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
              
            }
           
        }else if (x>5 && y>5){ //            setX(x-1);
            nextlocation=GridLocation.getlocationobject(x-1, y);
            if(nextlocation.checkAbilityToSwim()==true){
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setX(x-1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    //Thread.sleep(1000);
                    
                    checkTreasure();
                    Thread.sleep(10);
                
                    
                }
                
            }else{
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
               
            }
            
        }else if(x==5 && y<5){  //            setY(y+1);
            nextlocation=GridLocation.getlocationobject(x, y+1);
            if(nextlocation.checkAbilityToSwim()==true){
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setY(y+1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    //Thread.sleep(1000);
                    
                    checkTreasure();
                    Thread.sleep(10);
                
                }
                
            }else{
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
             
            }
            
        }else if (x>5 && y==5){ //            setX(x-1);
            nextlocation=GridLocation.getlocationobject(x-1, y);
            if(nextlocation.checkAbilityToSwim()==true){
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setX(x-1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    //Thread.sleep(1000);
                    
                    checkTreasure();
                    Thread.sleep(10);
                
                    
                }
                
            }else{
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
            }

        }else if(x==5 && y>5 ){ //            setY(y-1);
            nextlocation=GridLocation.getlocationobject(x, y-1);
            if(nextlocation.checkAbilityToSwim()==true){
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setY(y-1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this); 
                    //Thread.sleep(1000);
                    
                    checkTreasure();
                    Thread.sleep(10);
                
                    
                }
                
            }else{
                
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
            }

        }else if(y==5 && x<5 ){ //            setX(x+1);
            nextlocation=GridLocation.getlocationobject(x+1, y);
            if(nextlocation.checkAbilityToSwim()==true){
                
                synchronized(nextlocation){
                    currentLocation.removeInhabitant();
                    setX(x+1);
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    //Thread.sleep(1000);
                    
                    checkTreasure();
                    Thread.sleep(10);
                    
                }
                
            }else{
                System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                Thread.sleep(1000);
            }

        }
        }//else dala thibbe.to indicate that the warrior is dead. 
        
    
    }
    
    public void checkTreasure(){
        if (getX()==5 && getY()==5){
            setFound();
            t.setWarriorFound(this);
            
        }
    }

    public void notifyTreasureChest(){
        TreasureChest.FinishGame();
    }
    public static void setFound() {
        found=true;
        
    }
    public static boolean getFound(){
        return found;
    }
   
    public void notifyall(){
        System.out.println("CHEST FOUND "+"WINNER IS "+GridLocation.getlocationobject(5, 5).getInhabitantlist().get(0).getName());
                     
    }
    
    public void addVicinity() {
        int x=this.getX();
        int y=this.getY();
        try {
            this.vicinity.add(GridLocation.getlocationobject(x+1, y));
            this.vicinity.add(GridLocation.getlocationobject(x-1, y));
            this.vicinity.add(GridLocation.getlocationobject(x, y+1));
            this.vicinity.add(GridLocation.getlocationobject(x, y-1));
        } catch (NullPointerException e) {
            
        }
        
    } 
}


*/
