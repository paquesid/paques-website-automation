package data;

/**
 * Created by Dika Brenda Angkasa on 05/30/2022
 */

public class PDSData {
    
    private static String username = "";
    private static String password = "";
    private static boolean loggedIn = false;

    public static String getUsername(){
        return username;
    }

    public static void setUsername(String username){
        PDSData.username = username;
    }

    public static String getPassword(){
        return password;
    }

    public static void setPassword(String password){
        PDSData.password = password;
    }
    
    public static boolean isLoggedIn(){
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn){
        PDSData.loggedIn = loggedIn;
    }
}