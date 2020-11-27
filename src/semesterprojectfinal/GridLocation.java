package semesterprojectfinal;

import java.util.ArrayList;




 class GridLocation { //observable class for actionable inhabitants
    private int x;
    private int y;
    private ArrayList<Inhabitant> inhabitantlist;               
    
    public GridLocation(int x,int y){
        this.x=x;
        this.y=y;      
        inhabitantlist=new ArrayList<>(2);
        SemesterProjectFinal.already_initialized_locations.add(this);
    }   
            

    public int getX() {
        return x;
    }
   
    public int getY() {
        return y;
    }
    
    public void setInhabitant(Inhabitant in){
       if(this.getInhabitantlist().size()==1){
           this.getInhabitantlist().add(in);
           if(this.getInhabitantlist().get(0) instanceof Observer){
               Observer o=(Observer) this.getInhabitantlist().get(0);
               o.update(in);
               
           }
           /*if(this.getInhabitantlist().get(0) instanceof Actionable){
               Actionable a=(Actionable) this.getInhabitantlist().get(0);
               a.action_toward_warrior((Warrior) in);
           }*/
       }else if(this.getInhabitantlist().size()==0){
           this.getInhabitantlist().add(in);
       }

    }   //initialize inhabitants in the location inhabitant list
    
    public void removeInhabitant(){
        if(this.getInhabitantlist().size()!=0){
            this.getInhabitantlist().remove(this.getInhabitantlist().size()-1);            
        }
    }
    
    public static GridLocation getlocationobject(int x,int y){
        GridLocation gdlocation = null;
        for(GridLocation gd:SemesterProjectFinal.already_initialized_locations){
            if(gd.getX()==x && gd.getY()==y){
                gdlocation=gd;
            }
        }
        return gdlocation;
    } // returns the location object when the x,y is given
   
    public boolean checkAbilityToSwim() {        
       boolean swim = true;      
       if(getInhabitantlist().size()==1){
           try{
                Inhabitant i=getInhabitantlist().get(0);
                if(i instanceof NormalWarrior){
                    swim=false;
                }else if(i instanceof SuperWarrior){
                    swim=false;
                }else{
                    swim=true;
                }
           }catch(IndexOutOfBoundsException e){}
       }else if(getInhabitantlist().size()==2){
           swim=false;
       }else if(getInhabitantlist().size()==0){
           swim=true;
       }
       else{
           swim=true;
       }
    return swim;
    } //return true if no another warrior in the location
    
    public ArrayList<Inhabitant> getInhabitantlist() {
        return inhabitantlist;
    }
    
    
   
    
}
