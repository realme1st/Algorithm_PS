import java.util.Scanner;
class Main {  
  public static void main(String args[]) { 
    Scanner sc = new Scanner(System.in);
    
    int num1=sc.nextInt();
    int num2=sc.nextInt();

    int arr[] =new int[num1];

    for (int i=0;i<num1;i++){
      arr[i] =sc.nextInt();
    }

    for(int i=0;i<num1;i++){
      if(arr[i]<num2){
        System.out.print(arr[i]+" ");
      }
    }
  } 
}