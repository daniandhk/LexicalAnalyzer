/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
/**
 *
 * @author dania
 */
public class Main {
    
    public static Object[] cekKurung(Stack<String> Cek,Stack<String> Token, int TopCek, int Top, boolean valid){
        Object[] O = new Object[2];
        if(!Cek.isEmpty()){    
            Token.push(Cek.pop());
            TopCek--;
            Top++;
            if(Token.get(Top)=="1"){
                O = cekProposisi(Cek,Token,TopCek,Top,valid);
                valid=(boolean)O[0];
                Top=(int)O[1];
                if(valid&&!Cek.isEmpty()){
                    Token.push(Cek.pop());
                    TopCek--;
                    Top++;
                    if(Token.get(Top)=="10"){
                        if(!Cek.isEmpty()){
                            if(Cek.lastElement()!="1"){
                                Token.push(Cek.pop());
                                TopCek--;
                                Top++;
                                if(Token.get(Top)=="10"){
                                    valid=true;
                                }
                                else if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                                    if(!Cek.isEmpty()){    
                                        Token.push(Cek.pop());
                                        TopCek--;
                                        Top++;
                                        if(Token.get(Top)!="1"){
                                            if(Token.get(Top)=="2"){
                                                O = cekNot(Cek,Token,TopCek,Top,valid);
                                                valid = (boolean)O[0];
                                            }
                                            else if(Token.get(Top)=="9"){
                                                O = cekKurung(Cek,Token,TopCek,Top,valid);
                                                valid = (boolean)O[0];
                                            }
                                            else{
                                                valid = false;
                                            }
                                        }
                                        else{
                                            if(!Cek.isEmpty()){
                                                O = cekProposisi(Cek,Token,TopCek,Top,valid);
                                                valid = (boolean)O[0];
                                            }
                                            else{
                                                valid = true;
                                            }
                                        }
                                    }
                                    else{
                                        valid = false;
                                    }
                                }
                                else if(Token.get(Top)=="7"){
                                    if(!Cek.isEmpty()){
                                        Token.push(Cek.pop());
                                        TopCek--;
                                        Top++;
                                        if(Token.get(Top)=="9"){
                                            O = cekKurung(Cek,Token,TopCek,Top,valid);
                                            valid=(boolean)O[0];
                                        }
                                        else if(Token.get(Top)=="1"){
                                            valid=true;
                                        }
                                        else{
                                            valid = false;
                                        }
                                    }
                                    else{
                                        valid=false;
                                    }
                                }
                                else{
                                    valid = false;
                                }
                            }
                            else{
                                O = cekProposisi(Cek,Token,TopCek,Top,valid);
                                valid = (boolean)O[0];
                            }
                        }
                        else{
                            valid = true;
                        }
                    }
                    else if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                        if(!Cek.isEmpty()){
                            Token.push(Cek.pop());
                            TopCek--;
                            Top++;
                            if(Token.get(Top)=="9"){
                                O = cekKurung(Cek,Token,TopCek,Top,valid);
                                valid=(boolean)O[0];
                            }
                            else{
                                valid = false;
                            }
                        }
                        else{
                            valid = false;
                        }
                    }
                    else{
                        valid = false;
                    }
                }
                else if(valid&&Cek.isEmpty()){
                    valid=true;
                }
                else if(valid){
                    valid=true;
                }
                else{
                    valid = false;
                }
            }
            else if(Token.get(Top)=="2"){
                O = cekNot(Cek,Token,TopCek,Top,valid);
                valid=(boolean)O[0];
                Top=(int)O[1];
                if(valid&&!Cek.isEmpty()){
                    Token.push(Cek.pop());
                    TopCek--;
                    Top++;
                    if(Token.get(Top)=="10"){
                        valid = true;
                    }
                    else if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                        if(!Cek.isEmpty()){
                            Token.push(Cek.pop());
                            TopCek--;
                            Top++;
                            if(Token.get(Top)=="9"){
                                O = cekKurung(Cek,Token,TopCek,Top,valid);
                                valid=(boolean)O[0];
                            }
                            else{
                                valid = false;
                            }
                        }
                        else{
                            valid = false;
                        }
                    }
                    else{
                        valid = false;
                    }
                }
                else if(valid){
                    valid = true;
                }
                else{
                    valid = false;
                }
            }
            else if(Token.get(Top)=="6"){
                O = cekIf(Cek,Token,TopCek,Top,valid);
                valid=(boolean)O[0];
                Top=(int)O[1];
                if(valid&&!Cek.isEmpty()){
                    Token.push(Cek.pop());
                    TopCek--;
                    Top++;
                    if(Token.get(Top)=="10"){
                        valid = true;
                    }
                    else if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                        if(!Cek.isEmpty()){
                            Token.push(Cek.pop());
                            TopCek--;
                            Top++;
                            if(Token.get(Top)=="9"){
                                O = cekKurung(Cek,Token,TopCek,Top,valid);
                                valid=(boolean)O[0];
                            }
                            else{
                                valid = false;
                            }
                        }
                        else{
                            valid = false;
                        }
                    }
                    else{
                        valid = false;
                    }
                }
                else if(valid){
                    valid = true;
                }
                else{
                    valid = false;
                }
            }
            else if(Token.get(Top)=="9"){
                O = cekKurung(Cek,Token,TopCek,Top,valid);
                valid=(boolean)O[0];
                Top=(int)O[1];
                if(valid&&!Cek.isEmpty()){
                    Token.push(Cek.pop());
                    TopCek--;
                    Top++;
                    if(Token.get(Top)=="10"){
                        valid = true;
                    }
                    else if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                        if(!Cek.isEmpty()){
                            Token.push(Cek.pop());
                            TopCek--;
                            Top++;
                            if(Token.get(Top)=="9"){
                                O = cekKurung(Cek,Token,TopCek,Top,valid);
                                valid=(boolean)O[0];
                            }
                            else{
                                valid = false;
                            }
                        }
                        else{
                            valid = false;
                        }
                    }
                    else{
                        valid = false;
                    }
                }
                else if(valid){
                    valid = true;
                }
                else{
                    valid = false;
                }
            }
            else{
                valid=false;
            }
        }
        else{
            valid=false;
        }
        Object[] o = new Object[2];
        o[0]=valid;
        o[1]=Top;
        return o;
    }
    
    public static Object[] cekIf(Stack<String> Cek,Stack<String> Token, int TopCek, int Top, boolean valid){
        if(!Cek.isEmpty()){    
            Token.push(Cek.pop());
            TopCek--;
            Top++;
            if(Token.get(Top)=="1"){
                if(!Cek.empty()){
                    Token.push(Cek.pop());
                    TopCek--;
                    Top++;
                    if(Token.get(Top)=="7"){
                        if(!Cek.empty()){
                            Token.push(Cek.pop());
                            TopCek--;
                            Top++;
                            if(Token.get(Top)=="1"){
                                valid = true;
                            }
                            else if(Token.get(Top)=="9"){
                                Object[] O = cekKurung(Cek,Token,TopCek,Top,valid);
                                valid = (boolean)O[0];
                            }
                            else{
                                valid = false;
                            }
                        }
                        else{
                            valid = false;
                        }
                    }
                    else{
                        valid = false;
                    }
                }
                else{
                    valid = false;
                }
            }
            else if(Token.get(Top)=="9"){
                Object[] O = cekKurung(Cek,Token,TopCek,Top,valid);
                valid = (boolean)O[0];
            }
            else{
                valid=false;
            }
        }
        else{
            valid=false;
        }
        Object[] o = new Object[2];
        o[0]=valid;
        o[1]=Top;
        return o;
    }
    
    public static Object[] cekNot(Stack<String> Cek,Stack<String> Token, int TopCek, int Top, boolean valid){
        if(!Cek.isEmpty()){    
            Token.push(Cek.pop());
            TopCek--;
            Top++;
            if(Token.get(Top)=="1"){
                Object[] O = cekProposisi(Cek,Token,TopCek,Top,valid);
                valid=(boolean)O[0];
            }
            else if(Token.get(Top)=="9"){
                Object[] O = cekKurung(Cek,Token,TopCek,Top,valid);
                valid = (boolean) O[0];
            }
            else{
                valid=false;
            }
        }
        else{
            valid=false;
        }
        Object[] o = new Object[2];
        o[0]=valid;
        o[1]=Top;
        return o;
    }
    //&&Cek.get(TopCek)!="10"
    public static Object[] cekProposisi(Stack<String> Cek,Stack<String> Token, int TopCek, int Top, boolean valid){
        if(!Cek.isEmpty()&&Cek.lastElement()!="10"){    
            Token.push(Cek.pop());
            TopCek--;
            Top++;
            if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                if(!Cek.isEmpty()){    
                    Token.push(Cek.pop());
                    TopCek--;
                    Top++;
                    if(Token.get(Top)!="1"){
                        if(Token.get(Top)=="2"){
                            Object[] O = cekNot(Cek,Token,TopCek,Top,valid);
                            valid = (boolean)O[0];
                        }
                        else if(Token.get(Top)=="9"){
                            Object[] O = cekKurung(Cek,Token,TopCek,Top,valid);
                            valid = (boolean)O[0];
                        }
                        else{
                            valid = false;
                        }
                    }
                    else{
                        if(!Cek.isEmpty()){
                            Object[] O = cekProposisi(Cek,Token,TopCek,Top,valid);
                            valid = (boolean)O[0];
                        }
                        else{
                            valid = true;
                        }
                    }
                }
                else{
                    valid = false;
                }
            }
            else{
                valid=false;
            }
        }
        else{
            valid=true;
        }
        Object[] o = new Object[2];
        o[0]=valid;
        o[1]=Top;
        return o;
    }
    
    public static void main(String[] args) {
        Stack<String> Token = new Stack<String>();
        int Top = -1;
        System.out.print("Input: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] temp = input.toCharArray();
        
        int i = 0;
        while(i<temp.length){
            if(temp[i]=='p'||temp[i]=='q'||temp[i]=='r'||temp[i]=='s'||temp[i]=='P'||temp[i]=='Q'||temp[i]=='R'||temp[i]=='S'){
                Token.push("1");
                Top++;
                i++;
            }
            else if(temp[i]=='n'||temp[i]=='N'){
                if(temp[i+1]=='o'||temp[i+1]=='O'){
                    if(temp[i+2]=='t'||temp[i+2]=='T'){
                        Token.push("2");
                        Top++;
                        i++;
                        i++;
                        i++;
                    }
                    else{
                        Token.push("error");
                        Top++;
                        i=temp.length;
                    }  
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                } 
            }
            else if(temp[i]=='a'||temp[i]=='A'){
                if(temp[i+1]=='n'||temp[i+1]=='N'){
                    if(temp[i+2]=='d'||temp[i+2]=='D'){
                        Token.push("3");
                        Top++;
                        i++;
                        i++;
                        i++;
                    }
                    else{
                        Token.push("error");
                        Top++;
                        i=temp.length;
                    }   
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                } 
            }
            else if(temp[i]=='o'||temp[i]=='O'){
                if(temp[i+1]=='r'||temp[i+1]=='R'){
                    Token.push("4");
                    
                    Top++;
                    i++;
                    i++;
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                }   
            }
            else if(temp[i]=='x'||temp[i]=='X'){
                if(temp[i+1]=='o'||temp[i+1]=='O'){
                    if(temp[i+2]=='r'||temp[i+2]=='R'){
                        Token.push("5");
                        
                        Top++;
                        i++;
                        i++;
                        i++;
                    }
                    else{
                        Token.push("error");
                        Top++;
                        i=temp.length;
                    }   
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                }   
            }
            else if(temp[i]=='i'||temp[i]=='I'){
                if(temp[i+1]=='f'||temp[i+1]=='F'){
                    if(temp.length-1==i+1){
                        Token.push("6");
                        
                        Top++;
                        i++;
                        i++;
                    }
                    else{
                        if(temp[i+2]=='f'||temp[i+2]=='F'){
                            Token.push("8");
                            
                            Top++;
                            i++;
                            i++;
                            i++;
                        }
                        else if(temp[i+2]==' '){
                            Token.push("6");
                            
                            Top++;
                            i++;
                            i++;
                        }
                        else{
                            Token.push("error");
                            Top++;
                            i=temp.length;
                        }   
                    }
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                }   
            }
            else if(temp[i]=='t'||temp[i]=='T'){
                if(temp[i+1]=='h'||temp[i+1]=='H'){
                    if(temp[i+2]=='e'||temp[i+2]=='E'){
                        if(temp[i+3]=='n'||temp[i+3]=='N'){
                            
                                Token.push("7");
                                Top++;
                                i++;
                                i++;
                                i++;
                                i++;
                        }
                        else{
                            Token.push("error");
                            Top++;
                            i=temp.length;
                        }
                    }
                    else{
                        Token.push("error");
                        Top++;
                        i=temp.length;
                    }                    
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                }   
            }
            else if(temp[i]=='('){
                Token.push("9");
                Top++;
                i++;
            }
            else if(temp[i]==')'){
                Token.push("10");
                Top++;
                i++;
            }
            else{
                if(temp[i]==' '){
                i++;
                }
                else{
                    Token.push("error");
                    Top++;
                    i=temp.length;
                }
            }
        }
        
        int j = 0;
        System.out.print("Token Lexic: ");
        while(j<=Top){
            System.out.print(Token.get(j)+" ");
            j++;
        }
        
        Stack<String> Cek = new Stack<String>();
        int TopCek = -1;
        while(!Token.isEmpty()){
            Cek.push(Token.pop());
        }
        TopCek=Top;
        Top=-1;
        boolean valid=true;
        Object[] o = new Object[2];
        
        while((!Cek.isEmpty())&&(valid)){
            Token.push(Cek.pop());
            TopCek--;
            Top++;
            if(Token.get(Top)=="1"){
                o = cekProposisi(Cek,Token,TopCek,Top,valid);
                valid=(boolean)o[0];
                Top=(int)o[1];
                
            }
            else if(Token.get(Top)=="error"){
                valid=false;
            }
            else if(Token.get(Top)=="3"||Token.get(Top)=="4"||Token.get(Top)=="5"||Token.get(Top)=="8"){
                valid = false;
            }
            else if(Token.get(Top)=="2"){
                o = cekNot(Cek,Token,TopCek,Top,valid);
                valid=(boolean)o[0];
                Top=(int)o[1];
            }
            else if(Token.get(Top)=="6"){
                o = cekIf(Cek,Token,TopCek,Top,valid);
                valid=(boolean)o[0];
                Top=(int)o[1];
            }
            else if(Token.get(Top)=="9"){
                o = cekKurung(Cek,Token,TopCek,Top,valid);
                valid=(boolean)o[0];
                Top=(int)o[1];
            }
            else if(Token.get(Top)=="10"){
                valid = false;
            }
            else{
                valid = false;
            }
        }
        if(valid){
            System.out.println("\nVALID");
        }
        else{
            System.out.println("\nNOT VALID");
        }
    }
}
