package org.bsuir;

import org.bsuir.exception.EmptyFieldException;
import org.bsuir.view.MainFrameView;

import java.util.EmptyStackException;

public class Run
{
    public static void main( String[] args )
    {
        try{
            method();
        } catch (EmptyFieldException ignored){
            System.out.println(ignored.getMessage());
        }
        new MainFrameView();
    }

    public static void method() throws EmptyFieldException {
        try {
            throw new EmptyFieldException("ok");
        } finally {
            System.out.println("Not ok");
        }
    }
}
