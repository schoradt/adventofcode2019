/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schoradt.adventofcode2019;

import java.util.List;

/**
 *
 * @author schoradt
 */
public class Runner {
    public static void main(String [] args) {
        Runner.runDays();
    }
    
    public static void runDays() {
        Runner runner = new Runner();
        
        runner.day01();
        runner.day02();
    }
    
    public void day01() {
        Day01 day = new Day01();
        
        List<Integer> masses = day.parseIntergerLines(day.loadLines("data/day01.txt"));
        
        int result1 = day.sumFuels(masses);
        
        System.out.println("day01 result 1 " + result1);
        
        int result2 = day.sumAllFuels(masses);
        
        System.out.println("day01 result 2 " + result2);
    }
    
    public void day02() {
        Day02 day = new Day02();
        
        List<Integer> programm = day.parseIntergerLines(day.splitLine(day.loadLines("data/day02.txt").get(0)));
        
        programm.set(1, 12);
        programm.set(2, 2);
        
        int result1 = day.processProgramm(programm);
        
        System.out.println("day02 result 1 " + result1);
        
        List<Integer> programm2 = day.parseIntergerLines(day.splitLine(day.loadLines("data/day02.txt").get(0)));
        
        int result2 = day.hackNounVerb(programm2, 19690720);
        
        System.out.println("day02 result 2 " + result2);
    }
    
}