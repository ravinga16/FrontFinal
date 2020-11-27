/*
 *PARENT CLASS OF ALL INHABITANTS.
 *IMPLEMENT COMMON METHODS TO ALL.
 */
package semesterprojectfinal;

import java.util.*;

 abstract  class Inhabitant { 
    protected int x;
    protected int y;
    private int id;
    private String name;
    private Grid grid;
    
  
    
    
    

    public Inhabitant(int x,int y,String name,int id){
        this.x=x;
        this.y=y;
        this.name=name;
        this.id=id;
        GridLocation.getlocationobject(x, y).setInhabitant(this);
        
          
        
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

  
    public int getY() {
        return y;
    }

    
    public void setY(int y) {
        this.y = y;
    }

   
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
