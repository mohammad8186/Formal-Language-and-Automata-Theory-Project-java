package project_1_fa;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
public class Project_1_FA {
 
    
    static String str_input;
    static ArrayList<Character> letters = new     ArrayList<Character> ();
    static State Q0 = new State();
    static State Q1 = new State();
    static State Q2  = new State();
    static ArrayList<State> states = new ArrayList<State>();
    static ArrayList<State> temp_state = new ArrayList<State>();
    static Scanner input = new Scanner(System.in);
    static String txt_string = new String();
    public static void main(String[] args) throws FileNotFoundException, IOException { 
      
       
        //DFA_Input_1.txt
        String fileName = "C:\\Users\\Shahin\\Documents\\NetBeansProjects\\project_1_FA\\DFA_Input_1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
       
        String[] stringfile_read = new String[10]; 
        int i = 0;
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringfile_read[i] = line;
          
            i+=1;
        }
        reader.close();
       
      
           i  = 0;
           // determine states
           while(i<=stringfile_read[1].length()){
               State s = new State();
               s.name =  new StringBuilder().append(stringfile_read[1].charAt(i)).append(stringfile_read[1].charAt(i+1)).toString();
               states.add(s);
               i+=3;
              
           }
         
           //determine  letters
           
           letters.add( stringfile_read[0].charAt(0));
           letters.add( stringfile_read[0].charAt(2));
          
           
           // determine state final and start
           String det_final = new StringBuilder().append(stringfile_read[3].charAt(0)).append(stringfile_read[3].charAt(1)).toString();
           String det_start = new StringBuilder().append(stringfile_read[2].charAt(0)).append(stringfile_read[2].charAt(1)).toString();
           for (State s: states ){
               if(s.name.contains(det_final)){
                   
                   s.status_final =true;
               }
               else if(s.name.contains(det_start)){
                   
                   s.status_start = true;
           }
           }
         
           
           //creat transion 
        
           for (i  = 4 ; i<10  ; i+=1){
               
               String line_first_letters =  new StringBuilder().append(stringfile_read[i].charAt(0)).append(stringfile_read[i].charAt(1)).toString();
              
               
               if(line_first_letters.contains(states.get(0).name)){
                  
                      temp_state =  new ArrayList<State>();
                      for(State s : states){
                          if(s.name.contains(new StringBuilder().append(stringfile_read[i].charAt(5)).append(stringfile_read[i].charAt(6)).toString())){
                              
                              states.get(0).number_of_transions+=1;
                              Character letter =  stringfile_read[i].charAt(3);
                              temp_state.add(s);
                               states.get(0).transions.add(creat_Transion(letter , temp_state));
                               if(states.get(0).name.contains(s.name)){
                                   states.get(0).circle_onletter.add(true);
                               }
                               break;
                              
                          }
                      }
                      
     

                   
               }
                if(line_first_letters.contains(states.get(1).name)){
                     temp_state =  new ArrayList<State>();
                      for(State s : states){
                          if(s.name.contains(new StringBuilder().append(stringfile_read[i].charAt(5)).append(stringfile_read[i].charAt(6)).toString())){
                              states.get(1).number_of_transions+=1;
                              Character letter =  stringfile_read[i].charAt(3);
                              temp_state.add(s);
                               states.get(1).transions.add(creat_Transion(letter , temp_state));
                                if(states.get(1).name.contains(s.name)){
                                   states.get(1).circle_onletter.add(true);
                               }
                               break;
                   
               }
                      }
                }
                 if(line_first_letters.contains(states.get(2).name)){
                       temp_state =  new ArrayList<State>();
                      for(State s : states){
                          if(s.name.contains(new StringBuilder().append(stringfile_read[i].charAt(5)).append(stringfile_read[i].charAt(6)).toString())){
                              states.get(2).number_of_transions+=1;
                              Character letter =  stringfile_read[i].charAt(3);
                              temp_state.add(s);
                               states.get(2).transions.add(creat_Transion(letter , temp_state));
                                if(states.get(2).name.contains(s.name)){
                                   states.get(2).circle_onletter.add(true);
                               }
                               break;
                     
                 }
                   
               }
                 
           }
           }
              // determine if transion  has circle on itself
              
