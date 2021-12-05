/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        Main.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

// Adapted for use from https://github.com/pH-7/Simple-Java-Calculator

package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import java.lang.Math;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy, modulus,nthroot, npr,ncr 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan ,log , rate,
        abs, acos, asin, atan, natlog, euler, sci, negation, percent, todeg,
        factorial
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        }
        // --------------------------NEW
        if(mode == BiOperatorModes.modulus)
        {
        	return num1 % num2;
        }
        if(mode == BiOperatorModes.nthroot)
        {
        	return Math.pow(num1, 1.0/num2);
        }
        
        if(mode == BiOperatorModes.npr)
        {
        	int n = num1.intValue();
        	int r = num2.intValue();
        	int i, fact = 1, fact2 = 1;
        	
        	if(r > n)
        	{
        		return NaN;
        	}
        	
        	for(i = 1; i <= n; i++)
        	{
        		fact = fact * i;
        	}
        	
        	for(i = 1; i <= (n - r); i++)
        	{
        		fact2 = fact2 * i;
        	}
        	
        	Double dTop = Double.valueOf(fact);
        	Double dBot = Double.valueOf(fact2);
        	Double val = dTop / dBot;
        	
        	return val;
        	
        	
        }
        
        if(mode == BiOperatorModes.ncr)
        {
        	int n = num1.intValue();
        	int r = num2.intValue();
        	int i, fact = 1, fact2 = 1, fact3 = 1;
        	
        	if(r > n)
        	{
        		return NaN;
        	}
        	
        	for(i = 1; i <= n; i++)
        	{
        		fact = fact * i;
        	}
        	
        	for(i = 1; i <= (n - r); i++)
        	{
        		fact2 = fact2 * i;
        	}
        	
        	for(i = 1; i <= r; i++)
        	{
        		fact3 = fact3 * i;
        	}
        	
        	Double dTop = Double.valueOf(fact);
        	Double dBot = Double.valueOf(fact2);
        	Double dr = Double.valueOf(fact3);
        	Double val = dTop / (dBot * dr);
        	
        	return val;
        	
        	
        }
        // -------------------------- END

        // never reach (error)
        return NaN;
    }
    
    // converter from eng to sci
    public String sciConversion(Double num)
    {
    	return String.format("%6.3e", num);
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDividedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.round(Math.cos(Math.toRadians(num)) * 100.0) / 100.0;
        }
        if (newMode == MonoOperatorModes.sin) {
        	return Math.round(Math.sin(Math.toRadians(num)) * 100.0) / 100.0;
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }

            return Math.round(Math.tan(Math.toRadians(num)) * 100.0) / 100.0;
        }
        if (newMode == MonoOperatorModes.log) {
        	if(num == 0)
        		return NaN;
        		
            return log10(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.abs){
            return Math.abs(num);
        }
        
     // --------------------------NEW
        if( newMode == MonoOperatorModes.acos)
        {
        	return Math.round(Math.toDegrees(Math.acos(num)) * 100.0) / 100.0;
        }
        if( newMode == MonoOperatorModes.asin)
        {
        	return Math.round(Math.toDegrees(Math.asin(num)) * 100.0) / 100.0;
        }
        if( newMode == MonoOperatorModes.atan)
        {
        	return Math.round(Math.toDegrees(Math.atan(num)) * 100.0) / 100.0;
        }
        if( newMode == MonoOperatorModes.natlog)
        {
        	if(num==0)
        		return NaN;
        	
        	return Math.log(num);
        }
        
        if( newMode == MonoOperatorModes.euler)
        {
        	return Math.exp(num);
        }
        
        if(newMode == MonoOperatorModes.negation)
        {
        	return num * -1;
        }
        
        if(newMode == MonoOperatorModes.percent)
        {
        	return num * 100;
        }
        
        if(newMode == MonoOperatorModes.todeg)
        {
        	return Math.toDegrees(num);
        }
        
        if(newMode == MonoOperatorModes.factorial)
        {
        	if(num == 0 )
        		return 1.0;
        	if(num == 1 || num == 2)
        		return num;
        	
        	int i, fact = 1;
        	
        	int value = num.intValue();
        	
        	for(i = 1; i <= value; i++)
        	{
        		fact = fact * i;
        	}
        	
        	
        	Double d = Double.valueOf(fact);
        	
        	return d;
        	
        }
        // --------------------------END
        // never reach (error)
        return NaN;
    }
    
}
