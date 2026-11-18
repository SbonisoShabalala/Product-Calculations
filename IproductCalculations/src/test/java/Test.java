import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculationsTest {
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations c = new ProductCalculations(3500);
        assertEquals(525.0, c.GetVat(), 0.01);
    }
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations c = new ProductCalculations(3500);
        assertEquals(4200.0, c.GetTotal(), 0.01);
    }
}