            // get input
              str_input = input.nextLine();
         
       
         if(str_input==null){
           System.out.print("NO");
           return;
        }
         State present_state = new State();
         // check string and states... Q0 START state
         
         
         int lentgh_str_input= str_input.length();
         present_state=states.get(0);
         i = 0;
         if((present_state.transions.get(0).get(letters.get(0)).get(0)!=null)&&(str_input.charAt(i)==letters.get(0))){
              present_state = states.get(1);
              lentgh_str_input-=1;
              
              i+=1;
         }
           else if((present_state.transions.get(1).get(letters.get(1)).get(0)!=null)&&(str_input.charAt(i)==letters.get(1))){
              present_state = states.get(1);
              lentgh_str_input-=1;
              
              i+=1;
         }
         
         if((present_state.status_final==true)&&(lentgh_str_input==0)){
             System.out.print("YES");
             return;
         }
          else{
             System.out.print("NO");
             System.exit(0);
         }
               // check string and states... Q1 START state
        
        
        if((present_state.transions.get(0).get(letters.get(0)).get(0)!=null)&&(str_input.charAt(i)==letters.get(0))){
              present_state = states.get(2);
              lentgh_str_input-=1;
              
              i+=1;
         }
          else if((present_state.transions.get(1).get(letters.get(1)).get(0)!=null)&&(str_input.charAt(i)==letters.get(1))){
              present_state = states.get(2);
              lentgh_str_input-=1;
              
              i+=1;
         }
          if((present_state.status_final==true)&&(lentgh_str_input==0)){
             System.out.print("YES");
             return;
         }
              else{
             System.out.print("NO");
             System.exit(0);
         }
          
                //  // check string and states... Q2 START state
             while(lentgh_str_input!=0){
              if((present_state.transions.get(0).get(letters.get(0)).get(0)!=null)&&(str_input.charAt(i)==letters.get(0))){
              present_state = states.get(2);
              lentgh_str_input-=1;
              
              i+=1;
         }
                else if((present_state.transions.get(1).get(letters.get(1)).get(0)!=null)&&(str_input.charAt(i)==letters.get(1))){
              present_state = states.get(2);
              lentgh_str_input-=1;
              
              i+=1;
         }
             }
                if((present_state.status_final==true)&&(lentgh_str_input==0)){
             System.out.print("YES");
             return;
         }
              else{
             System.out.print("NO");
             System.exit(0);
         }
         
            
         
         
         
         
         
         
    
         
         
         
        
         
         
         
         
}
    
     static  HashMap<Character, ArrayList<State>> creat_Transion(Character c , ArrayList<State> s){ 
        
     HashMap<Character, ArrayList<State>> map = new HashMap<>();
     ArrayList<State> arr_states = new ArrayList<State>();
     for(State st : s){
     arr_states.add(st);
     }
     map.put(c, arr_states);
        
     return map;
    }
  
    
    }



class State{
    ArrayList<Boolean> circle_onletter = new  ArrayList<Boolean>();
    int number_of_transions;
    String name;
    String letters = new String();
    ArrayList<HashMap<Character, ArrayList<State>>> transions = new ArrayList<HashMap<Character, ArrayList<State>>>();
    ArrayList<State> destinations;
    boolean status_final = false;
    boolean status_start = false;
        State(){
            


}

}  /* System.out.print(str);
        if(str.length()==1){
            System.out.print("NO");
            return;
        }
       if(str.length()>=2){
        char [] str_chars = new char[str.length()];
        str_chars[0] = str.toCharArray()[0];
        str_chars[1] = str.toCharArray()[1];
        System.out.print(str_chars[0]);
         if ((str_chars[0]=='a' && str_chars[1]=='a')||(str_chars[0]=='a' && str_chars[1]=='b')||(str_chars[0]=='b' && str_chars[1]=='b')||(str_chars[0]=='b' && str_chars[1]=='a')){
            
        System.out.print("YES");
        return;
       
    }
       }
        else{
            System.out.print("NO");
        }
        
        
    */