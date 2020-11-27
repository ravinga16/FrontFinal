
package semesterprojectfinal;

import java.util.ArrayList;


 class SuperWarrior extends Warrior{
    
    private boolean binocular;
    private GridLocation lotuslocationinvicinity;   //if there is a lotus in vicinity
    private ArrayList<GridLocation> vicinity;   //location collection in vicinity

    
    public SuperWarrior(int x, int y, String name, int id) {
        super(x, y, name, id);
        vicinity=new ArrayList<>();
        setBinocular(true);
        
    }   
    
    public boolean isBinocular() {
        return binocular;
    }

    public void setBinocular(boolean binocular) {
        this.binocular = binocular;
    }
    public void addVicinity() {         //build vicinity locations list of a superwarrior,needs to check lotus
        int x=this.getX();
        int y=this.getY();
        try {
            this.vicinity.add(GridLocation.getlocationobject(x+1, y));
            this.vicinity.add(GridLocation.getlocationobject(x-1, y));
            this.vicinity.add(GridLocation.getlocationobject(x, y+1));
            this.vicinity.add(GridLocation.getlocationobject(x, y-1));
        } catch (NullPointerException e) {}
        
    }
    
    public boolean checkLotusInVicinity() throws IndexOutOfBoundsException,ArrayIndexOutOfBoundsException{      //check for lotus in his vicinity,and return true if available
        boolean lotusavailability=false;
        this.addVicinity();
        for(GridLocation gd:this.vicinity){
            try{
                if(gd.getInhabitantlist().size()==1){
                    if(gd.getInhabitantlist().get(0) instanceof LotusFlower){
                        lotusavailability=true;
                        setlotuslocationinvicinity(gd);   //setting that position for his attribute                     
                        break;
                    }
                }
            }catch(NullPointerException e){}
        }
        return lotusavailability;
    }
    
   public GridLocation getlotuslocationinvicinity(){
       return lotuslocationinvicinity;
   }
   public void setlotuslocationinvicinity(GridLocation gridLocation){
           this.lotuslocationinvicinity=gridLocation;
       
   }
  
   @Override
    public void setEnergyBar() {
        if(getEnergyBar()!=99 && getEnergyBar()<100){
            energyBar+=2;
        }else if(getEnergyBar()<100 && getEnergyBar()==99){
            energyBar+=1;
        }
    }
    
    
    
    
     /*
   @Override
   public void swim() throws InterruptedException{       
       if(checkLotusInVicinity()==true && getFound()==false && isAbilityToSwim()==true){
           GridLocation currentLocation=GridLocation.getlocationobject(this.getX(), this.getY());          
           GridLocation nextLocation=getlotuslocationinvicinity();
           synchronized(nextLocation){
               if(nextLocation.checkAbilityToSwim()==true){            
                   currentLocation.removeInhabitant();
                   this.setX(nextLocation.getX());
                   this.setY(nextLocation.getY());
                   setEnergyBar();
                   System.out.println(getName()+" swam to ("+getX()+" "+getY()+")");
                   nextLocation.setInhabitant(this);
                   Thread.sleep(10);
                   t.checkWarriorFound(this);               
               }
           }
           
       }else{
           if(getFound()==false && isAbilityToSwim()==true){
                int x=getX();
                int y=getY();
                GridLocation nextlocation;
                GridLocation currentLocation=GridLocation.getlocationobject(x, y);
                    if(x<5 && y<5){ //      x+1
                        nextlocation=GridLocation.getlocationobject(x+1, y);
                        synchronized(nextlocation){
                            if(nextlocation.checkAbilityToSwim()==true){                   
                                currentLocation.removeInhabitant();
                                setX(x+1);
                                setEnergyBar();
                                System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                                nextlocation.setInhabitant(this); 
                                Thread.sleep(10);
                                t.checkWarriorFound(this);
                            }else{

                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());

                            }

                        }




                }else if(x>5 && y<5){ // x-1
                    nextlocation=GridLocation.getlocationobject(x-1, y);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setX(x-1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this);
                            Thread.sleep(10);
                            t.checkWarriorFound(this);
                        }else{
                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                        }

                    }



                }else if(x<5 && y>5){ //x+1
                    nextlocation=GridLocation.getlocationobject(x+1, y);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setX(x+1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this);
                            Thread.sleep(10);
                            t.checkWarriorFound(this);
                        }else{
                           // System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());


                        }

                    }


                }else if (x>5 && y>5){ //            setX(x-1);
                    nextlocation=GridLocation.getlocationobject(x-1, y);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setX(x-1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this);
                            t.checkWarriorFound(this);
                        }else{
                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());

                        }
                    }
                }else if(x==5 && y<5){  //            setY(y+1);
                    nextlocation=GridLocation.getlocationobject(x, y+1);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setY(y+1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this);
                            t.checkWarriorFound(this);
                        }else{
                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                        }
                    }
                }else if (x>5 && y==5){ //            setX(x-1);
                    nextlocation=GridLocation.getlocationobject(x-1, y);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setX(x-1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this);
                            t.checkWarriorFound(this);
                        }else{
                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                        }
                    }
                }else if(x==5 && y>5 ){ //            setY(y-1);
                    nextlocation=GridLocation.getlocationobject(x, y-1);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setY(y-1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this); 
                            t.checkWarriorFound(this);
                        }else{
                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                        }
                    }
                }else if(y==5 && x<5 ){ //            setX(x+1);
                    nextlocation=GridLocation.getlocationobject(x+1, y);
                    synchronized(nextlocation){
                        if(nextlocation.checkAbilityToSwim()==true){
                            currentLocation.removeInhabitant();
                            setX(x+1);
                            setEnergyBar();
                            System.out.println(getName()+" swam to  ("+getX()+" "+getY()+")");
                            nextlocation.setInhabitant(this);
                        t.checkWarriorFound(this);
                        }else{
                            //System.out.println(getName()+" cannot swim to that location.current location  "+getX()+" "+getY());
                        }
                    }
                }                     
           }
       }
   
   }    
    */
   
}
