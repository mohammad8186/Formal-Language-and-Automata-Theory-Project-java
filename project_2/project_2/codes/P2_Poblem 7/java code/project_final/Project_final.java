
package project_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author MohamamdHosein
 */
public class Project_final {
    static int output_compataror; // output of compataror 
    static int output_adder;  // output of adder 
    static int output_module; // output of module 
    static int output_zarb;
    static Tape tape = new Tape();
    static Scanner scan  = new Scanner(System.in);
    public static void main(String[] args) {
    
    // get input number
    int input = scan.nextInt();
    System.out.print("\n\n");
    
    // compare two number
    comparator(input);
   
    if(output_compataror==2 || output_compataror==3){  // Input>=20
        
        
       // get module of inpur number on 4
       module (input);
       System.out.print(output_module);
       System.out.print("\n\n");
       System.out.print(tape.array);
        
    }
    else if(output_compataror==1){  //  Input<20
        
        
          // add 3*input number  to 5
         
          adder(input);
          System.out.print(output_adder);
          System.out.print("\n\n");
          System.out.print(tape.array);
        
    }
    
    
    
        
    }
    
    static void comparator(int input){
        // initialize tape
         tape.array.add('&');
         for (int i  = 1 ; i<=input  ; i+=1){
        
          tape.array.add('1');
          }  
          tape.array.add('0');
       
          // initialize input number to the left side of tape
          for (int i  = 1  ; i<=20 ; i+=1){
              tape.array.add('1');
              
          }
          tape.array.add('&');
          tape.pointer = 1;
          
          // create 9  states  for comparatetor
          State Q0 = new State();
          Q0.name = "Q0";
          State Q1 = new State();
          Q1.name = "Q1";
          State Q2 = new State();
          Q2.name = "Q2";
          State Q3 = new State();
          Q3.name = "Q3";
          State Q4 = new State();
          Q4.name = "Q4";
          State Q5 = new State();
          Q5.name = "Q5";
          State Q6 = new State();
          Q6.name = "Q6";
          Q6.status_final  = true; // Input<20
          State Q7 = new State();
          Q7.name = "Q7"; 
          Q7.status_final = true ;// Input==20
          State Q8 = new State();
          Q8.name = "Q8";  
          Q8.status_final = true; // Input>20
          
          // creat Machine transions and travers tape. start from q0
          
          State current_state = new State();
          current_state = Q0;
          while(true){
              
              
              // for q0
              if(current_state==Q0 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'x');tape.pointer+=1;
              }    
               if(current_state==Q0 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q5 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              } 
               
               
                // for q1
                if(current_state==Q1 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'1');tape.pointer+=1;
              }
                  if(current_state==Q1 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q2 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              }   
                  
                  
                   // for q2
                   if(current_state==Q2 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q2; tape.array.set(tape.pointer,'x');tape.pointer+=1;
              }  
                    if(current_state==Q2 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q3; tape.array.set(tape.pointer,'x');tape.pointer-=1;
              } 
                       if(current_state==Q2 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q8; tape.array.set(tape.pointer,'&');tape.pointer-=1;
               
              }  
                       
                       
                       //for q3
                        if(current_state==Q3 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q3; tape.array.set(tape.pointer,'x');tape.pointer-=1;
              }  
                         if(current_state==Q3 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q4; tape.array.set(tape.pointer,'0');tape.pointer-=1;
              }  
                         
                       // for q4
                            if(current_state==Q4 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q4; tape.array.set(tape.pointer,'1');tape.pointer-=1;
              }   
                            if(current_state==Q4 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q0; tape.array.set(tape.pointer,'x');tape.pointer+=1;
              }   
                            
                  //for q5
                       if(current_state==Q5 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q5; tape.array.set(tape.pointer,'x');tape.pointer+=1;
              }   
                       
