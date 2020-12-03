/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baghdadzazai.phonecomparrison;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/** Example code to illustrate web scraping with JSoup */
public class PhoneScrapper2 {
    
    
    /** Constructor */
    PhoneScrapper2(){
        try{
            scrapePhone();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    void scrapePhone() throws Exception{
      
        
        //Download HTML document from website
        Document doc = Jsoup.connect("https://www.johnlewis.com/browse/electricals/mobile-phones-accessories/view-all-mobile-phones/_/N-a8v").get();
        
        //Get all of the products on the page
        Elements prods = doc.select(".product-card");
        
        //Work through the products
        for(int i=0; i<prods.size(); ++i){
            
            //Get the product description
            Elements description = prods.get(i).select(".product-card__title-inner");
            
            //Get the product price
            Elements price1 = prods.get(i).select(".product-card__wrap-link");
            Elements finalPrice = price1.select(".product-card__price-span");
            
            
            
            //Output the data that we have downloaded
            System.out.println("DESCRIPTION: " + description.text() + 
                     "; PRICE: " + finalPrice.text());
        }
    }
}
