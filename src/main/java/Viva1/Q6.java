/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Viva1;

/**
 *
 * @author nivee
 */ import java.util.Scanner;
public class Q6 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String word;
        int len,counterA=0,k=0,n=-1,m=-1,du1=0,du2=0,counterB=0,A=1,B=1,SA=0,SB=0;
        int compA=0,compB=0,xA=0,xB=0,yA=0,yB=0,direction=0,origin=0,meeting=0;
        int actualL=0,maximumgap=0,previousmaxgap=0;
        
        System.out.print("Enter robot commands: ");
        word=in.nextLine();
        len=word.length();
        
        char [] move=new char[len];
        int  [] fil=new int[len];
        char  [] temp1=new char[len];
        char [] temp2=new char[len];
        int  [] count1=new int[4];
        int  [] count2=new int[4];
        char  [] compass={'N','E','S','W'};
        
        
        for(int i=0;i<len;i++)
        { 
            if(Character.toUpperCase(word.charAt(i)) == 'F'||Character.toUpperCase(word.charAt(i)) == 'B'||Character.toUpperCase(word.charAt(i)) == 'L'||Character.toUpperCase(word.charAt(i)) == 'R')
            move[i]=word.charAt(i);
            else
            {
            System.out.println("Invalid Command String ");
            return;
                    
            
            }
        }
        
 
        
        for(int i=0;i<len;i++)
        {   
            
            
            
            if(Character.isUpperCase(move[i]))
            {    
                n++;
                temp1[n]=move[i];
              
            }
            else
            {   
                 m++;
                temp2[m]=move[i];
                 
            }
            
            if(n>0)
            {
            if(Character.isUpperCase(move[i]))
            {
            if((move[i]=='L'&&temp1[n-1]=='R')||(move[i]=='R'&&temp1[n-1]=='L'))
            { 
                if(n>1)
            {
                if(move[i]==temp1[n-2])
                {
                    continue;
                }      
            }              
               
                fil[k++]=du1;
                actualL++;
                fil[k++]=i;
                actualL++;
                
            }
            
            else if((move[i]=='F'&&temp1[n-1]=='B')||(move[i]=='B'&&temp1[n-1]=='F'))
            {
                if(n>1)
            {
               if(move[i]==temp1[n-2])
                {
                    continue;
                }      
            }               
               
                fil[k++]=du1;
                actualL++;
                fil[k++]=i;
                actualL++;
                
            }
            
            else if(move[i]==temp1[n-1])
            { 
                
              
             
                if(temp1[n-1]=='R'||temp1[n-1]=='L')
            {   if (counterA==0)
        {
           
            int p=0;
                while(p<k && fil[p]!=du1)
            {
                p++;
            }

            
                if(p==k)
            {
                count1[counterA++] = du1;
            }
        }

                     count1[counterA++] = i;
                    
                 if(counterA==4)
                 {             
                                for(int j=0;j<4;j++)
                                {
                                  fil[k]=count1[j];
                                  count1[j]=0;
                                  k++;
                                  actualL++;
                                }
                                counterA=0;
                               
                                
                 }
            }
            
            }
            
            
            
            else
            {
                           for(int j=0;j<4;j++)
                                {
                                  
                                  count1[j]=0;
                                  
                                }
                                counterA=0;  
            }
            
            }
            
            }
            
            if(m>0)
            {
            if(Character.isLowerCase(move[i]))
            {
           if((move[i]=='l'&& temp2[m-1]=='r')||(move[i]=='r'&&temp2[m-1]=='l'))
            { 
                if(m>1)
            {
               if(move[i]==temp2[m-2])
                {
                    continue;
                }      
            }              
               
                fil[k++]=du2;
                actualL++;
                fil[k++]=i;
                actualL++;
                
              

            }
            
            else if((move[i]=='f'&&temp2[m-1]=='b')||(move[i]=='b'&&temp2[m-1]=='f'))
            {
                if(m>1)
            {
                 if(move[i]==temp2[m-2])
                {
                    continue;
                }      
            }              
               
                fil[k++]=du2;
                actualL++;
                fil[k++]=i;
                actualL++;
       

            }
            
            else if(move[i]==temp2[m-1])
            {
               if(temp2[m-1]=='r'||temp2[m-1]=='l')
            {   if (counterA==0)
        {
            // ADDED: Search fil for the previous uppercase index.
            int S=0;
            while(S<k && fil[S]!=du1)
            {
                S++;
            }

            // CHANGED: Save du1 only if it hasn't been removed.
            if(S==k)
            {
                count2[counterA++] = du1;
            }
        }
                   count2[counterB++] = i;
                 if(counterB==4)
                 {             
                                for(int j=0;j<4;j++)
                                {
                                  fil[k]=count1[j];
                                  count2[j]=0;
                                  k++;
                                  actualL++;
                                }
                                counterB=0;
                                
                                
                 }
            }
            }
            
            else
            {
                
            }
            }
            
        
            }
            
            if(Character.isUpperCase(move[i]))
            {    
                du1=i;
              
            }
            else
            {   
                 du2=i;
                 
            }
            }
        
        
        for(int i=0;i<len;i++)
           {
               
               if(Character.isUpperCase(move[i]))
               {   if(move[i]=='R')
                   {
                       
                       if(compA==3)
                           compA=0;
                       else
                       compA+=1;
                       direction++;
                   }
               else if(move[i]=='L')
                  {
                       if(compA==0)
                           compA=3;
                       else
                       compA-=1;
                   }
               else
               {  

                   switch(compA)
                   {
                       case 0:
                       {
                           if(move[i]=='F')
                               yA+=1;
                           else 
                               yA-=1;
                       }
                               
                               break;
                       
                       case 1:
                       {
                           if(move[i]=='F')
                               xA+=1;
                           else
                               xA-=1;
                       }
                               
                               break;
                       
                       case 2:
                        {
                           if(move[i]=='F')
                               yA-=1;
                           else 
                               yA+=1;
                        }
                               
                               break;
                        
                       
                       case 3:
                        {
                           if(move[i]=='F')
                               xA-=1;
                           else 
                               xA+=1;
                        }
                               
                               break;
                          
                        
                   }
                   
                   if(yA==0&&xA==0)
                       origin++;
                   
                   if(xA==xB&&yA==yB)
                       meeting++;
               }    
                   
                }
                else 
                 {   if(move[i]=='r')
                   {
                       
                       if(compB==3)
                           compB=0;
                       else
                       compB+=1;
                       direction++;
                   }
               else if(move[i]=='l')
                  {
                       if(compB==0)
                           compB=3;
                       else
                       compB-=1;
                   }
               else
               {  

                   switch(compB)
                   {
                       case 0:
                       {
                           if(move[i]=='f')
                               yB+=1;
                           else
                               yB-=1;
                           
                            }
                       break;
                       case 1:
                       {
                           if(move[i]=='f')
                               xB+=1;
                           else 
                               xB-=1;
                       }   
                               
                               break;
                       
                       case 2:
                        {
                           if(move[i]=='f')
                               yB-=1;
                           else
                               yB+=1;
                           
                        }      
                               break;
                         
                       
                       case 3:
                        {
                           if(move[i]=='f')
                               xB-=1;
                           else 
                               xB+=1;
                         
                        }       
                               break;
                          
                        
                   }
                   
                   if(yB==0&&xB==0)
                       origin++;
                   
                   if(xA==xB&&yA==yB)
                       meeting++;
               }
                 
               
               }
               maximumgap =Math.abs(xA - xB) + Math.abs(yA - yB);
                       
               
               if(maximumgap>previousmaxgap)
               previousmaxgap=maximumgap;
           }
        
        
        
        
        System.out.print("Meetings: "+meeting+"\n");
        System.out.print("Origin Returns: "+origin+"\n");
        System.out.print("Maximum Gap: "+previousmaxgap+"\n");
        System.out.print("Robot P Final: ("+xA+","+yA+") facing "+compass[compA]);
        System.out.println();
        System.out.print("Robot Q Final: ("+xB+","+yB+") facing "+compass[compB]);
        
        int temp;
      for(int j=0;j<actualL;j++)
      {
        for(int i=0;i<j;i++)
           {
               if(fil[i]>fil[j])
               {
                   temp=fil[i];
                   fil[i]=fil[j];
                   fil[j]=temp;
               }
             
           }
      
      }
      System.out.println();
      System.out.print("Simplified commands: ");
      int j=0;
      for(int i=0;i<len;i++)
           {  
               
               if(actualL>0)
               {
               if(i==fil[j])
           { 
                j++;
               continue;
              
           }
               else
               System.out.print(move[i]);
               }
               else
               System.out.print(move[i]);
           }
    }
}
