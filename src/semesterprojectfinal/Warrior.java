

package semesterprojectfinal;

import java.sql.Time;


  abstract class Warrior extends Inhabitant implements Runnable{

    
    private boolean alive=true;
    private boolean immortal=false;
    private boolean swimfins=true;    
    protected int energyBar=50; //max=100
    private static boolean found=false;
    protected TreasureChest t;
    private boolean abilityToSwim=true;
    private long startTime;
    private long endTime;
    
    

    public Warrior(int x, int y, String name, int id) {
        super(x, y, name, id);        
        t=new TreasureChest();
        t.addWarriorObservers(this);
        setStartTime(System.currentTimeMillis());
    }

    
    @Override
    public void run(){
        while(getFound()==false && GridLocation.getlocationobject(5, 5).getInhabitantlist().size()==0){
            try {
                swim();
                Thread.sleep(100);
            } catch (InterruptedException ex) {}          
           
        }                              
    }        
      
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        if(alive==false){
            this.setAbilityToSwim(false);
            GridLocation.getlocationobject(this.getX(), this.getY()).removeInhabitant();
            t.removeWarriorObserver(this);
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
    
    
    public void swim() throws InterruptedException{
        if( this.isAlive()==true && getFound()==false && isAbilityToSwim()==true){
        int x=getX();
        int y=getY();
        GridLocation nextlocation;
        
        GridLocation currentLocation=GridLocation.getlocationobject(x, y);
            if(x<5 && y<5){ //      x+1
                nextlocation=GridLocation.getlocationobject(x+1, y);
                synchronized(nextlocation){
                    if(nextlocation.checkAbilityToSwim()==true){                   
                        currentLocation.removeInhabitant();
                        setX(x+1);setEnergyBar();
                        System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                        nextlocation.setInhabitant(this);  
                        Thread.sleep(10);
                        t.checkWarriorFound(this);
                                                          
                    }else{                    
                    //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());
                   
                    }
                    
                }
                
           
          
           
        }else if(x>5 && y<5){ // x-1
            nextlocation=GridLocation.getlocationobject(x-1, y);
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){               
                    currentLocation.removeInhabitant();
                    setX(x-1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);  
                    Thread.sleep(10);
                    t.checkWarriorFound(this);
                
                }else{
                    //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());
                }
                
            }
            
           
           
        }else if(x<5 && y>5){ //x+1
            nextlocation=GridLocation.getlocationobject(x+1, y);            
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){              
                    currentLocation.removeInhabitant();
                    setX(x+1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    Thread.sleep(10);                    
                    t.checkWarriorFound(this);
                                
                }else{
                   //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());
                 
              
                }
                
            }
            
           
        }else if (x>5 && y>5){ //            setX(x-1);
            nextlocation=GridLocation.getlocationobject(x-1, y);
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){              
                    currentLocation.removeInhabitant();
                    setX(x-1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this); 
                    Thread.sleep(10);
                    t.checkWarriorFound(this);
                                   
                
                }else{
                    //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());

                }
                
            }
            
            
            
        }else if(x==5 && y<5){  //            setY(y+1);
            nextlocation=GridLocation.getlocationobject(x, y+1);
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){                
                    currentLocation.removeInhabitant();
                    setY(y+1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    Thread.sleep(10);                    
                    t.checkWarriorFound(this);
                
                }else{
                    //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());

                }
                
            }
            
            
        }else if (x>5 && y==5){ //            setX(x-1);
            nextlocation=GridLocation.getlocationobject(x-1, y);
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){                
                    currentLocation.removeInhabitant();
                    setX(x-1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");                    
                    nextlocation.setInhabitant(this);
                    Thread.sleep(10);
                    t.checkWarriorFound(this);
                                                    
                }else{
                    //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());
                }
            }
            

        }else if(x==5 && y>5 ){ //            setY(y-1);
            nextlocation=GridLocation.getlocationobject(x, y-1);
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){                
                    currentLocation.removeInhabitant();
                    setY(y-1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    Thread.sleep(10);
                    t.checkWarriorFound(this);
                                                   
                }else{
                    //System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());
                }

            }
            

        }else if(y==5 && x<5 ){ //            setX(x+1);
            nextlocation=GridLocation.getlocationobject(x+1, y);
            synchronized(nextlocation){
                if(nextlocation.checkAbilityToSwim()==true){                       
                    currentLocation.removeInhabitant();
                    setX(x+1);setEnergyBar();
                    System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                    nextlocation.setInhabitant(this);
                    Thread.sleep(10);
                    t.checkWarriorFound(this);
                  
                
                }else{
                   // System.out.println(getName()+" cannot swim to ("+nextlocation.getX()+" "+nextlocation.getY()+ ")location.current location  "+getX()+" "+getY());
                }                
            }
            
        }
        } 
        
    
    }
    
    public void checkTreasure(){
        if (getX()==5 && getY()==5){
            setFound();
            t.setWarriorFound(this);
        }
    }

    public static void setFound() {
        found=true;
        
    }
    public static boolean getFound(){
        return found;
    }  

    public boolean isAbilityToSwim() {
        return abilityToSwim;
    }
    
    public void setAbilityToSwim(boolean abilityToSwim) {
        this.abilityToSwim = abilityToSwim;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long time) {
        this.startTime = time;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    public int getEnergyBar() {
        return energyBar;
    }

    
    public void setEnergyBar() {
        if(energyBar<100){
            energyBar++;
        }
    }
    
    
    public void getNotifyFromChest(){
        this.setAbilityToSwim(false);
    }
    
    
}