                        if(current_state==Q5 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q7; tape.array.set(tape.pointer,'&');tape.pointer-=1;
                  
              }   
                            if(current_state==Q5 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q6; tape.array.set(tape.pointer,'1');tape.pointer+=1;
                  
              }   
                    //for q6_ final state
                     
                       if(current_state==Q6){
                     
                  output_compataror =1;
                    break;
              }  
                    
                    
                    // for q7_ final state
                          if(current_state==Q7){
                  output_compataror =2;
                    break;
              }  
                    
                    
                    
                    // for q8_ final state
                          if(current_state==Q8){
                  output_compataror =3;
                    break;
              }  
                    
                    
          
}
    }
    
    static void zarb(int input){
        // initialize tape
           tape.array = new ArrayList<Character>();
           
               
           
           tape.array.add('&');
           
       for (int i  = 1 ; i<=200 ; i+=1){
        
        tape.array.add('0');
    } 
       tape.array.add('c');
       
    
     for (int i  = 1 ; i<=input  ; i+=1){
        
        tape.array.add('0');
    } 
      
               
           
           tape.array.add('&');
           
       tape.pointer = 12;
       System.out.print(tape.array.get(tape.pointer-1));
       System.out.print(tape.array);
         //   creats 13 states
          State Q0 = new State();
          Q0.name = "Q0";
          State Q1 = new State();
          Q1.name = "Q1";
          State Q2 = new State();
          Q2.name = "Q2";
          State Q3 = new State();
          Q3.name = "Q3";
          State Q4 = new State();
          Q4.name = "Q4";
          State Q5 = new State();
          Q5.name = "Q5";
          State Q6 = new State();
          Q6.name = "Q6";
          State Q7 = new State();
          Q7.name = "Q7"; 
          State Q8 = new State();
          Q8.name = "Q8";  
          State Q9 = new State();
          Q9.name = "Q9";  
          State Q10 = new State();
          Q10.name = "Q10";  
          State Q11 = new State();
          Q11.name = "Q11";  
          State Q12 = new State();
          Q12.name = "Q12"; 
          Q12.status_final = true;
          
          State current_state = new State();
          current_state = Q0;
          
          while(true){
              
              
              // for q0
              if(current_state==Q0 && tape.array.get(tape.pointer)=='0')  {
         
                  
                  current_state = Q0 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              }   
                 if(current_state==Q0 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'c');tape.pointer+=1;
              }   
                 
                 // for q1
                 
                
                 
                 if(current_state==Q1 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              }   
                   if(current_state==Q1 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q2 ; tape.array.set(tape.pointer,'c');tape.pointer-=1;
              }   
                   // for q2
                     if(current_state==Q2 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state =Q2  ; tape.array.set(tape.pointer,'0');tape.pointer-=1;
              }   
                       if(current_state==Q2 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q3 ; tape.array.set(tape.pointer,'c');tape.pointer+=1;
              }   
                       
                       // for q3
                         if(current_state==Q3 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q3 ; tape.array.set(tape.pointer,'x');tape.pointer+=1;
              }   
                   if(current_state==Q3 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q4 ; tape.array.set(tape.pointer,'x');tape.pointer-=1;
              }   
                     if(current_state==Q3 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q12 ; tape.array.set(tape.pointer,'&');tape.pointer+=1;
              }   
                     
                     // for q4
                     
                       if(current_state==Q4 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q4 ; tape.array.set(tape.pointer,'x');tape.pointer-=1;
              }   
                       
                         if(current_state==Q4 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q5 ; tape.array.set(tape.pointer,'c');tape.pointer-=1;
              }   
                         
                         // for q5
                           if(current_state==Q5 && tape.array.get(tape.pointer)=='y')  {
                  
                  current_state = Q5 ; tape.array.set(tape.pointer,'y');tape.pointer-=1;
              }   
                               if(current_state==Q5 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q11 ; tape.array.set(tape.pointer,'&');tape.pointer+=1;
              }   
                                   if(current_state==Q5 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q6 ; tape.array.set(tape.pointer,'y');tape.pointer+=1;
              }   
                                   
                          // for q6
                          
                              if(current_state==Q6 && tape.array.get(tape.pointer)=='y')  {
                  
                  current_state = Q6 ; tape.array.set(tape.pointer,'y');tape.pointer+=1;
                  
                  
              }   
                                        if(current_state==Q6 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q7 ; tape.array.set(tape.pointer,'c');tape.pointer+=1;
              }   
                                        
                         //  for q7
                         
                         
                    if(current_state==Q7 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q7 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              }   
                       if(current_state==Q7 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q7 ; tape.array.set(tape.pointer,'x');tape.pointer+=1;
              }   
                     if(current_state==Q7 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q8 ; tape.array.set(tape.pointer,'c');tape.pointer+=1;
              }     
                     
                     // for q8
                     
                        if(current_state==Q8 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q8 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              }   
                        
                       if(current_state==Q8 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q9 ; tape.array.set(tape.pointer,'0');tape.pointer-=1;
              }   
                       
                     // for q9
                     
                   if(current_state==Q9 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q9 ; tape.array.set(tape.pointer,'0');tape.pointer-=1;
              }   
                   
                     if(current_state==Q9 && tape.array.get(tape.pointer)=='c')  {
                         
                  
                  current_state = Q10 ; tape.array.set(tape.pointer,'c');tape.pointer-=1;
              }   
                     
                     // for q10
                       if(current_state==Q10 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q10 ; tape.array.set(tape.pointer,'0');tape.pointer-=1;
              }   
                              if(current_state==Q10 && tape.array.get(tape.pointer)=='x')  {
                  
                  current_state = Q10 ; tape.array.set(tape.pointer,'x');tape.pointer-=1;
              }   
                              
                         if(current_state==Q10 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q5 ; tape.array.set(tape.pointer,'c');tape.pointer-=1;
              }   
                         
                         
                     // for q11
                     
                       if(current_state==Q11 && tape.array.get(tape.pointer)=='y')  {
                  
                  current_state = Q11 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              } 
                         if(current_state==Q11 && tape.array.get(tape.pointer)=='c')  {
                  
                  current_state = Q3 ; tape.array.set(tape.pointer,'c');tape.pointer+=1;
              }   
                         
                         
                         // for q12
                             if(current_state==Q12){
                                 System.out.print("fs");
                                 int result = 0;
                                 for (Character c : tape.array){
                                     if (c=='0'){
                                         result+=1;
                                        
                                     }
                             }
                         
                         output_zarb = result - 3 ;
                        
             break;
       
    }
    }
    }
    
    
    static void adder(int input){
        
    
      
    
     // input = output_zarb;
      
      
      
      
    
      // initialize tape
      tape.array = new ArrayList<Character>();
      input = 3*input;
       tape.array.add('&');
       for (int i  = 1 ; i<=input  ; i+=1){
        
        tape.array.add('1');
    } 
       tape.array.add('0');
       
        for (int i  = 1 ; i<=5  ; i+=1){
        
        tape.array.add('1');
    } 
        tape.array.add('&');
         tape.pointer = 1;
       
          // create 5 states q0 , q1 ,q2, q3, q4 for Adder
          State Q0 = new State();
          Q0.name = "Q0";
          State Q1 = new State();
          Q1.name = "Q1";
          State Q2 = new State();
          Q2.name = "Q2";
          State Q3 = new State();
          Q3.name = "Q3";
          State Q4 = new State();
          Q4.name = "Q4";
          Q4.status_final = true;
          
          // creat Machine  transions and states, start from q0
          State current_state = new State();
          current_state = Q0;
          
          while (true){
            // for q0
              if(current_state==Q0 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q0 ; tape.array.set(tape.pointer,'1');tape.pointer+=1;
              }    
               if(current_state==Q0 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'1');tape.pointer+=1;
              } 
               
               
               // for q1
               
                if(current_state==Q1 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'1');tape.pointer+=1;
              } 
                  if(current_state==Q1 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q2 ; tape.array.set(tape.pointer,'&');tape.pointer-=1;
              } 
                  
               // for q2
                 if(current_state==Q2 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q3 ; tape.array.set(tape.pointer,'0');tape.pointer-=1;
              } 
                 
                 
                 // for q3
                   if(current_state==Q3 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q3 ; tape.array.set(tape.pointer,'1');tape.pointer-=1;
              } 
                    if(current_state==Q3 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q4 ; tape.array.set(tape.pointer,'&');tape.pointer+=1;
                  
              } 
                    
                    // for q4 _ final state
                    
                    if(current_state==Q4){
                        
                        int count = 0;
                        for (Character c : tape.array){
                            if(c=='1'){
                                count+=1;
                            }
                        }
                        // put result in output
                        output_adder = count;
                        break;
                    }
          
          
          }
      
      


}
      
    static void module (int input){
        
       tape.array = new ArrayList<Character>();
       tape.array.add('&');
       int n = input/4;
       
       
       // put input into tape as series of 1 
       //between 4 1s thers is one 0 
       // sample tape : &1111011110110&
      
      
       
       
      
           for(int j = 1 ; j<=n ; j+=1){
              for (int i  = 1 ; i<=4  ; i+=1){
        
        tape.array.add('1');
    } 
         tape.array.add('0');
       }
           
           if(input%4!=0){
           for(int i = 1 ; i<=input%4 ; i+=1){
                tape.array.add('1');
           }
           tape.array.add('0');
           }
       
       
       tape.array.add('&');
       tape.pointer = 1;
     
    
  //  System.out.print(tape.array);
     // create 5 states q0 , q1 ,q2 for module
          State Q0 = new State();
          Q0.name = "Q0";
          State Q1 = new State();
          Q1.name = "Q1";
          State Q2 = new State();
          Q2.name = "Q2";
          Q2.status_final = true;
          
            // creat Machine  transions and states, start from q0
          State current_state = new State();
          current_state = Q0;
          while(true){
            // for q0
              if(current_state==Q0 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q0 ; tape.array.set(tape.pointer,'1');tape.pointer+=1;
              } 
              
              
               
               if(current_state==Q0 && tape.array.get(tape.pointer)=='0')  {
                  
                  current_state = Q1 ; tape.array.set(tape.pointer,'0');tape.pointer+=1;
              } 
               
               
               
               // for q1
               
                if(current_state==Q1 && tape.array.get(tape.pointer)=='1')  {
                  
                  current_state = Q0 ; tape.array.set(tape.pointer,'1');tape.pointer+=1;
              } 
                
                 if(current_state==Q1 && tape.array.get(tape.pointer)=='&')  {
                  
                  current_state = Q2 ; tape.array.set(tape.pointer,'&');tape.pointer-=1;
              } 
                 
                 // for q2 _ final state
                  if(current_state==Q2)  {
                  int count  = tape.array.size();
                 
                  int result = 0;
                  
                 
                  count -=3;
                  while(tape.array.get(count)!='0'){
                      result+=1;
                      count-=1;
                      
                  }
                  output_module = result%4;
                  break;
                      
              } 
              
              
          }
              
              
              
          

    }
}
// this class has attributes  like transins and name of state etc.
class State{


    String name;
    String letters = new String();
    char to_write ;
    char move_to;
    ArrayList<HashMap<Character, ArrayList<State>>> transions = new ArrayList<HashMap<Character, ArrayList<State>>>();
    ArrayList<State> destinations;
    boolean status_final = false;

        State(){
            


}
}

// this class determine the tape of touring machines
class Tape{
    int pointer;
    String letters = new String();
    ArrayList<Character> array = new   ArrayList<Character>();
    
    
    
}