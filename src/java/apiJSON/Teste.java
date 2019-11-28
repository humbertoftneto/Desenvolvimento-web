package apiJSON;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author humbe
 */
public class Teste {
    public static void main(String[] args) {
        
        if(LoginDao.validate("fulano", "123")){
                System.out.println("Bem vindo!");
            }
            else{
                System.out.println("Login e senha incorretos!");
            }
    }
}
