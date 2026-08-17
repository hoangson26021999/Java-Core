package oop.interfaces;

/**
 * Demonstrates interface inheritance — an interface extending another interface.
 *
 * Key concepts:
 *   - An interface can extend one or more other interfaces.
 *   - A class implementing Valid is required to implement ALL methods from
 *     BOTH Valid and DoItInterface (the full contract is inherited).
 *   - An empty extending interface is known as a marker interface.
 *     Classic examples from the JDK: Serializable, Cloneable.
 */
public interface ValidInterface extends DoItInterface {
    // No new methods added here.
    // This acts as a marker that groups implementors as "valid" DoIt objects.
    // Any class implementing ValidInterface must still fulfill DoItInterface's contract.
}
