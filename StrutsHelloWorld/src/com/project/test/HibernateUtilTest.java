


public class HibernateUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreationClientIdFail() throws Exception {
        new Geocoder("someClientId", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationClientKeyFail() throws Exception {
        new Geocoder("", "someClientKey");
    }

}