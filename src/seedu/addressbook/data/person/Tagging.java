package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;

public class Tagging {

    private Tag tag;
    private Person person;
    private boolean isAddedNotDeleted; // if true, then the tag was added. if false, tag was deleted.
    
    public Tagging(Tag tag, Person person, boolean isAdded){
        this.tag = tag;
        this.person = person;
        this.isAddedNotDeleted = isAdded;
    }
    
    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public String toString(){
        if (isAddedNotDeleted){
            return "+ " + person.toString() + " " + tag.toString();
        }
        else{
            return "- " + person.toString() + " " + tag.toString();
        }
    }
    
}
