/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniformidad;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vista.VistaPrincipal;
import vista.VistaPruebasUniformidad;

/**
 *
 * @author jsnar
 */
public class PruebaKolmogorovSmirnov {
    
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
        
        Integer fOAPrimerRango = fOPrimerRango;
        Integer fOASegundoRango = fOAPrimerRango + fOSegundoRango;
        Integer fOATercerRango = fOASegundoRango + fOTercerRango;
        Integer fOACuartoRango = fOATercerRango + fOCuartoRango;
        Integer fOAQuintoRango = fOACuartoRango + fOQuintoRango;
        Integer fOASextoRango = fOAQuintoRango + fOSextoRango;
        Integer fOASeptimoRango = fOASextoRango + fOSeptimoRango;
        Integer fOAOctavoRango = fOASeptimoRango + fOOctavoRango;
        Integer fOANovenoRango = fOAOctavoRango + fONovenoRango;
        Integer fOADecimoRango = fOANovenoRango +fODecimoRango;
        
        Integer cantidadNumerosGeneradosInteger = VistaPrincipal.listaNumerosGenerados.size();
        Double cantidadNumerosGenerados = cantidadNumerosGeneradosInteger.doubleValue();
        
        Double pOAPrimerRango = fOAPrimerRango / cantidadNumerosGenerados;
        Double pOASegundoRango = fOASegundoRango / cantidadNumerosGenerados;
        Double pOATercerRango = fOATercerRango / cantidadNumerosGenerados;
        Double pOACuartoRango = fOACuartoRango / cantidadNumerosGenerados;
        Double pOAQuintoRango = fOAQuintoRango / cantidadNumerosGenerados;
        Double pOASextoRango = fOASextoRango / cantidadNumerosGenerados;
        Double pOASeptimoRango = fOASeptimoRango / cantidadNumerosGenerados;
        Double pOAOctavoRango = fOAOctavoRango / cantidadNumerosGenerados;
        Double pOANovenoRango = fOANovenoRango / cantidadNumerosGenerados;
        Double pOADecimoRango = fOADecimoRango / cantidadNumerosGenerados;
        
        Double fEsperada = cantidadNumerosGenerados / 10.0;
        Double pEsperada = fEsperada /cantidadNumerosGenerados;
        
        Double pEAPrimerRango = pEsperada;
        Double pEASegundoRango = pEsperada*2;
        Double pEATercerRango = pEsperada*3;
        Double pEACuartoRango = pEsperada*4;
        Double pEAQuintoRango = pEsperada*5;
        Double pEASextoRango = pEsperada*6;
        Double pEASeptimoRango = pEsperada*7;
        Double pEAOctavoRango = pEsperada*8;
        Double pEANovenoRango = pEsperada*9;
        Double pEADecimoRango = pEsperada*10;
        
        List<Double> pEAmenospOA = new ArrayList<>();
        pEAmenospOA.add(abs(pEAPrimerRango - pOAPrimerRango));
        pEAmenospOA.add(abs(pEASegundoRango - pOASegundoRango));
        pEAmenospOA.add(abs(pEATercerRango - pOATercerRango));
        pEAmenospOA.add(abs(pEACuartoRango - pOACuartoRango));
        pEAmenospOA.add(abs(pEAQuintoRango - pOAQuintoRango));
        pEAmenospOA.add(abs(pEASextoRango - pOASextoRango));
        pEAmenospOA.add(abs(pEASeptimoRango - pOASeptimoRango));
        pEAmenospOA.add(abs(pEAOctavoRango - pOAOctavoRango));
        pEAmenospOA.add(abs(pEANovenoRango - pOANovenoRango));
        pEAmenospOA.add(abs(pEADecimoRango - pOADecimoRango));
        
        double DMCalc = Collections.max(pEAmenospOA);
        
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.0 - 0.1", fOPrimerRango, fOAPrimerRango, pOAPrimerRango, pEAPrimerRango, pEAmenospOA.get(0)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.1 - 0.2", fOSegundoRango, fOASegundoRango, pOASegundoRango, pEASegundoRango, pEAmenospOA.get(1)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.2 - 0.3", fOTercerRango, fOATercerRango, pOATercerRango, pEATercerRango, pEAmenospOA.get(2)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.3 - 0.4", fOCuartoRango, fOACuartoRango, pOACuartoRango, pEACuartoRango, pEAmenospOA.get(3)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.4 - 0.5", fOQuintoRango, fOAQuintoRango, pOAQuintoRango, pEAQuintoRango, pEAmenospOA.get(4)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.5 - 0.6", fOSextoRango, fOASextoRango, pOASextoRango, pEASextoRango, pEAmenospOA.get(5)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.6 - 0.7", fOSeptimoRango, fOASeptimoRango, pOASeptimoRango, pEASeptimoRango, pEAmenospOA.get(6)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.7 - 0.8", fOOctavoRango, fOAOctavoRango, pOAOctavoRango, pEAOctavoRango, pEAmenospOA.get(7)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.8 - 0.9", fONovenoRango, fOANovenoRango, pOANovenoRango, pEANovenoRango, pEAmenospOA.get(8)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"0.9 - 1.0", fODecimoRango, fOADecimoRango, pOADecimoRango, pEADecimoRango, pEAmenospOA.get(9)});
        VistaPruebasUniformidad.modeloTablaPruebaKolmogorovSmirnov.addRow(new Object[] {"", "", "", "", "DMCalc", DMCalc});
        
        double DMCrit = 1.358 / sqrt(cantidadNumerosGenerados);
        
        if(DMCalc <= DMCrit) {
            return true;
        } else {
            return false;
        }
    }
}
