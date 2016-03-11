/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniformidad;

import static java.lang.Math.pow;
import vista.VistaPrincipal;
import vista.VistaPruebasUniformidad;

/**
 *
 * @author jsnar
 */
public class PruebaChiCuadrado {
       
    public boolean ejecutarPrueba() {
        Integer fOPrimerRango = 0;
        Integer fOSegundoRango = 0;
        Integer fOTercerRango = 0;
        Integer fOCuartoRango = 0;
        Integer fOQuintoRango = 0;
        Integer fOSextoRango = 0;
        Integer fOSeptimoRango = 0;
        Integer fOOctavoRango = 0;
        Integer fONovenoRango = 0;
        Integer fODecimoRango = 0;
        
        for(Integer numeroGenerado: VistaPrincipal.listaNumerosGenerados) {
            if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.1) { fOPrimerRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.2) { fOSegundoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.3) { fOTercerRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.4) { fOCuartoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.5) { fOQuintoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.6) { fOSextoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.7) { fOSeptimoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.8) { fOOctavoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 0.9) { fONovenoRango++; }
            else if(numeroGenerado/VistaPrincipal.numeroMasGrandePosible <= 1.0) { fODecimoRango++; }
        }
        
        Integer cantidadNumerosGenerados = VistaPrincipal.listaNumerosGenerados.size();
        Double fEsperada = cantidadNumerosGenerados / 10.0;
        
        Double chiCPrimerRango = calcularChiCuadrado(fOPrimerRango, fEsperada);
        Double chiCSegundoRango = calcularChiCuadrado(fOSegundoRango, fEsperada);
        Double chiCTercerRango = calcularChiCuadrado(fOTercerRango, fEsperada);
        Double chiCCuartoRango = calcularChiCuadrado(fOCuartoRango, fEsperada);
        Double chiCQuintoRango = calcularChiCuadrado(fOQuintoRango, fEsperada);
        Double chiCSextoRango = calcularChiCuadrado(fOSextoRango, fEsperada);
        Double chiCSeptimoRango = calcularChiCuadrado(fOSeptimoRango, fEsperada);
        Double chiCOctavoRango = calcularChiCuadrado(fOOctavoRango, fEsperada);
        Double chiCNovenoRango = calcularChiCuadrado(fONovenoRango, fEsperada);
        Double chiCDecimoRango = calcularChiCuadrado(fODecimoRango, fEsperada);
        
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.0 - 0.1", fOPrimerRango, fEsperada, chiCPrimerRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.1 - 0.2", fOSegundoRango, fEsperada, chiCSegundoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.2 - 0.3", fOTercerRango, fEsperada, chiCTercerRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.3 - 0.4", fOCuartoRango, fEsperada, chiCCuartoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.4 - 0.5", fOQuintoRango, fEsperada, chiCQuintoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.5 - 0.6", fOSextoRango, fEsperada, chiCSextoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.6 - 0.7", fOSeptimoRango, fEsperada, chiCSeptimoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.7 - 0.8", fOOctavoRango, fEsperada, chiCOctavoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.8 - 0.9", fONovenoRango, fEsperada, chiCNovenoRango});
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"0.9 - 1.0", fODecimoRango, fEsperada, chiCDecimoRango});
        
        Double X2Calc = chiCPrimerRango + chiCSegundoRango + chiCTercerRango + chiCCuartoRango + chiCQuintoRango + chiCSextoRango
                + chiCSeptimoRango + chiCOctavoRango + chiCNovenoRango + chiCDecimoRango;
        VistaPruebasUniformidad.modeloTablaPruebaChiCuadrado.addRow(new Object[] {"", "", "", X2Calc});
        
        double X2Crit = 16.919;
        
        if(X2Calc <= X2Crit) {
            return true;
        } else {
            return false;
        }
    }
    
    public Double calcularChiCuadrado(Integer fO, Double fE) {
        Double chiCuadrado;
        chiCuadrado = pow((fE - fO), 2) / fE;
        return chiCuadrado;
    }
}
