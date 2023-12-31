package UrlShortner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlImplementation implements UrlInterface{

    //definign the map outside the class functions as we have to first check whether entry already in that map or not
    //now we need a hashmaps to store coresponding short url to longurl mappping.
    private HashMap<String,String> map; // key longUrl and pair is ShortUrl
    private HashMap<String,Integer>hitCount;//for storing the hit count

    //constructor to make objects of these above references only when the object of this class is created
    public UrlImplementation(){
        map = new HashMap<>();
        hitCount = new HashMap<>();
    }
 
 
    //now from here implementing the Abstract functions of XUrl.java Interface==================
    @Override
    public String registerNewUrl(String longUrl){

        //if pressnt then return the shortUrl value
        if(map.containsKey(longUrl)) return map.get(longUrl);

        //if not present then create a shorturl corespong to this and add in map and then return this new shortUrl
        else{
            //as we have to make a short URL in format like - http://short.url/xxxxxxxxx, 
            //where xxxxxxxxx is a unique alphanumeric string which is 9 characters in length. 
            // here below Java code to generate a random alphanumeric string of length 9characters:
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiljkmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuilder alphacode = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                int index = random.nextInt(characters.length());
                char character = characters.charAt(index);
                alphacode.append(character);
            }

            //now generating the shortUrl as said above-
            StringBuilder shortUrl = new StringBuilder();
            shortUrl.append("http://short.url/");
            shortUrl.append(alphacode);


            //now we need a hashmaps to store coresponding short url to longurl mappping 
            map.put(longUrl,shortUrl.toString()); // as shortUrl is of stringBuilder type

            //storing the hitCounts also
            hitCount.put(longUrl,0);

            return shortUrl.toString();
        } 
    }


    
    // This is an overloaded method which takes an extra parameter.
    // Users can specify their own custom shortUrl to be used for a longUrl, using this method. 
    // This along with the earlier registerNewUrl(String longUrl) method allows users the flexibility to 
    //specify the optional custom short Url.
    // If the shortUrl already exists, return null.
    // If the shortUrl is not present, register a mapping between the longUrl and shortUrl specified and return the shortUrl.
    // Note1: Assume that the short URL specified by user will conform to this pattern - http://short.url/<alphanumericstring>
    // Note2: Assume that the user will not specify a longUrl which is already present or used.
    @Override
    public String registerNewUrl(String longUrl, String shortUrl){

        //If the shortUrl already exists, return null.
        if(map.containsValue(shortUrl)) return null;

        // If the shortUrl is not present, register a mapping between the longUrl and 
        //shortUrl specified and return the shortUrl.
        else{
            map.put(longUrl,shortUrl);
            hitCount.put(longUrl,0);
            return shortUrl;
        }
    }

     // If shortUrl doesn't have a corresponding longUrl, return null
    // Else, return the corresponding longUrl
    //here we also update the hitCount, how many times the user searches for a specific longUrl and shortUrl pair.
    @Override
    public String getUrl(String shortUrl){

        //first checking in map, if entry exist then update the hitcount and return the LongUrl based on this shortUrl
        for(Map.Entry<String,String>entry : map.entrySet()){
            if(entry.getValue().equals(shortUrl)){
                hitCount.put(entry.getKey(), hitCount.get(entry.getKey())+1);
                return entry.getKey();
            }
        }

        //if shortUrl not exist in map, then return null for this
        return null;
    }



   // Return the number of times the longUrl has been looked up using getUrl()
   @Override
    public Integer getHitCount(String longUrl){

        //this will return the hitcount of the longUrl, if longUrl not present in map, it return 0
        return hitCount.getOrDefault(longUrl,0);

    }


    // You should not reset the Hit Count for a longUrl even if the longUrl is deleted using delete().
    //Delete the mapping between this longUrl and its corresponding shortUrl
    // Do not zero the Hit Count for this longUrl
    @Override
    public String delete(String longUrl){
        
        String shortUrl=map.remove(longUrl);

        //removing the hitCount for the specific longUrl, as we are deleting the enrty of LongUrl from map
        hitCount.remove(longUrl);
        return shortUrl;

    }
}