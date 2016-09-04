package seedu.addressbook.parser;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NameIsSimilarTest {

    Name name1;
    Name name2;
    Name name3;
    
    @Before 
    public void setup() throws IllegalValueException{
        name1 = new Name("John");
        name2 = new Name("jOhN");
        name3 = new Name("john doe");
    }
    
    @Test
    public void null_returnsFalse(){
        assertFalse(name1.isSimilar(null));
    }
    
    @Test
    public void sameName_returnsTrue(){
        assertTrue(name1.isSimilar(name1));
    }
    
    @Test
    public void sameLetterDiffCase_returnsTrue(){
        assertTrue(name1.isSimilar(name2));
    }
    
    @Test
    public void containSameWords_returnsTrue(){
        assertTrue(name1.isSimilar(name3));
    }
    
}
