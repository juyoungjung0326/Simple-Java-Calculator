package simplejavacalculator;

import static java.lang.Double.NaN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	// 1
	@Test
	public void testSciConversion() {
		Calculator calc = new Calculator();
		Assertions.assertEquals("1.300e+02", calc.sciConversion(130.0));
	}

	// Bi Tests
	
	// 2
	@Test
	public void testCalculateBiNormal() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.normal, 4.0);
		Assertions.assertEquals(NaN, calc.calculateBi(Calculator.BiOperatorModes.normal, 5.0));
	}
	
	// 3
	@Test
	public void testCalculateBiAdd() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.add, 14.0);
		Assertions.assertEquals(17.6, calc.calculateBi(Calculator.BiOperatorModes.add, 3.6));
	}
	
	// 4
	@Test
	public void testCalculateBiSubtract() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.minus, 19.0);
		Assertions.assertEquals(11.5, calc.calculateBi(Calculator.BiOperatorModes.minus, 7.5));
	}
	
	// 5
	@Test
	public void testCalculateBiMultiply() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.multiply, 4.0);
		Assertions.assertEquals(20.0, calc.calculateBi(Calculator.BiOperatorModes.multiply, 5.0));
	}
	
	// 6
	@Test
	public void testCalculateBiDivide() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.divide, 21.0);
		Assertions.assertEquals(3.0, calc.calculateBi(Calculator.BiOperatorModes.divide, 7.0));
	}
	
	// 7
	@Test
	public void testCalculatePow() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 2.0);
		Assertions.assertEquals(16.0, calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, 4.0));
	}
	
	// 8
	@Test
	public void testCalculateBiModulus() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.modulus, 10.0);
		Assertions.assertEquals(1.0, calc.calculateBi(Calculator.BiOperatorModes.modulus, 3.0));
	}
	
	// 9
	@Test
	public void testCalculateBiNthRoot() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.nthroot, 27.0);
		Assertions.assertEquals(3.0, calc.calculateBi(Calculator.BiOperatorModes.nthroot, 3.0));
	}
	
	// Mono Tests
	
	// 10
	@Test
	public void testCalculateMonoSquare() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(36.0, calc.calculateMono(Calculator.MonoOperatorModes.square, 6.0));
	}
	
	// 11
	@Test
	public void testCalculateMonoSqrRoot() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(4.0, calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, 16.0));
	}
	
	// 12
	@Test
	public void testCalculateMonoReciprocal() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(0.5, calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, 2.0));
	}
	
	// 13
	@Test
	public void testCalculateMonoCos() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(0.5, calc.calculateMono(Calculator.MonoOperatorModes.cos, 60.0));
	}
	
	// 14
	@Test
	public void testCalculateMonoSin() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(0.5, calc.calculateMono(Calculator.MonoOperatorModes.sin, 30.0));
	}
	
	// 15
	@Test
	public void testCalculateMonoTan180() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(0.0, calc.calculateMono(Calculator.MonoOperatorModes.tan, 180.0));
	}
	
	// 16
	@Test
	public void testCalculateMonoTanNaN() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(NaN, calc.calculateMono(Calculator.MonoOperatorModes.tan, 90.0));
	}
	
	// 17
	@Test
	public void testCalculateMonoTan() {
		Calculator calc = new Calculator();
		Assertions.assertEquals(1.73, calc.calculateMono(Calculator.MonoOperatorModes.tan, 60.0));
	}
	
	// 18
	@Test
	public void testCalculateMonoLog() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 19
	@Test
	public void testCalculateMonoRate() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 20
	@Test
	public void testCalculateMonoAbs() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 21
	@Test
	public void testCalculateMonoArcCos() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 22
	@Test
	public void testCalculateMonoArcSin() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 23
	@Test
	public void testCalculateMonoArcTan() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 24
	@Test
	public void testCalculateMonoNatLog() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 25
	@Test
	public void testCalculateMonoEuler() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 26
	@Test
	public void testCalculateMonoNegation() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 27
	@Test
	public void testCalculateMonoPercent() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}
	
	// 28
	@Test
	public void testCalculateMonoDegrees() {
		Calculator calc = new Calculator();
		//Assertions.assertEquals();
	}

	// 29
	@Test
	public void testCalculateEqual() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.add, 4.0);
		calc.calculateBi(Calculator.BiOperatorModes.add, 5.0);
		Assertions.assertEquals(11.0, calc.calculateEqual(2.0));
	}

	// 30
	@Test
	public void testReset() {
		Calculator calc = new Calculator();
		calc.calculateBi(Calculator.BiOperatorModes.add, 14.0);
		Assertions.assertEquals(17.6, calc.calculateBi(Calculator.BiOperatorModes.add, 3.6));
		Assertions.assertEquals(NaN, calc.reset());
	}

}
