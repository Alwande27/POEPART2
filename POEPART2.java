/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
   import javax.swing.JOptionPane;
   import java.util.*;
   import java.io.*;
   import org.json.simple.JSONArray;
   import org.json.simple.JSONObject;
/**
 *
 * @author RC_Student_Lab
 */
public class POEPART2 {
    private static boolean exit;
    private static int Total_messages = 0;
    private static int Message_count;
    private static int messageCounter = 0;
    static final JSONArray messageStorage = new JSONArray();
    
    public static void main(String []ARGS){
        // 🔐 Require login before proceeding
    boolean loggedIn = login("administrator", "5678");
    if (!loggedIn) {
        JOptionPane.showMessageDialog(null, "Access Denied. Application will now close.");
        System.exit(0);
    }
         {
            
        }
     while(!exit){
         String [] Options={"Send message","show recently messages","Quit"};
         int Choice =JOptionPane.showOptionDialog(null, " select option ","Welcome to QuickChat",
          JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,Options,Options[0]);
         
         switch (Choice){
             case 0: sendMessage();
             break;
             case 1: showrecentlysentmessages();
             break;
             case 2://Quit
             exit= true;
             break;
             default: JOptionPane.showMessageDialog(null,"Invalid Option");
             break;
         }
     }    
    }
    static boolean login(String administrator,String password){
        String User_name=JOptionPane.showInputDialog("Enter Username");
        String pass_word =JOptionPane.showInputDialog("Enter password");
         if ("administrator".equals(User_name)&& "5678".equals(pass_word)){
             return true;
         }else{
             JOptionPane.showMessageDialog(null,"Login failed");
             return false;
         }
    }
    
    static void sendMessage(){
        long messageId=100000000000L+new Random().nextInt(900000000);
        messageCounter++;
        
        String recipient = JOptionPane.showInputDialog("Enter recipeint number (+ccxxxxxxxxx):");
       recipient = CheckRecipient(recipient);
       if (recipient==null) 
           return;//if
        
       String message = JOptionPane.showInputDialog("Enter your message (max 250 chrs):");
       if (message == null || message.length()>250){
           JOptionPane.showMessageDialog(null, "Please enter a ,essage of less than 250 characters");
           return;
       }
        String []words= message.trim().split("\\s+");
        String hash = String.format("%02d:%d:%s%s",
        Long.valueOf(Long.toString(messageId).substring(0,2)),
        messageCounter,
        words[0].toUpperCase(),
        words.length>1? words [words.length-1].toUpperCase():"");
                
        String[]actions ={"Send","Disregard","Store"};
        int action =JOptionPane.showOptionDialog(null,"Choose what to do with this message:","Message Options", Total_messages, Message_count,null,actions,actions[0]);
        
        if (action == 1){
            JOptionPane.showMessageDialog(null, "Message disregarded");
            return;
        }
            JSONObject jsonMessage= new JSONObject();
            jsonMessage.put("MessageID", messageId);
            jsonMessage.put("MessageHash", hash);
            jsonMessage.put("Recipient", recipient);
            jsonMessage.put("Message", message);
            
            if (action == 2){
                messageStorage.add(jsonMessage);
                JOptionPane.showMessageDialog(null,"Message stored");
                return;
            }
            Total_messages++;
            
            JOptionPane.showMessageDialog(null,
            """
             Message Sent!
             Message ID:""" + messageId+"\n"+
               "Message Hash:" + hash +"\n "+        
               "Recipient:" + recipient +"\n"+ 
               "Message:" + message);                                 
                                                
    }
        static void saveMessagesToJSON(){
          try (FileWriter file = new FileWriter("storeMessages.json")) {
              file.write(messageStorage.toJSONString());
              file.flush();
              System.out.println("Stored messages saved to storedMessages.json");
          }catch (IOException e){
              e.printStackTrace();
          
         
          }
        }
private static String CheckRecipient(String recipient){
    if(recipient == null|| !recipient.matches("\\+\\d{9,12}")){
      JOptionPane.showMessageDialog(null,"Invalid number.Must include internatiional code and be <=12 digits");
      return null;
    }
    return recipient;
}

static void showrecentlysentmessages(){
    if (messageStorage.isEmpty()){
        JOptionPane.showMessageDialog(null,"Coming Soon");
        return;
    }
    
StringBuilder output = new StringBuilder("Stored Messages:\n\n");
for (Object obj : messageStorage){
    JSONObject msg = (JSONObject)obj;
    output.append("ID:").append(msg.get("MessageID")).append("\n")
    .append("Recipient:").append(msg.get("Recipient")).append("/n")
    .append("Message:").append(msg.get("Message")).append("/n")  
    .append("---\n");                
    
}
JOptionPane.showMessageDialog(null,output.toString());
}}
