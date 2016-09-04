package seedu.addressbook.parser;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NameIsSimilarTest {

    Name name1;
    
    @Before 
    public void setup() throws IllegalValueException{
        name1 = new Name("John");
    }
    
    @Test
    public void null_returnsFalse(){
        assertFalse(name1.isSimilar(null));
    }
        
    
}
