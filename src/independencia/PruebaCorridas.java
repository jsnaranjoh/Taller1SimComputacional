/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package independencia;

import static java.lang.Math.sqrt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vista.VistaPrincipal;
import vista.VistaPruebasIndependencia;

/**
 *
 * @author jsnar
 */
public class PruebaCorridas {
    
    private String corridas;
    private Integer numeroCorridas;
    
    public boolean ejecutarPrueba() {
        buscarCorridas();
        
        Double media;
        Double varianza;
        Double ZCritPositivo;
        Double ZCritNegativo;
        Double ZCalc;
        
        Integer cantidadNumerosGenerados = VistaPrincipal.listaNumerosGenerados.size();
        
        media = ((2 * cantidadNumerosGenerados) - 1) / 3.;
        varianza = ((16 * cantidadNumerosGenerados) - 29) / 90.;
        ZCritPositivo =  1.96;
        ZCritNegativo = -1.96;
        ZCalc = (numeroCorridas - media) / sqrt(varianza);
        
        if(ZCalc <= ZCritPositivo && ZCalc >= ZCritNegativo) {
            return true;
        } else {
            return false;
        }
    }
    
    public void buscarCorridas() {
        corridas = "*";
        
        for(Integer i=1; i<VistaPrincipal.listaNumerosGenerados.size(); i++) {
            if(VistaPrincipal.listaNumerosGenerados.get(i) > VistaPrincipal.listaNumerosGenerados.get(i-1)) {
                corridas += "+";
            } else {
                corridas += "-";
            }
        }
        
        corridas += " ";
        VistaPruebasIndependencia.areaNumerosGenerados.setText(corridas);
        contarCorridas();
    }
    
    public void contarCorridas() {
        String asterisco = "\\\\*";
        String mas = "\\+";
        String menos = "\\-";
        String espacio = " ";
        String casoPrimeraCorrida;
        String casoOtrasCorridas;
        String casoUltimaCorrida;
        
        numeroCorridas = 0;
        
        for(Integer i=1; i<=VistaPrincipal.listaNumerosGenerados.size(); i++) {
            casoPrimeraCorrida = asterisco;
            casoOtrasCorridas = menos;
            casoUltimaCorrida = menos;
            for(Integer j=1; j<=i; j++) {
                casoPrimeraCorrida += mas;
                casoOtrasCorridas += mas;
                casoUltimaCorrida += mas;
            }
            
            casoPrimeraCorrida += menos;
            casoOtrasCorridas += menos;
            casoUltimaCorrida += espacio;
            
            Pattern patronCasoPrimeraCorrida = Pattern.compile(casoPrimeraCorrida);
            Pattern patronCasoOtrasCorridas = Pattern.compile(casoOtrasCorridas);
            Pattern patronCasoUltimaCorrida = Pattern.compile(casoUltimaCorrida);
            
            Matcher matcherCasoPrimeraCorrida = patronCasoPrimeraCorrida.matcher(corridas);
            Matcher matcherCasoOtrasCorridas = patronCasoOtrasCorridas.matcher(corridas);
            Matcher matcherCasoUltimaCorrida = patronCasoUltimaCorrida.matcher(corridas);
            
            if(matcherCasoPrimeraCorrida.find()) {
                numeroCorridas++;
            }
            
            while(matcherCasoOtrasCorridas.find()) {
                numeroCorridas++;
            }
            
            if(matcherCasoUltimaCorrida.find()) {
                numeroCorridas++;
            }
        }
        
        for(Integer i=1; i<=VistaPrincipal.listaNumerosGenerados.size(); i++) {
            casoPrimeraCorrida = asterisco;
            casoOtrasCorridas = mas;
            casoUltimaCorrida = mas;
            for(Integer j=1; j<=i; j++) {
                casoPrimeraCorrida += menos;
                casoOtrasCorridas += menos;
                casoUltimaCorrida += menos;
            }
            
            casoPrimeraCorrida += mas;
            casoOtrasCorridas += mas;
            casoUltimaCorrida += espacio;
            
            Pattern patronCasoPrimeraCorrida = Pattern.compile(casoPrimeraCorrida);
            Pattern patronCasoOtrasCorridas = Pattern.compile(casoOtrasCorridas);
            Pattern patronCasoUltimaCorrida = Pattern.compile(casoUltimaCorrida);
            
            Matcher matcherCasoPrimeraCorrida = patronCasoPrimeraCorrida.matcher(corridas);
            Matcher matcherCasoOtrasCorridas = patronCasoOtrasCorridas.matcher(corridas);
            Matcher matcherCasoUltimaCorrida = patronCasoUltimaCorrida.matcher(corridas);
            
            if(matcherCasoPrimeraCorrida.find()) {
                numeroCorridas++;
            }
            
            while(matcherCasoOtrasCorridas.find()) {
                numeroCorridas++;
            }
            
            if(matcherCasoUltimaCorrida.find()) {
                numeroCorridas++;
            }
        }    
        VistaPruebasIndependencia.labelNumeroCorridas.setText(String.valueOf(numeroCorridas));
    }
}
