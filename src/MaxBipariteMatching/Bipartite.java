package MaxBipariteMatching;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
 *@author ayaaf
 **/

public class Bipartite 
{
    
//      int R = 8;    //Number of Applicants
//      int C = 8;    //Number of Job vacancies
  
    //Return whether applicant can be assigned a job they are interested in
    boolean checkMatching(boolean bipartiteGraph[][], int u, boolean visited[], int matched[], int C)
    { 
        for (int v = 0; v < C; v++) //Check jobs applicant v is interested in
        { 
            if (bipartiteGraph[u][v] && !visited[v])      
            { 
                visited[v] = true;  

                if (matched[v] < 0 || checkMatching(bipartiteGraph, matched[v], visited, matched, C)) 
                { 
                    matched[v] = u; 
                    return true; 
                } 
            } 
        } 
        return false; 
    } 
  
    //Returns max Matching
    int maxMatching(boolean bipartiteGraph[][], int R, int C) 
    { 
        int matched[] = new int[C]; 
     
        for(int i = 0; i < C; ++i)  
        {
            matched[i] = -1; 
        }
            
        int result = 0;   
        
        for (int u = 0; u < R; u++) 
        { 
            boolean visited[] = new boolean[C] ; 
            for(int i = 0; i < C; ++i)
            {
               visited[i] = false;
            }
                 
            if (checkMatching(bipartiteGraph, u, visited, matched, C))  
            {
               result++;
            }
        } 
        return result; 
    } 
    
    
    

    public static void main(String[] args) throws java.lang.Exception 
    {
        int R, C; 
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Enter number of rows: ");
        R = in.nextInt();
        
        System.out.println("Enter number of columns: ");
        C = in.nextInt();
        
        boolean bipartiteGraph[][] = new boolean[R][C];        
   
 
        System.out.println("enter the elementss for the Matrix"); 
        for(int row = 0; row < bipartiteGraph.length; row++)   //bipartiteGraph.length = R
        { 
            for(int col = 0 ;col< C; col++)
            { 
                bipartiteGraph[row][col] = in.nextBoolean();
            } 
        }
        
        
//        boolean bipartiteGraph[][] = new boolean[][]
//                                   { 
//                                        {false, true, true, true, false, false, true, false},  
//                                        {true, false, false, true, false, false, false, false},   
//                                        {false, false, true, false, false, false, false, true},  
//                                        {false, false, true, true, false, false, false, false}, 
//                                        {true, false, true, false, true, true, false, true},  
//                                        {false, false, true, false, false, true, false, true},
//                                        {true, true, false, true, false, true, true, false},
//                                        {false, false, true, false, true, true, true, false}
//                                    }; 
        
        
        Bipartite bi = new Bipartite(); 
        System.out.println( "Maximum number of Matching is: "+bi.maxMatching(bipartiteGraph, R, C)); 
    }    
}
