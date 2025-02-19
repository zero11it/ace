package de.f0rce.ace.util;

import java.io.Serializable;

import de.f0rce.ace.events.AceBlurChanged;
import de.f0rce.ace.events.AceForceSyncDomEvent;
import de.f0rce.ace.events.AceSelectionChanged;
import elemental.json.JsonObject;

/** @author David "F0rce" Dodlek */
public class AceCursorPosition implements Serializable {
  private static final long serialVersionUID = -7196877713512018421L;
  
  private int row;
  private int column;
  private int index;

  /** Default Constructor to have valid values on initializing. */
  public AceCursorPosition() {
    this.row = 0;
    this.column = 0;
    this.index = 0;
  }

  /**
   * Constructor for initializing the values directly from the frontend (only used in {@link
   * AceBlurChanged}, {@link AceSelectionChanged}, {@link AceForceSyncDomEvent}).
   *
   * @param cursorObject {@link JsonObject}
   */
  public AceCursorPosition(JsonObject cursorObject) {
    this.row = (int) cursorObject.getNumber("row");
    this.column = (int) cursorObject.getNumber("column");
    this.index = (int) cursorObject.getNumber("index");
  }

  /**
   * Returns the row where the selection starts.
   *
   * @return int
   */
  public int getRow() {
    return this.row;
  }

  /**
   * Returns the column where the selection starts.
   *
   * @return int
   */
  public int getColumn() {
    return this.column;
  }

  /**
   * Returns the index where the selection starts (calculation done in the frontend).
   *
   * @return int
   */
  public int getIndex() {
    return this.index;
  }

  /**
   * Check if one instance of the {@link AceCursorPosition} is equal to another.
   *
   * @param a {@link AceCursorPosition}
   * @return boolean
   */
  public boolean compareTo(AceCursorPosition a) {
    return a.getRow() == this.row && a.getColumn() == this.column && a.getIndex() == this.index;
  }
}
