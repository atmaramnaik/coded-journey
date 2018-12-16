package com.atmaram.cj.core;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    public List<CommandRegistryEntry> entries=new ArrayList<>();
    public void add(CommandRegistryEntry entry){
           entries.add(entry);
    }
}
