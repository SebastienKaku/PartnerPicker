import java.util.Scanner;
class Main{

   public static void main(String[] args){
      Scanner myObj = new Scanner(System.in);
      partnerProject a = new partnerProject("test", 10000);
      a.beginActivity();
      System.out.println("Type one to choose a partner. Type two see a list of partners");
      String choice;
      while(true){
         choice = myObj.nextLine();
         if(choice.equals("1")){
            a.list();
         }
         else{
             a.partnersRemaining();
         }
         System.out.println("Type one to choose a partner. Type two see a list of partners");
      }

     
      
      
   }



}

class partnerProject{
   String projectName;
   double value;
   private static boolean acGoing = false;
   private static String[][] partners = {{"Holland", "Alex", "false"},{ "Collin H.", "Luca", "false"}, {"Collin C.", "Nico", "false"}, {"Elia", "Ethan", "false"}, {"Sebastien", "Jake", "false"}, {"Landen", "Natalie", "false"}, {"Kaiden", "Morgan", "false"} ,{"Aaron", "Harvey", "false"}, {"Logan", "Owen", "false"}, {"Willow", "Josie", "false"}, {"Lyndia", "Marianna", "false"}, {"Kemka", "Quentin", "false"}, {"Ella", "JC", "false"} ,{"Aiden", "Ollie", "false"} ,{"Cove", "Aesop", "false"}};
   public partnerProject(String name, double pts){
      value = pts;
      projectName = name;
   }
   public static void beginActivity(){
      acGoing = true;
      
   }
   public static void endActivity(){
      acGoing = false;
   }
   public static void partnersRemaining(){
      if(!acGoing){
         System.out.println("The Activity Has Not Beguin Yet");
         return;
      }
      String all = "true";
      for(int i =0; i < partners.length; i++){
         if(partners[i][2] == "true"){
            all = "false";
         }
      }
      if(all.equals( "true")){
         System.out.println("No one has been called on");
         return;
      }
      
      System.out.println("Partners Who Have Not Been Chosen");
      for(int i =0; i < partners.length; i++){
         if(partners[i][2] == "false"){
            System.out.println(partners[i][0] + " and " + partners[i][1]);
         }
      }
   }
   public static int list(){
      int i = (int) (Math.random() * partners.length);
      // for(int  i = 0; i < partners.length; i++){
//          
//          if(partners[i][2].equals("false")){
//             partners[i][2] = "true";
//             return i;
//          }
//       }
      while(partners[i][2].equals("true")){
         i = (int) (Math.random() * partners.length);
      }
      partners[i][2] = "true";
      System.out.println(partners[i][0] + " and " + partners[i][1] + " have been chosen");
      return i;
   
   }
}