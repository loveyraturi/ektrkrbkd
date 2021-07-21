package com.praveen.browser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author www.javaworkspace.com
 * 
 */
public class Chrome
{
    public static void main (String[] args) 
    {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    try 
        {
        Class.forName ("org.sqlite.JDBC");
//        connection = DriverManager
//            .getConnection ("jdbc:sqlite:/home/username/.config/chromium/Default/History");
        connection = DriverManager
              .getConnection ("jdbc:sqlite:/Library/Caches/Google/Chrome");
        
        statement = connection.createStatement ();
        resultSet = statement
            .executeQuery ("SELECT * FROM urls where visit_count > 100");

        while (resultSet.next ()) 
            {
            System.out.println ("URL [" + resultSet.getString ("url") + "]" +
                        ", visit count [" + resultSet.getString ("visit_count") + "]");
            }
        } 

    catch (Exception e) 
        {
        e.printStackTrace ();
        } 

    finally 
        {
        try 
            {
            resultSet.close ();
            statement.close ();
            connection.close ();
            } 

        catch (Exception e) 
            {
            e.printStackTrace ();
            }
        }
    }
}
