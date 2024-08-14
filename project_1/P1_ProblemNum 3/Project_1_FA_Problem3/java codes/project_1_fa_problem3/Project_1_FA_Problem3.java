package project_1_fa_problem3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Project_1_FA_Problem3 {

    /*
    a b
   (a+b)^*b
    */
    
    static ArrayList<Character> letters = new     ArrayList<Character> ();
    static ArrayList<State> states = new ArrayList<State>();
    static ArrayList<Character> parantize = new  ArrayList<Character>();
    static ArrayList<Character> multp = new  ArrayList<Character>();
    static ArrayList<Character> plus  = new  ArrayList<Character>();
    static  ArrayList<Character> star  = new  ArrayList<Character>();
    static ArrayList<State> temp_state =  new ArrayList<State>();
    public static void main(String[] args) throws FileNotFoundException, IOException {
       String fileName = "C:\\Users\\Shahin\\Documents\\NetBeansProjects\\Project_1_FA_Problem3\\RE_Input_3.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
       
        String[] stringfile_read = new String[10]; 
        int i = 0;
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringfile_read[i] = line;
          
            i+=1;
        }
        int lenth_of_line = 0;
        
        for(Character c :stringfile_read[1].toCharArray() ){
            lenth_of_line +=1;
        }
        
        reader.close();
        int number_of_operation = 0;
        int number_of_state = 0;
        
        letters.add(stringfile_read[0].charAt(0));
        letters.add(stringfile_read[0].charAt(2));
        for(  i  =0 ; i<lenth_of_line ; i+=1){
            if(stringfile_read[1].charAt(i)=='('){
                parantize.add(stringfile_read[1].charAt(i));
            }
              if(stringfile_read[1].charAt(i)==')'){
                parantize.add(stringfile_read[1].charAt(i));
            }
                if(stringfile_read[1].charAt(i)=='+'){
                plus.add(stringfile_read[1].charAt(i));
            }
                  if(stringfile_read[1].charAt(i)=='*'){
               multp.add(stringfile_read[1].charAt(i));
            }
                    if(stringfile_read[1].charAt(i)=='*'){
                star.add(stringfile_read[1].charAt(i));
            }
        }
        
       
        //determine number of opernads in parantiz
        int number_of_parantize = parantize.size();
        
        for(  i  =0 ; i<lenth_of_line ; i+=1){
            
            if((stringfile_read[1].charAt(i)<=122)&&(stringfile_read[1].charAt(i)>=65)){
            number_of_parantize-=1;
                    
            
        }
            if(number_of_parantize==0){
                break;
            }
        }
        // determine number of states
         for(  i  =0 ;  i<lenth_of_line; i+=1){
             
             if((stringfile_read[1].charAt(i)==43)){
                
                 
                 State Q0 = new State();
                 State Q1  = new State();
                 states.add(Q0);
                 states.add(Q1);
             }
             
         }
         
         
        // read the letters
        
        
        
       
        // make transions and states
    
      
     temp_state =  new ArrayList<State>();
     temp_state.add(states.get(0));
     states.get(0).name = "Q0";
      states.get(1).name = "Q1";
     states.get(0).transions.add(creat_Transion(letters.get(0) , temp_state));
      states.get(0).transions.add(creat_Transion(letters.get(1) , temp_state));
      
     
  
     temp_state =  new ArrayList<State>();
     temp_state.add( states.get(1));
      states.get(0).transions.add(creat_Transion(letters.get(1) , temp_state)); 
      
      
      // wirite to file
      
      StringBuilder write_to_file = new StringBuilder();
     
      write_to_file.append(states.get(0).name +" "+letters.get(0)+ " "+ states.get(0).name);
      write_to_file.append(System.lineSeparator());
      write_to_file.append(states.get(0).name +" "+letters.get(1)+ " "+ states.get(0).name);
      write_to_file.append(System.lineSeparator());
      write_to_file.append(states.get(0).name +" "+letters.get(1)+ " "+ states.get(1).name);
        Path path
            = Paths.get("C:\\Users\\Shahin\\Documents\\NetBeansProjects\\Project_1_FA_Problem3\\NFA_Output _2.txt");
 
        // Custom string as an input
      
 
        // Try block to check for exceptions
        try {
            // Now calling Files.writeString() method
            // with path , content & standard charsets
            Files.writeString(path, write_to_file,
                               StandardCharsets.UTF_8);
        }
 
        // Catch block to handle the exception
        catch (IOException ex) {
            // Print messqage exception occurred as
            // invalid. directory local path is passed
            System.out.print("Invalid Path");
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
    
    }
