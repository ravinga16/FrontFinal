/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojectfinal;

/**
 *
 * @author HP
 */
 class Grid {
    public Grid(){
        GridLocation[] locationarray=new GridLocation[122];
        int count=0;
        
            for(int y=0;y<11;y++){
                for(int x=0;x<11;x++){
                    locationarray[count]=new GridLocation(x, y);                 
                    count+=1;
                }
            }
    }
    
}
