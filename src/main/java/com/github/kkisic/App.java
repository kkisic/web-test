package com.github.kkisic;

import com.github.kkisic.cofiguration.SystemConfiguration;
import enkan.system.EnkanSystem;

public class App
{
    public static void main( String[] args )
    {
        EnkanSystem system = new SystemConfiguration().create();
        Runtime.getRuntime().addShutdownHook(new Thread(system::stop));
        system.start();
    }
}
