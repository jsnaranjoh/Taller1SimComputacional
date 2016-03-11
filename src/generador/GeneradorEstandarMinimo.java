/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generador;

import static java.lang.Math.floor;
import java.util.ArrayList;
import vista.VistaPrincipal;

/**
 *
 * @author Estudiante Univalle
 */
public class GeneradorEstandarMinimo {
    
    private Integer a;
    private Integer m;
    private Integer q;
    private Integer r;
    private Integer xo;
    
    public GeneradorEstandarMinimo(Integer a, Integer m, Integer xo) {
        this.a = a;
        this.m = m;
        
        Double qDouble = floor(m / a);
        this.q = qDouble.intValue();
        
        this.r = m % a;
        this.xo = xo;
    }
    
    public void generarNumeros() {
        VistaPrincipal.listaNumerosGenerados = new ArrayList<>();
        VistaPrincipal.numeroMasGrandePosible = m - 1.0;
        Integer xn = xo;
        Double xnDouble;
        
        do {
            VistaPrincipal.listaNumerosGenerados.add(xn);
            xnDouble = (a * (xn % q)) - (r * (floor(xn / q)));
            xn = xnDouble.intValue();
            if(xn < 0) {
                xn += m;
            }
        } while(!VistaPrincipal.listaNumerosGenerados.contains(xn));
    }
}
