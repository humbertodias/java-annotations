
import static org.junit.Assert.*;

import com.annotation.VideoRental;
import com.inject.ExampleModule;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class VideoRentalTest {

    @Inject
    private VideoRental videoRental;

    @Before
    public void setup() {
        Injector injector = Guice.createInjector(new ExampleModule());
        injector.injectMembers(this);
    }

    @Test
    public void testRentMovie() {
        assertTrue(videoRental.rentMovie(1));
    }

    @Test
    public void testRegisterNewMovie() {
        assertTrue(videoRental.registerNewMovie("The Fugitive"));
    }

}