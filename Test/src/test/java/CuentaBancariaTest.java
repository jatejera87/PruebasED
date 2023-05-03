import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CuentaBancariaTest.DepositoTest.class,
        CuentaBancariaTest.RetiroTest.class,
        CuentaBancariaTest.InteresTest.class
})
public class CuentaBancariaTest {

    public static class DepositoTest {
        private CuentaBancaria cuenta;

        @Before
        public void setUp() {
            cuenta = new CuentaBancaria(1000, 0.01);
        }

        @Test
        public void testDepositoValido() {
            cuenta.deposito(500);
            assertEquals(1500, cuenta.getSaldo(), 0.001);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testDepositoNegativo() {
            cuenta.deposito(-500);
        }
    }

    public static class RetiroTest {
        private CuentaBancaria cuenta;

        @Before
        public void setUp() {
            cuenta = new CuentaBancaria(1000, 0.01);
        }

        @Test
        public void testRetiroValido() {
            cuenta.retiro(500);
            assertEquals(500, cuenta.getSaldo(), 0.001);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testRetiroNegativo() {
            cuenta.retiro(-500);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testRetiroExcesivo() {
            cuenta.retiro(1500);
        }
    }

    public static class InteresTest {
        private CuentaBancaria cuenta;

        @Before
        public void setUp() {
            cuenta = new CuentaBancaria(1000, 0.01);
        }

        @Test
        public void testInteres() {
            cuenta.aplicarInteres();
            assertEquals(1010, cuenta.getSaldo(), 0.001);
        }
    }
}
