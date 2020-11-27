
package semesterprojectfinal;

 class LotusFlower extends Inhabitant implements Actionable,Observer{
    private int petal=100;

    public LotusFlower(int x, int y, String name, int id) {
        super(x, y, name, id);
    }     
    
    public void setPetal(){        
        petal=petal-1;
        System.out.println(getName()+" lose One Petal.New Petal Count  "+getPetal());
    }
    
    public int getPetal(){
        return petal;
    }
    
    @Override
    public void action_toward_warrior(Warrior w) {
        if(w.isImmortal()==false){            
            w.setImmortal(true);
            System.out.println(w.getName()+" IS NOW IMMORTAL");
            setPetal();
        }
        
    }

    @Override
    public void update(Inhabitant inhabitant) {
        action_toward_warrior((Warrior) inhabitant);
    }
    
}
