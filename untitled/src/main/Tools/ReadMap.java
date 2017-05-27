package main.Tools;

import main.GameHandler;
import main.GameObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.lang.reflect.Constructor;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.*;






//para basahon ang file
public class ReadMap  {

    BufferedReader br;

javax.swing.Timer timer;

    public void openFile(String dir){  //open txt
        try{
            br = new BufferedReader(new FileReader(dir));

        }catch(Exception e){
            System.out.println("Not Found");


        }


    }



    public void readFile(){  //read
        Scanner scan;
        boolean called = false;



        try {

            String line;
            while ((line = br.readLine()) != null) {
                try{
                    scan = new Scanner(line);
                    String scanString = scan.next();

                    if(scanString.equals("createobject:")){


                        String ob = scan.next();

                        Class<?> obj = Class.forName(ob);
                        Constructor<?> cons = obj.getConstructor(int.class,int.class);

                        Object objec = cons.newInstance(200,8);


                        GameObject temp = GameObject.class.cast(objec);

                        if(!called) {
                            GameHandler.objectHandler.AddObject(temp);
                            GameHandler.objectHandler.AddObject(temp);
                        }else{
                            GameHandler.objectHandler.AddObject(temp);
                            called = true;
                        }

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        }catch (Exception e){
            System.out.println(e);

        }

    }
}

