package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postal;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        String[] parts = address.split(", ");
        
        block = new Block();
        street = new Street();
        unit = new Unit();
        postal = new PostalCode();
        
        this.block.setBlock(parts[0]);
        this.street.setStreet(parts[1]);
        this.unit.setUnit(parts[2]);
        this.postal.setPostal(parts[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postal.getPostal();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.getBlock().equals( ((Address) other).block.getBlock() )
                && this.street.getStreet().equals( ((Address) other).street.getStreet() )
                && this.unit.getUnit().equals( ((Address) other).unit.getUnit() )
                && this.postal.getPostal().equals( ((Address) other).postal.getPostal() )
                ); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}