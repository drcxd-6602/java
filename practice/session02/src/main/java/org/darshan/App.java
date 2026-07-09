package org.darshan;


import com.google.common.base.Joiner;

public class App {
    public static void main( String[] args )
    {
        String firstName = "Donald";
        String middleName = "John";
        String lastName = "Trump";
        String fullName = Joiner.on(" ").join(firstName, middleName, lastName);
        System.out.println(fullName);
    }
}
