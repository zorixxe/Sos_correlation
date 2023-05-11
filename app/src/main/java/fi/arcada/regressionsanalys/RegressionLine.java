package fi.arcada.regressionsanalys;

public class RegressionLine {





 private    double cxy, cx, cy, cn, cx2, cy2, k, m , corrco, size = 0;

    public RegressionLine(double[] xData, double[] yData, double height) {

        cn = xData.length;

        for (int i = 0; i < xData.length; i++) {

            double jxy = xData[i] * yData[i];
            cxy += jxy;

            double jx = Math.pow(xData[i], 2);
            cx2 += jx;

            double jy = Math.pow(yData[i], 2);
            cy2 += jy;

            cx +=  xData[i];
            cy += yData[i];



        }

        corrco = (cn*cxy - (cx * cy))/Math.sqrt((cn * cx2 - Math.pow(cx, 2)) * (cn * cy2 - Math.pow(cy, 2)));
        k = ((cn * cxy) - (cx * cy))/((cn * cx2) - Math.pow(cx, 2));
        m = (cy/cn) - (k * (cx/cn));

        size = (height - m)/k;




    }



    // deklarera k, m, x  och correlationCoefficient som double

    // Skapa en konstruktor som tar emot data-arrays för x och y
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)

    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad

    public double getCorrco() {
        return corrco;
    }

    public double getSize() {
        return size;
    }

    public String getCorrcoGrade(){
        String corrcoGrade = null;
        if(corrco<0.20){corrcoGrade="(none)";}
        if(corrco>0.20&&corrco<0.40){corrcoGrade="(low)";}
        if(corrco>0.40&&corrco<0.60){corrcoGrade="(moderate)";}
        if(corrco>0.60&&corrco<0.80){corrcoGrade="(high)";}
        if(corrco>0.80){corrcoGrade="(perfect)";}



        return corrcoGrade;
    }
}