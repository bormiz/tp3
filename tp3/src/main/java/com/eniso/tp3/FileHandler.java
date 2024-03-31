/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.eniso.tp3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aziz
 */
public class FileHandler {
    private String filepath;
    private int fileSizeInKb;
    private int numberOfLines;
    private ArrayList <String> fileContent;
    public FileHandler (String filePath) throws FileNotFoundException, IOException{
        this.filepath=filePath;
        File f= new File(filePath);
        
        if (f.exists()) {
        this.filepath=filePath;
        this.fileSizeInKb=(int) (f.length()/1000);
        this.fileContent = new ArrayList<>();
        this.numberOfLines = 0;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (br.readLine() != null)
        this.numberOfLines++;
        }
        else System.out.println("le fichier n'existe pas");
    
    }
    public void readFile() throws FileNotFoundException, IOException{
        File f = new File(this.filepath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        while (br.readLine() != null){
        
        this.fileContent.add(br.readLine());
        }
        
        
    }
    public ArrayList findLinesWithPatter (String pattern) throws FileNotFoundException, IOException{
     File f = new File(this.filepath);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> L = new ArrayList<>();
        while (br.readLine() != null){
        if ((br.readLine().indexOf(pattern) > 0))
           L.add(br.readLine()); 
        }
        return L;
    }
    public boolean compareStrings1 (String str1, String str2){
        return str2 == str1;
    }
    public boolean compareStrings2 (String str1, String str2){
     return str1.equals(str2);
    }
    public boolean compareStrings3 (String str1, String str2){
        return str1.equalsIgnoreCase(str2);
    }
    public StringBuilder reverseString (int ligneIndex){
     String str = this.fileContent.get(ligneIndex);
      StringBuilder sb = new StringBuilder();
      sb.append(str);
      sb = sb.reverse(); 
    return sb;
    }
    public String removeDuplicates(int lineIndex){
     Set<Character> seen = new HashSet<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < fileContent.get(lineIndex).length(); i++) {
            char currentChar = fileContent.get(lineIndex).charAt(i);
            if (!seen.contains(currentChar)) {
                seen.add(currentChar);
                output.append(currentChar);
            }
    }
        return output.toString();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getFileSizeInKb() {
        return fileSizeInKb;
    }

    public void setFileSizeInKb(int fileSizeInKb) {
        this.fileSizeInKb = fileSizeInKb;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public ArrayList<String> getFileContent() {
        return fileContent;
    }

    public void setFileContent(ArrayList<String> fileContent) {
        this.fileContent = fileContent;
    }
    
    
}
