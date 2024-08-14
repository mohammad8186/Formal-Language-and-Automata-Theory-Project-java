package project_1_fa_poblem2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

 class Project_1_FA_Poblem2 {

    String input_txt_machin_states = new String();


   static  State Q0 = new State();
   static  State Q1 =  new State();
   static  State Q2 =  new State();
   static ArrayList<Character> letters = new ArrayList<Character>();
   static ArrayList<State> temp_state = new ArrayList<State>();
   static State current_state = new State();
   
    public static void main(String[] args) throws IOException{
        
     //read from file:
        String fileName = "C:\\Users\\Shahin\\Documents\\NetBeansProjects\\Project_1_FA_Poblem2\\NFA_Input_2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }
        reader.close();
        String content = stringBuilder.toString();
          
          
  
     
     // determin letters from the file:
   //  System.out.print(content.charAt(2));
     for (int j = 0 ; j<4 ; j+=1){
         if(content.charAt(j)!=' ' && content.charAt(j)!='\n' ){
             letters.add(content.charAt(j));
          
     }
        
   
     }
     
     // Crear states in NFA:
     //-------------------------Creat state Q0 
     Q0.name = new StringBuilder().append(content.charAt(5)).append(content.charAt(6)).toString();
     temp_state.add(Q1);
     Q0.transions.add(creat_Transion('&' , temp_state));
     temp_state =  new ArrayList<State>();
     temp_state.add(Q1);
     Q0.transions.add(creat_Transion('0' , temp_state));     
     
    
   
     //-----------------------Creat state Q1
     Q1.name = new StringBuilder().append(content.charAt(8)).append(content.charAt(9)).toString(); 
     temp_state =  new ArrayList<State>();
     temp_state.add(Q0);
     Q1.transions.add(creat_Transion('0' , temp_state));
     
     temp_state =  new ArrayList<State>();
     temp_state.add(Q2);
     Q1.transions.add(creat_Transion('0' , temp_state));
     
     temp_state =  new ArrayList<State>();
     temp_state.add(Q1);
     Q1.transions.add(creat_Transion('1' , temp_state));
     
     temp_state =  new ArrayList<State>();
     temp_state.add(Q2);
     Q1.transions.add(creat_Transion('1' , temp_state));
   
     
     //----------------------------Creat stateQ2
     Q2.name = new StringBuilder().append(content.charAt(11)).append(content.charAt(12)).toString(); ; 
     temp_state =  new ArrayList<State>();
     temp_state.add(Q2);
     Q2.transions.add(creat_Transion('0' , temp_state));
     temp_state =  new ArrayList<State>();
     temp_state.add(Q1);
     Q2.transions.add(creat_Transion('1' , temp_state));
     Q2.status_final  = true;
   
     //-------

    
   
     //----------------remove landa transion and make transition Q0 1  {Q1,Q2}
     
     if(Q0.transions.get(0).keySet().toArray()[0]!=null){
         State current = Q0.transions.get(0).get('&').get(0);
        
         if(current==Q1){
           temp_state =  new ArrayList<State>();
         for(int i = 0 ; i<4;i+=1){
             
               if((char)Q1.transions.get(i).keySet().toArray()[0]=='1'){
                 temp_state.add(Q1.transions.get(i).get('1').get(0));
                 //Q0.transions.add(creat_Transion('1',))
               }
                   
               }
      Q0.transions.get(0).remove('&');
         Q0.transions.add(creat_Transion('1' , temp_state));
         
         temp_state =  new ArrayList<State>();
         
                
         }
         
         
     }
     
       //-------------remove landa transion and make transition Q0 0  {Q0,Q1,Q2}// index starts from 1 to 2 in trasion Q0;
        if(Q0.transions.get(1).keySet().toArray()[0]!=null){
            
             State current = Q1;
               for(int i = 0 ; i<4;i+=1){
             
               if((char)Q1.transions.get(i).keySet().toArray()[0]=='0'){
                    Q0.transions.get(1).get('0').add(Q1.transions.get(i).get('0').get(0));
                 
               
               }
                   
               }
               
           
        }
       
   // System.out.print(Q0.transions.get(0).keySet().toArray()[0]);
   // System.out.print(Q0.transions.get(1).get('0').get(2).name);
   
   // after remove landa transion, we try to make states in DFA
    create_States_In_DFA();
             
           
         
      
      
    }
    
    
    static void create_States_In_DFA(){
        
   //----------make new transirions in DFA
   // ------------creat state Q0_Q1_Q2 and  transions
   State Q0_Q1_Q2  = new State();
   Q0_Q1_Q2.status_final = true;
   Q0_Q1_Q2.name = "Q0Q1Q2";
   
    HashSet<State> temp_state_set_0 =  new HashSet<State>();
    HashSet<State> temp_state_set_1 =  new HashSet<State>();
    
         if((char)Q0.transions.get(1).keySet().toArray()[0]=='0'){
             
            Iterator<State> it =  Q0.transions.get(1).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
             
         }
    
             
           
         
          if((char)Q0.transions.get(2).keySet().toArray()[0]=='1'){
                Iterator<State> it =  Q0.transions.get(2).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
              
              
          }
          
              for(int i = 0 ; i<2 ; i+=1){
           if((char)Q1.transions.get(i).keySet().toArray()[0]=='0'){
                 Iterator<State> it =  Q1.transions.get(i).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
               
           }
              }
                for(int i = 2 ; i<4 ; i+=1){
            if((char)Q1.transions.get(i).keySet().toArray()[0]=='1'){
                  Iterator<State> it =  Q1.transions.get(i).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
        
                
            }
                }
                
             if((char)Q2.transions.get(0).keySet().toArray()[0]=='0'){
                   Iterator<State> it =  Q2.transions.get(0).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
                 
             }
        
              if((char)Q2.transions.get(1).keySet().toArray()[0]=='1'){
                    Iterator<State> it =  Q2.transions.get(1).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
    }

    
     
   
    
    
      temp_state = new ArrayList<State>(temp_state_set_0);
      Q0_Q1_Q2.transions.add(creat_Transion('0' , temp_state));
      temp_state = new ArrayList<State>(temp_state_set_1); 
      Q0_Q1_Q2.transions.add(creat_Transion('1' , temp_state));
      
     // System.out.print(Q0_Q1_Q2.transions.get(0).get('0').get(0).name);
         // System.out.print(Q0_Q1_Q2.transions.get(1).get('1').get(1).name);
         
         //------------creat state Q1_Q2 and transions
         
         
         State Q1_Q2 = new State();
         Q1_Q2.status_final = true;
         Q1_Q2.name = "Q1Q2";
         temp_state_set_0 =  new HashSet<State>();
         temp_state_set_1 =  new HashSet<State>();
              for(int i = 0 ; i<2 ; i+=1){
           if((char)Q1.transions.get(i).keySet().toArray()[0]=='0'){
                 Iterator<State> it =  Q1.transions.get(i).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
               
           }
              }
                for(int i = 2 ; i<4 ; i+=1){
            if((char)Q1.transions.get(i).keySet().toArray()[0]=='1'){
                  Iterator<State> it =  Q1.transions.get(i).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
        
                
            }
                }
                
             if((char)Q2.transions.get(0).keySet().toArray()[0]=='0'){
                   Iterator<State> it =  Q2.transions.get(0).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
                 
             }
        
              if((char)Q2.transions.get(1).keySet().toArray()[0]=='1'){
                    Iterator<State> it =  Q2.transions.get(1).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
    }
              
              
      temp_state = new ArrayList<State>(temp_state_set_0);
      Q1_Q2.transions.add(creat_Transion('0' , temp_state));
      temp_state = new ArrayList<State>(temp_state_set_1); 
      Q1_Q2.transions.add(creat_Transion('1' , temp_state));
              
     // System.out.print(Q1_Q2.transions.get(1).get('1').get(1).name);
         
      //------------creat state Q0_Q2 and  transions
      
      
         State Q0_Q2 = new State();
         Q0_Q2.status_final = true;
         Q0_Q2.name = "Q0Q2";
         temp_state_set_0 =  new HashSet<State>();
         temp_state_set_1 =  new HashSet<State>();
         
            if((char)Q0.transions.get(1).keySet().toArray()[0]=='0'){
             
            Iterator<State> it =  Q0.transions.get(1).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
             
         }
    
             
           
         
          if((char)Q0.transions.get(2).keySet().toArray()[0]=='1'){
                Iterator<State> it =  Q0.transions.get(2).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
              
              
          }
         
                
             if((char)Q2.transions.get(0).keySet().toArray()[0]=='0'){
                   Iterator<State> it =  Q2.transions.get(0).get('0').iterator();
            while(it.hasNext()){
                temp_state_set_0.add(it.next());
            }
                 
             }
        
              if((char)Q2.transions.get(1).keySet().toArray()[0]=='1'){
                    Iterator<State> it =  Q2.transions.get(1).get('1').iterator();
            while(it.hasNext()){
                temp_state_set_1.add(it.next());
            }
    }
      temp_state = new ArrayList<State>(temp_state_set_0);
      Q0_Q2.transions.add(creat_Transion('0' , temp_state));
      temp_state = new ArrayList<State>(temp_state_set_1); 
      Q0_Q2.transions.add(creat_Transion('1' , temp_state));
      

    
    
    //make list of new states together:
    ArrayList<State> States_DFA = new ArrayList();
    States_DFA.add(Q0);
    States_DFA.add(Q0_Q1_Q2);
    States_DFA.add(Q1_Q2);
    States_DFA.add(Q0_Q2);
    
    // write to new file:
    StringBuilder write_to_file = new StringBuilder();
    // Write q0 to string
    
        int i = 1;
        write_to_file.append(Q0.name +" " + Q0.transions.get(1).keySet().toArray()[0]+" ");
        for(State s : Q0.transions.get(i).get('0')){
        write_to_file.append(s.name);
        }
        
         write_to_file.append(System.lineSeparator());
        i = 2;
        write_to_file.append(Q0.name +" " + Q0.transions.get(2).keySet().toArray()[0]+" ");
        for(State s : Q0.transions.get(i).get('1')){
        write_to_file.append(s.name);
        }
       write_to_file.append(System.lineSeparator());
    
    //System.out.print( write_to_file);
     // Write Q0_Q1_Q2 to string
     
         i = 0;
        write_to_file.append(Q0_Q1_Q2.name +" " + Q0_Q1_Q2.transions.get(0).keySet().toArray()[0]+" ");
        for(State s : Q0_Q1_Q2.transions.get(i).get('0')){
        write_to_file.append(s.name);
        }
        
         write_to_file.append(System.lineSeparator());
        i = 1;
        write_to_file.append(Q0_Q1_Q2.name +" " + Q0_Q1_Q2.transions.get(1).keySet().toArray()[0]+" ");
        for(State s : Q0_Q1_Q2.transions.get(i).get('1')){
        write_to_file.append(s.name);
        }
            write_to_file.append(System.lineSeparator());
   
    
     // Write Q1_Q2 to string
        i = 0;
        write_to_file.append(Q1_Q2.name +" " + Q1_Q2.transions.get(0).keySet().toArray()[0]+" ");
        for(State s : Q1_Q2.transions.get(i).get('0')){
        write_to_file.append(s.name);
        }
        
         write_to_file.append(System.lineSeparator());
        i = 1;
        write_to_file.append(Q1_Q2.name +" " + Q1_Q2.transions.get(1).keySet().toArray()[0]+" ");
        for(State s : Q1_Q2.transions.get(i).get('1')){
        write_to_file.append(s.name);
        }
        write_to_file.append(System.lineSeparator());
   //   System.out.print( write_to_file);
       
     // Write Q0_Q2 to string
       i = 0;
        write_to_file.append(Q0_Q2.name +" " + Q0_Q2.transions.get(0).keySet().toArray()[0]+" ");
        for(State s : Q0_Q2.transions.get(i).get('0')){
        write_to_file.append(s.name);
        }
        
         write_to_file.append(System.lineSeparator());
        i = 1;
        write_to_file.append(Q0_Q2.name +" " + Q0_Q2.transions.get(1).keySet().toArray()[0]+" ");
        for(State s : Q0_Q2.transions.get(i).get('1')){
        write_to_file.append(s.name);
        }
         //  System.out.print( write_to_file);
             Path path
            = Paths.get("C:\\Users\\Shahin\\Documents\\NetBeansProjects\\Project_1_FA_Poblem2\\DFA_Output _2.txt");
 
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


    String name;
    String letters = new String();
    ArrayList<HashMap<Character, ArrayList<State>>> transions = new ArrayList<HashMap<Character, ArrayList<State>>>();
    ArrayList<State> destinations;
    boolean status_final = false;

        State(){
            


}

}
