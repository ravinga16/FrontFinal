package semesterprojectfinal;

import java.util.ArrayList;
import java.util.Random;

public class SemesterProjectFinal {
   public static int totalNumberofInhabitant=15;
   public static ArrayList<GridLocation> already_initialized_locations=new ArrayList<>();  
   
  
    public static void main(String[] args) throws InterruptedException { 
        ArrayList<GridLocation> already_initialized_locations=new ArrayList<>();  
        
        String[] name=new String[4];
        name[0]="**Wonder Women";
        name[1]="**Spider Man";
        name[2]="**Bat Man";
        name[3]="**Super Warrior";
        ArrayList<Warrior> warriorList=new ArrayList<>();
        
        Grid grid=new Grid();
        Random r=new Random();
        /*warriors*/
        
        int i=0;
        int x=0;
        int y=0;
        Warrior[] w=new Warrior[4];      
        while (i<3){
            x=r.nextInt(10);
            if (x==0 || x==10){
                y=r.nextInt(10);
            }else{
                y=r.nextInt(10)%3==0?0:10;
            }
            if (GridLocation.getlocationobject(x, y).checkAbilityToSwim()==true){            
                w[i]=new NormalWarrior(x, y, name[i], i);                
                System.out.println(w[i].getName()+" starting location "+x+" "+y);
                warriorList.add(w[i]);              
                i++;
            }
        }
        
      
        i=3;
        while(i<4){
            x=r.nextInt(10);
            if (x==0 || x==10){
                y=r.nextInt(10);
            }else{
                y=r.nextInt(10)%3==0?0:10;
            }
            if (GridLocation.getlocationobject(x, y).checkAbilityToSwim()==true){              
              
                w[i]=new SuperWarrior(x, y, name[i], i);
                System.out.println(w[i].getName()+" starting location "+x+" "+y);                  
                warriorList.add(w[i]);          
                i++;
            }
            
        }
        Actionable[] a=new Actionable[11];        
        
        int m=0;
        while(m<2){
            x=r.nextInt(8)+1;
            y=r.nextInt(8)+1;
            if(x!=5 && y!=5){
                if (GridLocation.getlocationobject(x, y).getInhabitantlist().size()==0){                
                    a[m]=new Killer_fish(x, y, "killer"+m, m+1);
                    System.out.println("Killer Fish"+" "+x+" "+y);
                    m++;
                }                
            }            
        }        
        m=2;
        while(m<4){
            x=r.nextInt(8)+1;
            y=r.nextInt(8)+1;
            if(x!=5 && y!=5){
                if (GridLocation.getlocationobject(x, y).getInhabitantlist().size()==0){            
                    a[m]=new Rubber_eat_fish(x, y, "rubber"+m, m+1);
                    System.out.println("Rubber Eat Fish  "+x+" "+y);
                    m++;
                }                
            }            
        }          
        m=4;
        while(m<6){
            x=r.nextInt(8)+1;
            y=r.nextInt(8)+1;
            if(x!=5 && y!=5){
                if (GridLocation.getlocationobject(x, y).getInhabitantlist().size()==0){              
                    a[m]=new Normal_fish(x, y, "normalfish"+m, m+1);
                    System.out.println("Normal Fish  "+x+" "+y);
                    m++;
                }                
            }            
        }              
        m=6;
        while (m<11){
            x=r.nextInt(8)+1;
            y=r.nextInt(8)+1;
            if(x!=5 && y!=5){
                if (GridLocation.getlocationobject(x, y).getInhabitantlist().size()==0){               
                    a[m]=new LotusFlower(x, y, "lotusflower"+m,m+1);
                    System.out.println("Lotus FLower  "+x+" "+y);
                    m++;
                }                
            }                       
        }       
        
        Thread t1=new Thread(warriorList.get(0));
        Thread t2=new Thread(warriorList.get(1));
        Thread t3=new Thread(warriorList.get(2));
        Thread t4=new Thread(warriorList.get(3));
        
        t1.start();        
        t2.start();        
        t3.start();
        t4.start();
                   
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        
           }
            
        }
       

             
        
        
        
        
        
        
        
        
        
        

    
    
