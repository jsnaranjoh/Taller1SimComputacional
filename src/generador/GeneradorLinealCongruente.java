/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package generador;

import java.util.ArrayList;
import vista.VistaPrincipal;

/**
*
* @author Estudiante Univalle
*/

public class GeneradorLinealCongruente {
   
   private Integer a;
   private Integer m;
   private Integer c;
   private Integer xo;
   
   public GeneradorLinealCongruente(Integer a,Integer xo, Integer c, Integer m) {
       this.a = a;
       this.m = m;
       this.c = c;
       this.xo = xo;
   }
   
   public void generarNumeros() {
       VistaPrincipal.listaNumerosGenerados = new ArrayList<>();
       VistaPrincipal.numeroMasGrandePosible = m - 1.0;
       Integer xn = xo;
       
       do {
           VistaPrincipal.listaNumerosGenerados.add(xn);
           xn = (a * xn + c) % m;
       } while(!VistaPrincipal.listaNumerosGenerados.contains(xn));
   }
}