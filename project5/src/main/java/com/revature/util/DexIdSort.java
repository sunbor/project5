package com.revature.util;

import java.util.Comparator;

import com.revature.models.Digimon;

public class DexIdSort implements Comparator<Digimon> 
{ 
    // Used for sorting in ascending order of 
    // dex id
    public int compare(Digimon a, Digimon b) 
    { 
        return a.getDigiDexId() - b.getDigiDexId(); 
    } 
} 